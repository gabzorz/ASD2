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
import lombok.SneakyThrows;
import uts.asd.model.User;
import uts.asd.model.*;
import uts.asd.model.dao.AccessDBManager;

/**
 *
 * @author Corey
 */
public class UpdatePropertyServlet extends HttpServlet {
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        Property oldProperty = (Property) session.getAttribute("property");  
        
        //all the textfields in the register.jsp
        String suburb = request.getParameter("suburb");
        String address = request.getParameter("address");
        String postcode = request.getParameter("postcode");
        String state = request.getParameter("state");
        String desc = request.getParameter("desc");
        //fix the numbers null exception
        String bathroom = request.getParameter("bathroom");
        String bedroom = request.getParameter("bedroom");
        String garage = request.getParameter("garage");
        
        int postcodeInt = Integer.parseInt(postcode);
        int bathroomInt = Integer.parseInt(bathroom);
        int bedroomInt = Integer.parseInt(bedroom);
        int garageInt = Integer.parseInt(garage);


        Property newProperty = new Property(oldProperty.getId(), suburb, address, state, desc, oldProperty.getUserID(), postcodeInt, bathroomInt, bedroomInt, garageInt);
        
        try {
            manager.updateProperty(newProperty);
            session.setAttribute("property", newProperty);
            request.getRequestDispatcher("viewProperty.jsp").include(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(UpdatePropertyServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("homepage.jsp").include(request, response);
        }

    }}
