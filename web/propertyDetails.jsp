<%@page import="uts.asd.model.Property"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="uts.asd.model.User"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Payment_Styling.css">
    </head>
    <body>
        <div class="header-img">
          <a href="index.jsp"><img class="logo" src="css/reams_logo.png"/></a>
        </div>
        
        <div class="topnav">
             <a href="homepage.jsp"style="float: left;">Home</a>
        </div>
        <div class="header">
            <h1>Results</h1>
        </div>
        <table border="1">
            <tr>
                <th>Suburb</th>
                <th>Postcode</th>
                <th>Description</th>
                <th><img class="icon" src="css/icon(bath).png" alt=""/></th>
                <th><img class="icon" src="css/icon(bedroom).png" alt=""/></th>
                <th><img class="icon" src="css/icon(garage).png" alt=""/></th>
            
            </tr>
                <tr>
                    <td><c:out value="${property.suburb}"/></td>
                    <td><c:out value="${property.postcode}"/></td>
                    <td><c:out value="${property.desc}"/></td>
                    <td><c:out value="${property.numOfBathrooms}"/></td>
                    <td><c:out value="${property.numOfBedrooms}"/></td>
                    <td><c:out value="${property.numOfGarages}"/></td>
                </tr>
        </table>
    </body>
</html>
