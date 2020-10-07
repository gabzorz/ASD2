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

public class CustomerUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        AccessValidator validator = new AccessValidator();

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String password = request.getParameter("password");
        String number = request.getParameter("number");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        validator.clear(session);

        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");

        //Input validations
        if (validator.checkUpdateIsEmpty(fname, lname, password, number, address)) {
            session.setAttribute("empErr", "Please fill in every textfield");
            request.getRequestDispatcher("customerDetails.jsp").include(request, response);
        } else if (validator.validateNumber(number)) {
            session.setAttribute("numErr", "Error: Number format incorrect");
            request.getRequestDispatcher("customerDetails.jsp").include(request, response);
        } else if (validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("customerDetails.jsp").include(request, response);
        } else if (validator.validateName(fname)) {
            session.setAttribute("nameErr", "Error: First name format incorrect");
            request.getRequestDispatcher("customerDetails.jsp").include(request, response);
        } else if (validator.validateName(lname)) {
            session.setAttribute("nameErr", "Error: Last name format incorrect");
            request.getRequestDispatcher("customerDetails.jsp").include(request, response);
        } else {
            try {
                User user = manager.findEmail(email);
                if (user != null) {
                    session.setAttribute("user", user);
                    manager.updateCustomer(fname, lname, address, number, password, email);
                    //Displays a message to the user if update is successful
                    session.setAttribute("updated", "Update was successful");
                    request.getRequestDispatcher("customerDetails.jsp").include(request, response);
                } else {
                    session.setAttribute("updated", "Update was not successful");
                    request.getRequestDispatcher("customerDetails.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CustomerUpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("customerDetails.jsp");
        }
    }
}
