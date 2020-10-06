package uts.asd.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import java.util.logging.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.asd.model.*;
import uts.asd.model.dao.AccessDBManager;

public class CalculateEquityServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String propertyPrice = request.getParameter("estPropertyPrice");
        String loanAmt = request.getParameter("outstandingLoanAmt");
        
        double price = Double.parseDouble(propertyPrice);
        double loan = Double.parseDouble(loanAmt);
        
        double equity = price - loan;
        
        request.setAttribute("equity", equity);
        request.getRequestDispatcher("equity.jsp").include(request,response);
        //response.sendRedirect("equity.jsp");
        
        
        
        
        
    }
        
}
