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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CalculatorValidator validator = new CalculatorValidator();

        String propertyPrice = request.getParameter("estPropertyPrice");
        String loanAmt = request.getParameter("outstandingLoanAmt");

        validator.clear(session);

        if (validator.equityEmptyInput(loanAmt, propertyPrice)) {
            session.setAttribute("inputErr", "Please fill in every textbox");
            request.getRequestDispatcher("equity.jsp").include(request, response);

        } else if (validator.equityPositive(propertyPrice, loanAmt)) {
            session.setAttribute("inputErr", "Please enter a positive number");
            request.getRequestDispatcher("equity.jsp").include(request, response);

        } else if (validator.equityValidate(propertyPrice, loanAmt)) {
            session.setAttribute("inputErr", "Property price must be higher than loan amount");
            request.getRequestDispatcher("equity.jsp").include(request, response);

        } else {

            double price = Double.parseDouble(propertyPrice);
            double loan = Double.parseDouble(loanAmt);

            double equity = price - loan;

            request.setAttribute("equity", equity);
            request.getRequestDispatcher("equity.jsp").include(request, response);

        }

    }

}
