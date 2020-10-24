/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.String.format;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class CreateAuctionServlet extends HttpServlet {

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
                manager.createAuctionItem(property.getId(), user.getUserId(), 7, startDate, startTime, endDate, endTime, Integer.parseInt(startPrice), Integer.parseInt(reservePrice));
                int newId = manager.readHighestAuctionId();
                Auction_Item auction = new Auction_Item(newId, startDate, startTime, endDate, endTime, Integer.parseInt(reservePrice), Integer.parseInt(startPrice), "ongoing");
                session.setAttribute("auction", auction);
                manager.updatePropertyStatus(property.getId(), "approved");
                int[] usersArray = manager.getKeywordUsers(property);
               
                session.removeAttribute("property");
                request.getRequestDispatcher("auctionPage.jsp").include(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

}
