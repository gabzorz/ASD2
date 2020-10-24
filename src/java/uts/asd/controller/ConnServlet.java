package uts.asd.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.asd.model.dao.*;

public class ConnServlet extends HttpServlet {

    private DBConnector db;
    private AccessDBManager accessManager;   
    private Connection conn;
    private PaymentDAO pyd;
    private PostDAO pd;

    @Override
    public void init() {

        try {
            db = new DBConnector();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        conn = db.openConnection();

        try {
            accessManager = new AccessDBManager(conn);
            pyd = new PaymentDAO(conn);
            pd = new PostDAO(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("accessManager", accessManager);
        session.setAttribute("pyd", pyd);
        session.setAttribute("pd", pd);
    }

    @Override
    public void destroy() {

        try {
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
