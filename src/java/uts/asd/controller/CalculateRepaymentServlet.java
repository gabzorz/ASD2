package uts.asd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CalculateRepaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CalculatorValidator validator = new CalculatorValidator();

        //Get all the user input values
        String propertyPrice = request.getParameter("estPropertyPrice");
        String deposit = request.getParameter("deposit");
        String loanTerm = request.getParameter("loanTerm");
        String interest = request.getParameter("interest");

        validator.clear(session);

        //Check if all the textboxes are filled
        if (validator.repaymentEmptyInput(deposit, propertyPrice, loanTerm)) {
            session.setAttribute("inputErr", "Please fill in every textbox");
            request.getRequestDispatcher("repayment.jsp").include(request, response);
        //Check if all the input values are positive
        } else if (validator.repaymentPositive(deposit, propertyPrice, loanTerm)) {
            session.setAttribute("inputErr", "Please enter a positive number");
            request.getRequestDispatcher("repayment.jsp").include(request, response);
        //Check if the proeprty price is higher than the deposit amount
        } else if (validator.repaymentValidate(deposit, deposit)) {
            session.setAttribute("inputErr", "Property price must be higher than deposit amount");
            request.getRequestDispatcher("repayment.jsp").include(request, response);

        } else {
            
            //Parse all the values from String to double
            double price1 = Double.parseDouble(propertyPrice);
            double deposit1 = Double.parseDouble(deposit);
            double loan1 = Double.parseDouble(loanTerm);
            double interest1 = Double.parseDouble(interest);

            double rate = interest1 / 100.0;
            
            //Calculate repayment
            double repayment = (deposit1 * (rate / 12) * (Math.pow(1 + rate / 12, 12 * loan1))) / ((Math.pow(1 + rate / 12, 12 * loan1)) - 1);
            //Format the result to have 2 decimal points
            String result = String.format("%.2f", repayment);

            request.setAttribute("repayment", result);
            request.getRequestDispatcher("repayment.jsp").include(request, response);

        }
    }
}
