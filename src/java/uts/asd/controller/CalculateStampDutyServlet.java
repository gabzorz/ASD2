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
import uts.asd.model.dao.CalculatorDBManager;


public class CalculateStampDutyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CalculatorValidator validator = new CalculatorValidator();
        CalculatorDBManager manager = (CalculatorDBManager) session.getAttribute("calculatorManager");

        String propertyPrice = request.getParameter("estPropertyPrice");

        validator.clear(session);

        if (validator.stampDutyEmptyInput(propertyPrice)) {
            session.setAttribute("inputErr", "Please fill in every textbox");
            request.getRequestDispatcher("stampDuty.jsp").include(request, response);

        } else if (validator.stampDutyPositive(propertyPrice)) {
            session.setAttribute("inputErr", "Please enter a positive number");
            request.getRequestDispatcher("stampDuty.jsp").include(request, response);

        } else if (validator.StampDutyValidValue(propertyPrice)) {
            session.setAttribute("inputErr", "Please enter a value at least 80000");
            request.getRequestDispatcher("stampDuty.jsp").include(request, response);

        } else {
            try {
                int priceCat = 0;
                double price = Double.parseDouble(propertyPrice);

                if (price >= 80000 || price <= 300000) {
                    priceCat = 1;
                } else if (price >= 300001 || price <= 1000000) {
                    priceCat = 2;
                } else {
                    priceCat = 3;
                }
                System.out.println("Price Category: " + priceCat);

                Calculator formula = manager.findValues(priceCat);
                if (formula != null) {

                    int variablePrice = formula.getVariablePrice();
                    double variableIncrease = formula.getVariableIncrease();
                    int duitableVariable = formula.getDuitableValue();

                    double threshold = (price - duitableVariable) / 100;
                    double stampDuty = variablePrice + (variableIncrease * threshold);

                    String result = String.format("%.2f", stampDuty);
                } else {
                    session.setAttribute("inputErr", "Invalid input");
                    request.getRequestDispatcher("stampDuty.jsp").include(request, response);
                }

            } catch (SQLException ex) {
                Logger.getLogger(CalculateStampDutyServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
