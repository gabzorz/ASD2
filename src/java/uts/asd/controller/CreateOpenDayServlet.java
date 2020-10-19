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
public class CreateOpenDayServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get session
        HttpSession session = request.getSession();

        String startDate = request.getParameter("openDayDate");
        String startTime = request.getParameter("openDayStartTime");
        String endTime = request.getParameter("openDayEndTime");
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        Property property = (Property) session.getAttribute("property");
        User user = (User) session.getAttribute("user");

        try {
            manager.createOpenDayListing(user.getUserId(), property.getId(), startDate, startTime, endTime);
//          request.getRequestDispatcher("viewOpenDayListings.jsp").include(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
