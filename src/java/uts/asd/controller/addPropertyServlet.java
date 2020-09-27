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
public class addPropertyServlet extends HttpServlet {
  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get session
        HttpSession session = request.getSession();

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
        
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");

        User user = (User) session.getAttribute("user");
        String email = "corey@gmail.com";
        if(user != null) {
            email = user.getEmailAddress();
        }

      try {
          manager.addProperty(suburb,address,postcode,state,desc,bathroom,bedroom,garage,email);
          
      } catch (SQLException ex) {
          Logger.getLogger(addPropertyServlet.class.getName()).log(Level.SEVERE, null, ex);
      }
        //User customer = new User(fname, lname, address, dob, email, number, password, 3);
        //session.setAttribute("user", customer);
        request.getRequestDispatcher("homepage.jsp").include(request, response);

        }
      
}
