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

public class AdjustStampDutyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CalculatorValidator validator = new CalculatorValidator();

        String priceCat = request.getParameter("priceCategory1");
        String variablePrice = request.getParameter("variablePrice1");
        String variableIncrease = request.getParameter("variableIncrease1");
        String duitableVariable = request.getParameter("duitableVariable1");

        validator.clear(session);
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");

        if (validator.checkEmptyAdjust(priceCat, variablePrice, variableIncrease, duitableVariable)) {
            session.setAttribute("inputErr", "Please fill in every textbox");
            request.getRequestDispatcher("adjustStampDuty.jsp").include(request, response);

        } else if (validator.checkNegativeValues(priceCat, variablePrice, variableIncrease, duitableVariable)) {
            session.setAttribute("inputErr", "Please enter a postive value");
            request.getRequestDispatcher("adjustStampDuty.jsp").include(request, response);

        } else {
            try {

                int category = Integer.parseInt(priceCat);
                int price = Integer.parseInt(variablePrice);
                float increase = Float.parseFloat(variableIncrease);
                int variable = Integer.parseInt(duitableVariable);

                manager.updateValues(category, price, increase, variable);

//                request.setAttribute("variablePrice", variablePrice);
//                request.setAttribute("variableIncrease", variableIncrease);
//                request.setAttribute("duitableVariable", duitableVariable);
                request.getRequestDispatcher("adjustStampDuty.jsp").include(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(CalculateStampDutyServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
