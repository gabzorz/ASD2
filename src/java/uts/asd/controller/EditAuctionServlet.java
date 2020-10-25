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
import uts.asd.model.Property;
import uts.asd.model.User;
import uts.asd.model.dao.AccessDBManager;

/**
 *
 * @author Hamish Lamond
 */
public class EditAuctionServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //get session
        HttpSession session = request.getSession();
        AuctionValidator validator = new AuctionValidator();

        //all the textfields in the createAuction.jsp
        String startPrice = request.getParameter("startingPrice");
        String reservePrice = request.getParameter("reservePrice");
        String startDate = request.getParameter("auctionStartDate");
        String startTime = request.getParameter("auctionStartTime");
        String endDate = request.getParameter("auctionEndDate");
        String endTime = request.getParameter("auctionEndTime");
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        Property property = (Property) session.getAttribute("property");
        Auction_Item auction = (Auction_Item) session.getAttribute("auction");
        User user = (User) session.getAttribute("user");

        validator.clear(session);
        //Input validations
        if (validator.checkCreateAuctionIsEmpty(startPrice, reservePrice)) {
            session.setAttribute("empErr", "Please fill in every textfield");
            request.getRequestDispatcher("createAuction.jsp").include(request, response);
        } else if (!validator.validateNumber(startPrice)) {
            session.setAttribute("startPriceErr", "Error: Starting Price format is incorrect");
            request.getRequestDispatcher("createAuction.jsp").include(request, response);
        } else if (!validator.validateNumber(reservePrice)) {
            session.setAttribute("reservePriceErr", "Error: Reserve Price format is incorrect");
            request.getRequestDispatcher("createAuction.jsp").include(request, response);
        } else {
            try {
                manager.updateAuctionItem(auction.getItemID(), startDate, startTime, endDate, endTime, Integer.parseInt(reservePrice), Integer.parseInt(startPrice));
                auction = new Auction_Item(auction.getItemID(), startDate, startTime, endDate, endTime, Integer.parseInt(reservePrice), Integer.parseInt(startPrice), "ongoing");
                session.setAttribute("auction", auction);
                request.getRequestDispatcher("properties.jsp").include(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
}
