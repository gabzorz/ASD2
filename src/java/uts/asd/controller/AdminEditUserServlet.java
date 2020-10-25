package uts.asd.controller;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.http.*;
import uts.asd.model.*;
import uts.asd.model.dao.AccessDBManager;

public class AdminEditUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");

        try {
            ArrayList<User> users = new ArrayList<User>();
            users = manager.viewUser();
            session.setAttribute("users", users);
            request.getRequestDispatcher("viewUsers.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminEditUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
