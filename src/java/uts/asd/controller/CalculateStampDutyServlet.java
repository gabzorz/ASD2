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

public class CalculateStampDutyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CalculatorValidator validator = new CalculatorValidator();

        //Get the user input value
        String propertyPrice = request.getParameter("estPropertyPrice");

        validator.clear(session);
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");

        //Check if every textbox is filled
        if (validator.stampDutyEmptyInput(propertyPrice)) {
            session.setAttribute("inputErr", "Please fill in every textbox");
            request.getRequestDispatcher("stampDuty.jsp").include(request, response);
        //Check if the user input value
        } else if (validator.stampDutyPositive(propertyPrice)) {
            session.setAttribute("inputErr", "Please enter a positive number");
            request.getRequestDispatcher("stampDuty.jsp").include(request, response);
        //Check if the user input is at least 80000
        } else if (validator.StampDutyValidValue(propertyPrice)) {
            session.setAttribute("inputErr", "Please enter a value at least 80000");
            request.getRequestDispatcher("stampDuty.jsp").include(request, response);

        } else {
            try {
                //Parse value from String to float
                int priceCat;
                float price = Float.parseFloat(propertyPrice);
                //Determine the price category
                if (price >= 80000 || price <= 300000) {
                    priceCat = 1;
                } else if (price >= 300001 || price <= 1000000) {
                    priceCat = 2;
                } else {
                    priceCat = 3;
                }

                //Get the values from the DB
                Calculator value = manager.findValues(priceCat);
                int variablePrice = value.getVariablePrice();
                float variableIncrease = value.getVariableIncrease();
                int duitableVariable = value.getDuitableValue();
                //Calculate the stampduty
                double threshold = (price - duitableVariable) / 100;
                double stampDuty = variablePrice + (variableIncrease * threshold);
                //Format the result to show 2 decimal points
                String result = String.format("%.2f", stampDuty);

                request.setAttribute("stamp_duty", result);
                request.getRequestDispatcher("stampDuty.jsp").include(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(CalculateStampDutyServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
