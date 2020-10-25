<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.asd.model.dao.PostDAO;
import uts.asd.model.Post;
import uts.asd.model.dao.DBConnector;
import java.sql.Connection;
import java.util.ArrayList;
import uts.asd.model.User;

/**
 *
 * @author CristinaFidelino
 */
public class PostRemoveServlet extends HttpServlet {
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            PostDAO pd = (PostDAO) session.getAttribute("pd");
            User user = (User) session.getAttribute("user");
            
            int postId = Integer.parseInt(request.getParameter("id"));
            
            try {
                pd.deletePost(postId);
                response.sendRedirect("CustomerEditServlet?email='"+user.getEmailAddress()+"'&password='"+user.getPassword()+"'");
            } catch (SQLException e){
               throw new ServletException("Cannot add post to Database", e); 
            }
        }
    
}/*
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
package uts.asd.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.asd.model.dao.PostDAO;
import uts.asd.model.Post;
import uts.asd.model.dao.DBConnector;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author CristinaFidelino
 *//*
public class PostRemoveServlet extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            PostDAO pd = (PostDAO) session.getAttribute("pd");
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                pd.deletePost(id);
                response.sendRedirect("PaymentServlet");
            } catch (SQLException e){
               throw new ServletException("Cannot add post to Database", e); 
            }
        }
    
}
>>>>>>> Cristina
