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
import uts.asd.model.Property;
import uts.asd.model.dao.AccessDBManager;

/**
 *
 * @author Hamish Lamond
 */
public class JoinAuctionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        String propertyIdString = request.getParameter("id");

        int topBid = 0;
        if (propertyIdString != null) {
            int propertyId = Integer.parseInt(propertyIdString);
            try {
                Property property = manager.getPropertyByID(propertyId);
                int auctionId = manager.getNewestAuctionIdByProperty(propertyId);
                Auction_Item auction = manager.getAuctionItem(auctionId);
                topBid = manager.readHighestBid(auction.getItemID());
                if (auction != null) {
                    session.setAttribute("property", property);
                    session.setAttribute("auction", auction);
                    session.setAttribute("bidErr", "");
                    int auctionStartingPrice = auction.getStartingPrice();
                    if (auctionStartingPrice > topBid){
                        topBid = auctionStartingPrice;
                    }
                    Bid bid = new Bid(auction.getItemID(), 0, topBid);
                    session.setAttribute("topBid", bid);
                    request.getRequestDispatcher("auctionPage.jsp").include(request, response);
                } else {
                    request.getRequestDispatcher("homepage.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(JoinAuctionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get session
        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");

        String propertyIdString = request.getParameter("propertyId");

        if (propertyIdString != null) {
            int propertyId = Integer.parseInt(propertyIdString);
            try {
                Auction_Item auction = manager.getAuctionItem(propertyId);
                if (auction != null) {
                    session.setAttribute("auction", auction);
                    session.setAttribute("bidErr", "");
                    request.getRequestDispatcher("auctionPage.jsp").include(request, response);
                } else {
                    request.getRequestDispatcher("homepage.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(JoinAuctionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
