/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller;

import java.io.IOException;
import java.sql.Date;
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
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //get session
        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        HelpTicketValidator validator = new HelpTicketValidator();
        
        
        //Fields in editHelpTicket
        String StatusInput = request.getParameter("ticketstatusselect");
        String ResponseInput = request.getParameter("response");
        String HelpTicketId = request.getParameter("helpticketid");
        int HelpTicketInput = Integer.parseInt(HelpTicketId);
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        Date date = new Date(session.getLastAccessedTime());
        
        validator.clear(session);
        
            try {
                if (validator.checkIsEmpty2(ResponseInput)) {
                    session.setAttribute("ticketdetailsErr", "Please fill in the response");
                    response.sendRedirect("EditTicketServlet?Ticketid="+HelpTicketInput);
                }
                else if(StatusInput.equals("Complete")) {
                    manager.updateHelpTicketComplete(StatusInput, ResponseInput, userId, date, HelpTicketInput);
                    session.setAttribute("ticketdetailsErr", "Submitted");
                    response.sendRedirect("EditTicketServlet?Ticketid="+HelpTicketInput);
                } 
                else if(StatusInput.equals("Assigned")){
                    manager.updateHelpTicketAssigned(StatusInput, ResponseInput, userId, HelpTicketInput);
                    session.setAttribute("ticketdetailsErr", "Submitted");
                    response.sendRedirect("EditTicketServlet?Ticketid="+HelpTicketInput);
                }
                
            }
            catch (SQLException ex) {
                Logger.getLogger(HelpTicketUserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
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
        
        