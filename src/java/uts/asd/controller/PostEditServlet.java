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
import javax.servlet.RequestDispatcher;
import uts.asd.model.User;

/**
 *
 * @author CristinaFidelino
 */
public class PostEditServlet extends HttpServlet{
     @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            PostDAO pd = (PostDAO) session.getAttribute("pd");
            User user = (User) session.getAttribute("user");
            int userId = user.getUserId();
            //int id = Integer.parseInt(request.getParameter("id"));
            
            try{
                Post post = pd.searchPost(userId).get(0);
                RequestDispatcher dispatcher = request.getRequestDispatcher(".jsp");
                request.setAttribute("post", post);
                dispatcher.forward(request, response);
            } catch (SQLException ex) {
            Logger.getLogger(PostEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            PostDAO pd = (PostDAO) session.getAttribute("pd");
            Post post = (Post) session.getAttribute("post");
            User user = (User) session.getAttribute("user");
            
            int postID = post.getPostID();
            String title = request.getParameter("title");
            String category = request.getParameter("category");
            String content = request.getParameter("content");
            try {
                pd.updatePost(postID, title, category, content);
                response.sendRedirect("CustomerEditServlet?email='"+user.getEmailAddress()+"'&password='"+user.getPassword()+"'");
            } catch (SQLException ex) {
            Logger.getLogger(PaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
}
=======
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
import javax.servlet.RequestDispatcher;

/**
 *
 * @author CristinaFidelino
 */
public class PostEditServlet extends HttpServlet{
     @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            PostDAO pd = (PostDAO) session.getAttribute("pd");
            int id = Integer.parseInt(request.getParameter("id"));
            try{
                Post post = pd.searchPost(id).get(0);
                RequestDispatcher dispatcher = request.getRequestDispatcher("post_edit.jsp");
                request.setAttribute("post", post);
                dispatcher.forward(request, response);
            } catch (SQLException ex) {
            Logger.getLogger(PostEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
}
>>>>>>> Cristina
