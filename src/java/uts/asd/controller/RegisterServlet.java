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

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get session
        HttpSession session = request.getSession();
        AccessValidator validator = new AccessValidator();

        //all the textfields in the register.jsp
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String number = request.getParameter("number");
        String address = request.getParameter("address");
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");

        validator.clear(session);

        //Input validations
        if (validator.checkRegisterIsEmpty(fname, lname, dob, address, email, number, password)) {
            session.setAttribute("empErr", "Please fill in every textfield");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validateName(fname)) {
            session.setAttribute("fnameErr", "Error: First name format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validateName(lname)) {
            session.setAttribute("lnameErr", "Error: Last Name format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validateNumber(number)) {
            session.setAttribute("numErr", "Error: Number format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else {
            try {
                boolean exist = manager.checkEmail(email);
                //if the email address is already registered
                if (exist == true) {
                    session.setAttribute("existErr", "User email already exists in the database");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                } else {
                    //email address has not been used
                    manager.createCustomer(fname, lname, address, dob, email, number, password, 3);
                    User customer = new User(fname, lname, address, dob, email, number, password, 3);
                    session.setAttribute("user", customer);
                    request.getRequestDispatcher("homepage.jsp").include(request, response);
                }

            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
}
