<%-- 
    Document   : payment_list
    Created on : 26/09/2020, 8:26:48 PM
    Author     : CristinaFidelino
--%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.asd.model.Payment"%>
<%@page import="uts.asd.model.User"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Payment_Styling.css">
        <title>Payment Information</title>
    </head>
    <body>       
        <div class="header-img">
          <a href="homepage.jsp"><img class="logo" src="css/reams_logo.png"/></a>
        </div>
        
        <div class="topnav">
             <a href="index.jsp"style="float: left;">Home</a>
            <a style="float: left;">Find a Property</a>
            <a style="float: left;">Find Agents</a>
            <a style="float: left;">For Owners</a>
            <a style="float: left;">Real Estate News</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        
        <main> 
            <form method="post" action="PaymentServlet">
        <table border="1" cellpadding="5">
            <h1>Linked Accounts</h1>
            <tr>
                <th>Payment ID</th>
                <th>Account Number</th>
                <th>BSB</th>
            </tr>
                <tr>
                    <td><c:out value="${payment.getPaymentID()}"/></td>
                    <input type="hidden" name ="paymentId" value="${payment.getPaymentID()}"/>
                    <td><c:out value="${payment.getAccountNumber()}"/></td>
                    <td><c:out value="${payment.getBsb()}"/></td>
                    <%--<form method="post" action="PaymentRemoveServlet">--%>
                </tr>
                <tr>
                    <td><c:out value="${payment.getPaymentID()}"/></td>
                    <td><input maxlength="8" name="accountNumber" type="text" placeholder="<c:out value="${payment.getAccountNumber()}"/>"/></td>
                    <td><input maxlength="7" name="bsb" type="text" placeholder="<c:out value="${payment.getBsb()}"/>"/></td>
                    <%--<form method="post" action="PaymentRemoveServlet">--%>
                </tr>
        </table>
                <input class="button" type="submit" value="Change"/>
            </form>
                <form method="post" action="PaymentRemoveServlet">
                    <input type="hidden" name ="paymentId" value="${payment.getPaymentID()}"/>
                    <input class="button" type="submit" value="Delete"/>
                </form>
        </main>
    </body>
</html>
