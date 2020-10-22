/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.asd.model.User;
import uts.asd.model.dao.AccessDBManager;

/**
 *
 * @author Sean
 */

public class HelpTicketSendServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //get session
        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        
        //Fields in sendHelpTicket
        String CategoryInput = request.getParameter("ticketcategoryselect");
        String DetailsInput = request.getParameter("htdetails");
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        Date date = new Date(session.getLastAccessedTime());
        try {
            manager.createHelpTicket(CategoryInput, DetailsInput, userId, date);
            request.getRequestDispatcher("sendHelpTicket.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HelpTicketSendServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 }
        