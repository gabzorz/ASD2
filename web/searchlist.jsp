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
        <title>Search Results</title>
    </head>
    <body>
        <%
            ArrayList<Property> properties = (ArrayList<Property>) session.getAttribute("propertieslist");
        %>
        <div class="header-img">
          <a href="index.jsp"><img class="logo" src="css/reams_logo.png"/></a>
        </div>
        <div class="topnav">
             <a href="homepage.jsp"style="float: left;">Home</a>
        </div>
        <br>
        
        <table border="1">
            <tr>
                <th>Suburb</th>
                <th>Address</th>
                <th>Postcode</th>
                <th>State</th>
                <th>Description</th>
                <th>Bathroom/s</th>
                <th>Bedroom/s</th>
                <th>Garage/s</th>
            </tr>
            <c:forEach var="Property" items="${requestScope['propertieslist']}">
                <tr>
                    <td><c:out value="${Property.suburb}"/></td>
                    <td><c:out value="${Property.address}"/></td>
                    <td><c:out value="${Property.postcode}"/></td>
                    <td><c:out value="${Property.state}"/></td>
                    <td><c:out value="${Property.desc}"/></td>
                    <td><c:out value="${Property.numOfBathrooms}"/></td>
                    <td><c:out value="${Property.numOfBedrooms}"/></td>
                    <td><c:out value="${Property.numOfGarages}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
