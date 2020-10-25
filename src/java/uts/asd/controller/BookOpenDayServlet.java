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
import uts.asd.model.Open_Day_Booking;
import uts.asd.model.Property;
import uts.asd.model.User;
import uts.asd.model.dao.AccessDBManager;

/**
 *
 * @author Hamish Lamond
 */
public class BookOpenDayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get session
        HttpSession session = request.getSession();

        int bookingId = Integer.parseInt(request.getParameter("bId"));
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        User customer = (User) session.getAttribute("user");
        Property property = (Property) session.getAttribute("property");
       
        try {
            manager.updateOpenDayListingBooked(bookingId, customer.getUserId());
            request.getRequestDispatcher("ViewOpenDayListServlet?id=" + property.getId()).include(request, response);
        } catch (SQLException ex){
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
