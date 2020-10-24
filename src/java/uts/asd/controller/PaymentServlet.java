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

/**
 *
 * @author CristinaFidelino
 */
public class PaymentServlet extends HttpServlet{
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            PaymentDAO pyd = (PaymentDAO) session.getAttribute("pyd");
            Payment payment = (Payment) session.getAttribute("payment");
            int id = payment.getPaymentID();
            
            try {
                ArrayList<Payment> payments = pyd.searchPayment(id);
                request.setAttribute("payment", payments);
                request.getRequestDispatcher("payment_edit.jsp").include(request, response);
            } catch (SQLException e){
               throw new ServletException("Cannot obtain payments from Database", e); 
            }
        }
}