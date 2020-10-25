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
import uts.asd.model.dao.AccessDBManager;

/**
 *
 * @author Hamish Lamond
 */
public class StartEditAuctionServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        String propertyIdString = request.getParameter("id");
        int propertyId = Integer.parseInt(propertyIdString);

        try {
            Property currentProperty = manager.getPropertyByID(propertyId);
            int auctionId = manager.getNewestAuctionIdByProperty(propertyId);
            Auction_Item currentAuction = manager.getAuctionItem(auctionId);
            session.setAttribute("property", currentProperty);
            session.setAttribute("auction", currentAuction);
            session.setAttribute("startPriceErr", Integer.toString(currentAuction.getStartingPrice()));
            session.setAttribute("reservePriceErr", Integer.toString(currentAuction.getReservePrice()));
            request.getRequestDispatcher("editAuction.jsp").include(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ViewOpenDayListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    

}
