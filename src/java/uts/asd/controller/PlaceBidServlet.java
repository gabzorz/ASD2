/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.asd.model.Auction_Item;
import uts.asd.model.Bid;
import uts.asd.model.dao.AccessDBManager;

/**
 *
 * @author Hamish Lamond
 */
public class PlaceBidServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get session
        HttpSession session = request.getSession();
        AuctionValidator validator = new AuctionValidator();

        //all the textfields in the createAuction.jsp
        String newBidStr = request.getParameter("newBid");
        Auction_Item auction = (Auction_Item) session.getAttribute("auction");
        int startPrice = auction.getStartingPrice();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        int topBid = 0;
        try {
            topBid = manager.readHighestBid(auction.getItemID());
        } catch (SQLException ex) {
            Logger.getLogger(PlaceBidServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        validator.clear(session);
        
        if (validator.checkPlaceBidIsEmpty(newBidStr)) {
            session.setAttribute("bidErr", "Please enter a bid.");
            request.getRequestDispatcher("auctionPage.jsp").include(request, response);
        } else if (!validator.validateNumber(newBidStr)) {
            session.setAttribute("bidErr", "Error: Bid number format is incorrect");
            request.getRequestDispatcher("auctionPage.jsp").include(request, response);
        } else if (Integer.parseInt(newBidStr) <= startPrice) {
            session.setAttribute("bidErr", "Error: Bid must be higher than Auction start price");
            request.getRequestDispatcher("auctionPage.jsp").include(request, response);
        } else if (Integer.parseInt(newBidStr) <= topBid) {
            session.setAttribute("bidErr", "Error: Bid must be higher than current top bid");
            request.getRequestDispatcher("auctionPage.jsp").include(request, response);
        } else {
            try {
                manager.createBid(auction.getItemID(), 8, Integer.parseInt(newBidStr));
                Bid bid = new Bid(auction.getItemID(), 8, Integer.parseInt(newBidStr));
                session.setAttribute("topBid", bid);
                //Auction_Item auction = new Auction_Item(startDate, startTime, endDate, endTime, Integer.parseInt(reservePrice), Integer.parseInt(startPrice), "ongoing");
                //session.setAttribute("auction", auction);
               request.getRequestDispatcher("auctionPage.jsp").include(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

}
