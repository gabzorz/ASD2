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
import uts.asd.model.Property;
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
        int enquiryuseridint = Integer.valueOf(enquiryuserId);
        
        session.setAttribute("sendto", enquiryuseridint);
        request.getRequestDispatcher("enquiry.jsp").include(request, response);
}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        
        //
        //String enquiryuserId = request.getParameter("id");
        
        String receiverId = request.getParameter("receiverId");
        int receiverIdint = Integer.parseInt(receiverId);
        User loggedinuser = (User) session.getAttribute("user"); 
        
        
        String EnquiryMessage = request.getParameter("message");
        int loggedinuserint = loggedinuser.getUserId();
        
        
        try {
            Property Property = manager.getProperty(receiverIdint);
            int PropertyId = Property.getId();
            manager.createEnquiry(receiverIdint, loggedinuserint, EnquiryMessage, PropertyId);
            response.sendRedirect("PropertyDetailsServlet?id="+PropertyId);
        } catch (SQLException ex) {
            Logger.getLogger(EnquiryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
