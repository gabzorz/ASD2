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
import uts.asd.model.Property;
import uts.asd.model.dao.AccessDBManager;

/**
 *
 * @author Sean
 */

public class SearchServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //get session
        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        
        //search textfield
        String SearchInput = request.getParameter("propertysearch");
        
        
        try {
            ArrayList<Property> propertieslist = new ArrayList<Property>();
            propertieslist = manager.searchProperties(SearchInput);
            request.setAttribute("propertieslist", propertieslist);
            request.getRequestDispatcher("searchlist.jsp").include(request, response);
        } catch (SQLException ex) {
            throw new ServletException("Cannot obtain properties from Database", ex);
        }
    }
 }
    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (validator.checkSearchEmpty(propertySearch)) {
            session.setAttribute("searchErr", "Error: Search format incorrect");
            request.getRequestDispatcher("search.jsp").include(request, response);
        }
        else {*/
        
        