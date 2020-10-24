/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller;

import java.io.IOException;
import java.sql.Date;
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

public class HelpTicketUserServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //get session
        HttpSession session = request.getSession();
        HelpTicketValidator validator = new HelpTicketValidator();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        
        
        //Fields in sendHelpTicket
        String CategoryInput = request.getParameter("ticketcategoryselect");
        String DetailsInput = request.getParameter("htdetails");
        String SubjectInput = request.getParameter("subject");
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        Date date = new Date(session.getLastAccessedTime());
        
        validator.clear(session);
        
            try {
                if (validator.checkIsEmpty(SubjectInput, DetailsInput)) {
                    session.setAttribute("ticketdetailsErr", "Please fill in both Boxes");
                    session.setAttribute("subjectSaved", SubjectInput);
                    session.setAttribute("detailsSaved", DetailsInput);
                    response.sendRedirect("HelpTicketUserServlet?id="+userId);
                } else {
                    manager.createHelpTicket(CategoryInput, DetailsInput, userId, date, SubjectInput);
                    session.setAttribute("ticketdetailsErr", "Submitted");
                    response.sendRedirect("HelpTicketUserServlet?id="+userId);
                }
            } catch (SQLException ex) {
                Logger.getLogger(HelpTicketUserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //get session
        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
                
        //Fields in sendHelpTicket
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        
        {
            try {
                ArrayList<HelpTicket> senthelpticketslist = new ArrayList<HelpTicket>();
                senthelpticketslist = manager.userFindHelpTicket(userId);
                request.setAttribute("senthelpticketslist", senthelpticketslist);
                request.getRequestDispatcher("sendHelpTicket.jsp").include(request, response);} catch (SQLException ex) {
                Logger.getLogger(HelpTicketUserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 }
 
        