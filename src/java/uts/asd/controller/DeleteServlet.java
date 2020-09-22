package uts.asd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.asd.model.*;
import uts.asd.model.dao.AccessDBManager;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        try {
            User user = (User) session.getAttribute("user");
            String email = user.getEmailAddress();
            //delete customer from CUSTOMER and USER_ACCOUNT Table
            manager.deleteCustomer(email);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //delete the session
        session.invalidate();
        //direct user back to the index page
        request.getRequestDispatcher("index.jsp").include(request, response);
    }
}