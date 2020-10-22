/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.asd.model.HelpTicket;
import uts.asd.model.Property;
import uts.asd.model.User;
import uts.asd.model.dao.AccessDBManager;

/**
 *
 * @author Sean
 */

public class EditTicketServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //get session
        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        
        String id = request.getParameter("Ticketid");
        int idint = Integer.parseInt(id);
        
        try {
            HelpTicket helpticket = manager.staffFindHelpTicket(idint);
            int UserID = helpticket.getUserId();
            User userView = manager.getUser(UserID);
            session.setAttribute("edithelpticket", helpticket);
            session.setAttribute("userView", userView);
            request.getRequestDispatcher("editHelpTicket.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 }
        
        