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
/**
 *
 * @author CristinaFidelino
 */
public class PostAddServlet extends HttpServlet{
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            PostDAO pd = (PostDAO) session.getAttribute("pd");
            
            
            String title = request.getParameter("title");
            String category = request.getParameter("category");
            String content = request.getParameter("content");
            
            try {
                pd.addPost(title, category, content);
                Post post = pd.findPost(title, category);
                session.setAttribute("post", post);
                request.getRequestDispatcher("newsReport.jsp").include(request, response);
            } catch (SQLException e){
               throw new ServletException("Cannot add post to Database", e); 
            }
        }
    
}
