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
          <a href="index.jsp"><img class="logo" src="css/reams_logo.png"/></a>
        </div>
        <div class="topnav">
            <b>
             <form class="search" action="SearchServlet" method="get">
                <input class="searchBox" type="text" name="propertysearch" placeholder="Search by state, suburb or postcode" >
                <img class="navicon" src="css/icons/icon(bedroom).png" alt=""/>
                <select name="bedroomselect">
                    <option value="%">Any</option>
                    <option value="1">1 Bed</option>
                    <option value="2">2 Beds</option>
                    <option value="3">3 Beds</option>
                    <option value="4">4 Beds</option>
                    <option value="5">5+ Beds</option>
                </select>
                <img class="navicon" src="css/icons/icon(garage).png" alt=""/>
                <select name="garageselect">
                    <option value="%">Any</option>
                    <option value="1">1 Car</option>
                    <option value="2">2 Cars</option>
                    <option value="3">3 Cars</option>
                    <option value="4">4+ Cars</option>
                </select>
                <input type="submit" value="Search Properties"></input>
                </form>
                </b>
        </div>
        <div class="detailswrapper">
            <img class="detailsimg" src="css/property images/${property.id}.jpg" alt=""/>
        </div>
        <div class="details">
            <div class="detailsblocksa">
            <h3><c:out value="${property.address}"/>, <c:out value="${property.suburb}"/> <c:out value="${property.postcode}"/></h3>
            <img class="icon" src="css/icons/icon(bedroom).png" alt=""/> 
            <c:out value="${property.numOfBedrooms}"/>
            <img class="icon" src="css/icons/icon(garage).png" alt=""/>
            <c:out value="${property.numOfGarages}"/>
            <img class="icon" src="css/icons/icon(bath).png" alt=""/>
            <c:out value="${property.numOfBathrooms}"/>
            <br>
            <h2><c:out value="${property.desc}"/></h2>
            <br>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec in varius orci. Praesent ut consectetur purus. Cras pellentesque turpis non 
            sapien tristique, a fermentum dolor imperdiet. Donec consectetur nibh enim. Nulla vitae fringilla massa. Fusce quis porta erat. Lorem ipsum 
            dolor sit amet, consectetur adipiscing elit. Ut sodales quam neque, in maximus metus semper in.
            </div>
            <div class="detailsblocksb">
                <br>
            <img style="border-radius: 70%; width: 45%" src="css/property images/person-icon.jpg" alt=""/>
            <h3>${user.fName} ${user.lName}</h3>
            <h3>${user.emailAddress} | ${user.contactNumber}</h3>
            <form>
                <input type="submit" value="Enquire"/>
            </div>
            </div>
        <%--
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
        --%>
    </body>
</html>
