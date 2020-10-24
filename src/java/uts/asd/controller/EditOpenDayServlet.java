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
import uts.asd.model.dao.AccessDBManager;

/**
 *
 * @author Hamish Lamond
 */
public class EditOpenDayServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        int bookingId = Integer.parseInt(request.getParameter("bId"));

        try {
            Open_Day_Booking openDayBooking = manager.getOpenDayListing(bookingId);
            session.setAttribute("openDayBooking", openDayBooking);
            request.getRequestDispatcher("editOpenDay.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditOpenDayServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
