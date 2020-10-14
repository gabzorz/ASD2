/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.asd.model.Property;
import uts.asd.model.User;
import uts.asd.model.dao.AccessDBManager;

/**
 *
 * @author Corey
 */
public class DeletePropertyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");

            Property property = (Property) session.getAttribute("property");
            
        try {
            //delete user from the database
            manager.deleteProperty(property.getUserID());
            session.removeAttribute("property");
        } catch (SQLException ex) {
            Logger.getLogger(DeletePropertyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }


        //direct user back to the index page
        request.getRequestDispatcher("homepage.jsp").include(request, response);

    }}
    

