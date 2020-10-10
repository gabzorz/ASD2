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

        String priceCat = request.getParameter("priceCat");

        validator.clear(session);
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");

        if (validator.checkEmpty(priceCat)) {
            session.setAttribute("inputErr", "Please enter a value");
            request.getRequestDispatcher("adjustStampDuty.jsp").include(request, response);

        } else if (validator.checkPriceCat(priceCat)) {
            session.setAttribute("inputErr", "Input must be 1, 2 or 3");
            request.getRequestDispatcher("adjustStampDuty.jsp").include(request, response);

        } else {
            try {
              
                int category = Integer.parseInt(priceCat);
                
                Calculator value = manager.findValues(category);
                int variablePrice = value.getVariablePrice();
                float variableIncrease = value.getVariableIncrease();
                int duitableVariable = value.getDuitableValue();

                

                request.setAttribute("variablePrice", variablePrice);
                request.setAttribute("variableIncrease", variableIncrease);
                request.setAttribute("duitableVariable", duitableVariable);
                request.getRequestDispatcher("adjustStampDuty.jsp").include(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(CalculateStampDutyServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
