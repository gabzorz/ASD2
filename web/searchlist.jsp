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
        <link rel="stylesheet" href="css/SEARCH_CSS.css">
    </head>
    <body>
        <div class="header-img">
          <a href="homepage.jsp"><img class="logo" src="css/reams_logo.png"/></a>
        </div>
        
        <div class="topnav">
             <a href="homepage.jsp"style="float: left;">Home</a>
        </div>
        
        <c:if test ="${not empty requestScope['propertieslist']}">
            <c:forEach var="Property" items="${requestScope['propertieslist']}">
                <c:url var="loadPropertyLink" value="PropertyDetailsServlet">
                    <c:param name="id" value="${Property.id}"/>
                </c:url>
                <div class="wrapper">
                    <div class="property">
                        <a href="${loadPropertyLink}"><img src="css/property images/1.jpg" alt=""/></a>
                        <h3><c:out value="${Property.address}"/>, <c:out value="${Property.postcode}"/></h3>
                        <img class="icon" src="css/icons/icon(bedroom).png" alt=""/> 
                        <c:out value="${Property.numOfBedrooms}"/>
                        <img class="icon" src="css/icons/icon(garage).png" alt=""/>
                        <c:out value="${Property.numOfGarages}"/>
                        <img class="icon" src="css/icons/icon(bath).png" alt=""/>
                        <c:out value="${Property.numOfBathrooms}"/>
                        <br>
                        <h2><c:out value="${Property.desc}"/></h2>
                    </div>
                </div>
                </c:forEach>
        </c:if>
        <c:if test ="${empty requestScope['propertieslist']}">
        <h1>No Results</h1>
        </c:if>
        </div>
    </body>
</html>
