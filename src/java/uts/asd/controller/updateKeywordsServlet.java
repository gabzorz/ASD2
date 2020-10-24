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
import uts.asd.model.Keywords;
import uts.asd.model.User;
import uts.asd.model.dao.AccessDBManager;

/**
 *
 * @author Corey
 */
public class updateKeywordsServlet extends HttpServlet {
  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get session
        HttpSession session = request.getSession();

        //fix the numbers null exception
        String bathroom = request.getParameter("bathroom");
        
        String bedroom = request.getParameter("bedroom");
        
        String garage = request.getParameter("garage");

            int bathroomInt = Integer.parseInt(bathroom);

            int bedroomInt = Integer.parseInt(bedroom);

            int garageInt = Integer.parseInt(garage);
 
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");

        User user = (User) session.getAttribute("user");
        int userID = user.getUserId();

      try {
          Keywords keywords = manager.updateKeywords(userID,bathroomInt,bedroomInt,garageInt);
          if (keywords != null) {
          session.setAttribute("keywords", keywords);
          }
          request.getRequestDispatcher("homepage.jsp").include(request, response);
      } catch (SQLException ex) {
          Logger.getLogger(updateKeywordsServlet.class.getName()).log(Level.SEVERE, null, ex);
      }
        //User customer = new User(fname, lname, address, dob, email, number, password, 3);
        //session.setAttribute("user", customer);
        //request.getRequestDispatcher("homepage.jsp").include(request, response);

        }
      
}

