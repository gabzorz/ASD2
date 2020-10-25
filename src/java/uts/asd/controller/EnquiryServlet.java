package uts.asd.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.asd.model.User;
import uts.asd.model.dao.AccessDBManager;

public class EnquiryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        //object for user that is logged in
        User loggedinuser = (User) session.getAttribute("user"); 
        //String for userId of where message is being sent to
        String enquiryuserId = request.getParameter("id");
        int enquiryuseridint = Integer.parseInt(enquiryuserId);
        
        try {
            
            request.getRequestDispatcher("enquiry.jsp").include(request, response);
        }
    }
}
