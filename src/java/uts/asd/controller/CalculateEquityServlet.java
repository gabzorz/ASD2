package uts.asd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CalculateEquityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        CalculatorValidator validator = new CalculatorValidator();

        //Get all the user input values
        String propertyPrice = request.getParameter("estPropertyPrice");
        String loanAmt = request.getParameter("outstandingLoanAmt");

        validator.clear(session);

        //Check if all the textboxes are filled
        if (validator.equityEmptyInput(loanAmt, propertyPrice)) {
            session.setAttribute("inputErr", "Please fill in every textbox");
            request.getRequestDispatcher("equity.jsp").include(request, response);

        //Check if all the values are a positive value
        } else if (validator.equityPositive(propertyPrice, loanAmt)) {
            session.setAttribute("inputErr", "Please enter a positive number");
            request.getRequestDispatcher("equity.jsp").include(request, response);

        //Check if the property price is higher than the loan amount
        } else if (validator.equityValidate(propertyPrice, loanAmt)) {
            session.setAttribute("inputErr", "Property price must be higher than loan amount");
            request.getRequestDispatcher("equity.jsp").include(request, response);

        } else {

            //Parse the value from String to double
            double price = Double.parseDouble(propertyPrice);
            double loan = Double.parseDouble(loanAmt);

            //Calculate equity
            double equity = price - loan;
            //Format the result to having 2 decimal points
            String result = String.format("%.2f", equity);

            request.setAttribute("equity", result);
            request.getRequestDispatcher("equity.jsp").include(request, response);

        }
    }
}
