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
import uts.asd.model.User;
import uts.asd.model.dao.AccessDBManager;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import uts.asd.model.Property;

/**
 *
 * @author Hamish Lamond
 */
public class CancelOpenDayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get session
        HttpSession session = request.getSession();

        int bookingId = Integer.parseInt(request.getParameter("bId"));
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        User staff = (User) session.getAttribute("user");
        Property property = (Property) session.getAttribute("property");

        try {
            Open_Day_Booking booking = manager.getOpenDayListing(bookingId);
            int bookedUserId = booking.getUserID();
            if (bookedUserId > 0) {
                //sendCancelEmail(staff, bookedUserId, manager, property, booking.getDate());
            }
            manager.deleteOpenDayListing(booking.getBookingID());
            session.removeAttribute("booking");
            request.getRequestDispatcher("ViewOpenDayListServlet?id=" + property.getId()).include(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get session
        HttpSession session = request.getSession();

        Open_Day_Booking booking = (Open_Day_Booking) session.getAttribute("booking");
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        User staff = (User) session.getAttribute("user");
        Property property = (Property) session.getAttribute("property");

        try {
            int bookedUserId = booking.getUserID();
            if (bookedUserId > 0) {
                //sendCancelEmail(staff, bookedUserId, manager, property, booking.getDate());
            }
            manager.deleteOpenDayListing(booking.getBookingID());
            session.removeAttribute("booking");
            request.getRequestDispatcher("ViewOpenDayListServlet").include(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    private void sendCancelEmail(User staff, int customerId, AccessDBManager manager, Property property, String date) throws SQLException {
        User customer = manager.findCustomerById(customerId);
        String customerEmail = "hamish_lamond@hotmail.co.uk";
        String staffEmail = "Hamish.Lamond@student.uts.edu.au";

        String host = "smtp-mail.outlook.com";
        String user = "hamish_lamond@hotmail.co.uk";
        String password = "Hamish1704_";
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(staffEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(customerEmail));
            message.setSubject("Open Day Booking Cancelled");
            message.setText("This email has been sent to alert you that the open day"
                    + "booked for " + property.getAddress() + ", " + property.getSuburb()
                    + " on " + date + " has been cancelled. We apologise for any"
                    + "inconvenience this may cause.");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
