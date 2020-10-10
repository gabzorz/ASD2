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

public class ShowStampDutyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CalculatorValidator validator = new CalculatorValidator();

        String propertyPrice = request.getParameter("estPropertyPrice");

        validator.clear(session);
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");

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
                int priceCat;
                float price = Float.parseFloat(propertyPrice);

                if (price >= 80000 || price <= 300000) {
                    priceCat = 1;
                } else if (price >= 300001 || price <= 1000000) {
                    priceCat = 2;
                } else {
                    priceCat = 3;
                }

                Calculator value = manager.findValues(priceCat);
                int variablePrice = value.getVariablePrice();
                float variableIncrease = value.getVariableIncrease();
                int duitableVariable = value.getDuitableValue();

                double threshold = (price - duitableVariable) / 100;
                double stampDuty = variablePrice + (variableIncrease * threshold);

                String result = String.format("%.2f", stampDuty);

                request.setAttribute("stamp_duty", result);
                request.getRequestDispatcher("stampDuty.jsp").include(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(CalculateStampDutyServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
