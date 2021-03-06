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
public class viewPropertyServlet extends HttpServlet {
  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get session
        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");

        User user = (User) session.getAttribute("user");

        if(user != null) { 
            try {
                session.setAttribute("property", manager.getProperty(user.getUserId()));
                
                
            } catch (SQLException ex) {
                Logger.getLogger(viewPropertyServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        }


}}