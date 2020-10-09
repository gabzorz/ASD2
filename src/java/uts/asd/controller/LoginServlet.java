package uts.asd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.asd.model.*;
import uts.asd.model.dao.AccessDBManager;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        AccessValidator validator = new AccessValidator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");

        validator.clear(session);

        //Input validations
        if (validator.checkEmpty(email, password)) {
            session.setAttribute("empErr", "Please fill in every textfield");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else {
            try {
                User user = manager.findCustomer(email, password);
                int role = manager.checkRole(email);
                //For customer login
                if (user != null && role == 3) {
                    session.setAttribute("user", user);
                    //gets the users property
                    Property property = manager.getProperty(user.getEmailAddress());
                    if (property != null) {
                        session.setAttribute("property", property);
                    }
                    request.getRequestDispatcher("homepage.jsp").include(request, response);
                    //For staff login
                } else if (user != null && role == 2) {
                    session.setAttribute("user", user);
                    //gets the users property
                    HashMap<Integer, Property> properties = manager.getProperties();
                    if (properties != null) {
                        session.setAttribute("properties", properties);
                    }
                    request.getRequestDispatcher("staffMain.jsp").include(request, response);
                    //For system administrator login
                } else if (user != null && role == 1) {
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("sysMain.jsp").include(request, response);
                } else {
                    session.setAttribute("existErr", "User does not exist in the database");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "User does not exist" : "welcome");
            }

        }
    }
}
