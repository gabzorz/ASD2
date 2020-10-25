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

import uts.asd.model.dao.PaymentDAO;
import uts.asd.model.Payment;
import uts.asd.model.dao.DBConnector;
import java.sql.Connection;
import java.util.ArrayList;
import uts.asd.model.User;

/**
 *
 * @author CristinaFidelino
 */
public class PaymentAddServlet  extends HttpServlet{
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            PaymentDAO pyd = (PaymentDAO) session.getAttribute("pyd");
            //int paymentID = Integer.parseInt(request.getParameter("paymentID"));
            int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
            int bsb = Integer.parseInt(request.getParameter("bsb"));
            User user = (User) session.getAttribute("user");
            String firstName = user.getfName();
            String lastName = user.getlName();
            int userId = user.getUserId();
            
            
            
            try {
                pyd.addPayment(userId, firstName, lastName, accountNumber, bsb);
                response.sendRedirect("CustomerEditServlet?email='"+user.getEmailAddress()+"'&password='"+user.getPassword()+"'");
            } catch (SQLException e){
               throw new ServletException("Cannot add payment to Database", e); 
            }
        }
}