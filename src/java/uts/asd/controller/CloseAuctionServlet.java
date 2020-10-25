/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
public class CloseAuctionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        String propertyIdString = request.getParameter("id");
        int propertyId = Integer.parseInt(propertyIdString);

        try {
            int topBid = 0;
            int auctionId = manager.getAuctionId(propertyId);
            Auction_Item auction = manager.getAuctionItem(auctionId);
            int reservePrice = auction.getReservePrice();
            LocalDateTime startDateTime = LocalDateTime.parse(auction.getStartDate() + "T" + auction.getStartTime());
            LocalDateTime endDateTime = LocalDateTime.parse(auction.getEndDate() + "T" + auction.getEndTime());
            LocalDateTime currentDateTime = LocalDateTime.now();
            if (currentDateTime.isAfter(endDateTime)) {
                topBid = manager.readHighestBid(auction.getItemID());
                Bid highestBid = manager.getHighestBid(auction.getItemID());
                if (highestBid != null){
                int soldTo = highestBid.getUserId();
                int soldFor = highestBid.getAmount();
                manager.updateAuctionSold(auction.getItemID(), soldTo, soldFor);
                }
                if (topBid < reservePrice) {
                    manager.updateAuctionStatus(auction.getItemID(), "Unsuccess");
                    manager.updatePropertyStatus(auction.getPropertyID(), "Unsuccessful");
                } else {
                    manager.updateAuctionStatus(auction.getItemID(), "Successful");
                    manager.updatePropertyStatus(auction.getPropertyID(), "Successful");
                }
            }
            request.getRequestDispatcher("properties.jsp").include(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(PlaceBidServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
