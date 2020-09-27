package uts.asd.controller;

import java.io.*;
import java.sql.SQLException;
import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.http.*;
import uts.asd.model.*;
import uts.asd.model.dao.AccessDBManager;

public class AdminEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");

        try {
            User user = manager.findCustomer(email, password);
            if (user != null) {
                //Grab all the details of the logged in user and post it on the adminDetails.jsp
                session.setAttribute("user", user);
                request.getRequestDispatcher("adminDetails.jsp").include(request, response);
            } else {
                session.setAttribute("existErr", "User does not exist in the Database");
                request.getRequestDispatcher("adminDetails.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerEditServlet.class.getName()).log(Level.SEVERE, null, ex);

        }
        request.getRequestDispatcher("adminDetails.jsp").include(request, response);

    }

}
