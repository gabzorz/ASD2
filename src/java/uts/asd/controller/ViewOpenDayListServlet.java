/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.asd.model.Open_Day_Booking;
import uts.asd.model.Property;
import uts.asd.model.dao.AccessDBManager;

/**
 *
 * @author Hamish Lamond
 */
public class ViewOpenDayListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        String propertyIdString = request.getParameter("id");
        int propertyId = Integer.parseInt(propertyIdString);

        try {
            ArrayList<Open_Day_Booking> openDayBookings = manager.getAllPropertyOpenDays(propertyId);
            Property currentProperty = manager.getPropertyByID(propertyId);
            session.setAttribute("openDayBookings", openDayBookings);
            session.setAttribute("property", currentProperty);
            request.getRequestDispatcher("viewOpenDayBookings.jsp").include(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ViewOpenDayListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        Property property = (Property) session.getAttribute("property");
        int propertyId = property.getId();

        try {
            ArrayList<Open_Day_Booking> openDayBookings = manager.getAllPropertyOpenDays(propertyId);
            session.setAttribute("openDayBookings", openDayBookings);
            request.getRequestDispatcher("viewOpenDayBookings.jsp").include(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ViewOpenDayListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
