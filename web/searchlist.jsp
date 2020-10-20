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
        <c:if test ="${not empty requestScope['propertieslist']}">
        <div class="header">
            <h1>Results</h1>
        </div>
        <table border="1">
            <tr>
                <th>Suburb</th>
                <th>Postcode</th>
                <th>Description</th>
                <th><img class="icon" src="css/icon(bath).png" alt=""/></th>
                <th><img class="icon" src="css/bed (2).png" alt=""/></th>
                <th><img class="icon" src="css/icon(garage).png" alt=""/></th>
            
            </tr>
            <c:forEach var="Property" items="${requestScope['propertieslist']}">
                <tr>
                    <td><c:out value="${Property.suburb}"/></td>
                    <td><c:out value="${Property.postcode}"/></td>
                    <td><c:out value="${Property.desc}"/></td>
                    <td><c:out value="${Property.numOfBathrooms}"/></td>
                    <td><c:out value="${Property.numOfBedrooms}"/></td>
                    <td><c:out value="${Property.numOfGarages}"/></td>
                </tr>
            </c:forEach>
        </table>
        </c:if>
        
        <c:if test ="${empty requestScope['propertieslist']}">
        <h1>No Results</h1>
        </c:if>
    </body>
</html>
