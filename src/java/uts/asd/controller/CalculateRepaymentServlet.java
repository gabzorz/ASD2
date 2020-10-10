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
import java.math.*;
import java.text.DecimalFormat;

public class CalculateRepaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CalculatorValidator validator = new CalculatorValidator();

        String propertyPrice = request.getParameter("estPropertyPrice");
        String deposit = request.getParameter("deposit");
        String loanTerm = request.getParameter("loanTerm");
        String interest = request.getParameter("interest");

        validator.clear(session);

        if (validator.repaymentEmptyInput(deposit, propertyPrice, loanTerm)) {
            session.setAttribute("inputErr", "Please fill in every textbox");
            request.getRequestDispatcher("repayment.jsp").include(request, response);

        } else if (validator.repaymentPositive(deposit, propertyPrice, loanTerm)) {
            session.setAttribute("inputErr", "Please enter a positive number");
            request.getRequestDispatcher("repayment.jsp").include(request, response);

        } else if (validator.repaymentValidate(deposit, deposit)) {
            session.setAttribute("inputErr", "Property price must be higher than deposit amount");
            request.getRequestDispatcher("repayment.jsp").include(request, response);

        } else {

            double price1 = Double.parseDouble(propertyPrice);
            double deposit1 = Double.parseDouble(deposit);
            double loan1 = Double.parseDouble(loanTerm);
            double interest1 = Double.parseDouble(interest);

            double rate = interest1 / 100.0;

            double repayment = (deposit1 * (rate / 12) * (Math.pow(1 + rate / 12, 12 * loan1))) / ((Math.pow(1 + rate / 12, 12 * loan1)) - 1);
            String result = String.format("%.2f", repayment);

            request.setAttribute("repayment", result);
            request.getRequestDispatcher("repayment.jsp").include(request, response);

        }

    }

}
