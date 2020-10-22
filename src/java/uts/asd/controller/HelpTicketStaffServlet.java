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

public class HelpTicketStaffServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //get session
        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        
        ArrayList<HelpTicket> pendinghelpticketslist = new ArrayList<>();
        ArrayList<HelpTicket> assignedhelpticketslist = new ArrayList<>();
        ArrayList<HelpTicket> completehelpticketslist = new ArrayList<>();
        
        String id = request.getParameter("id");
        int idint = Integer.parseInt(id);
        
        {
            try {
                pendinghelpticketslist = manager.pendingHelpTicket();
                request.setAttribute("pendinghelpticketslist", pendinghelpticketslist);
                
                assignedhelpticketslist = manager.inProgressHelpTicket(idint);
                request.setAttribute("assignedhelpticketslist", assignedhelpticketslist);
                
                completehelpticketslist = manager.completeHelpTicket();
                request.setAttribute("completehelpticketslist", completehelpticketslist);
                
                request.getRequestDispatcher("staffHelpTicket.jsp").include(request, response);} catch (SQLException ex) {
                Logger.getLogger(HelpTicketStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 }
 
        