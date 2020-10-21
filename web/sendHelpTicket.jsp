<%-- 
    Document   : sendHelpTicket
    Created on : 22/10/2020, 4:35:13 AM
    Author     : Sean
--%>

<%@page import="uts.asd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/SEAN_CSS.css">
        <title>Help Ticket</title>
        <%
            User user = (User) session.getAttribute("user");
        %>
    </head>
    <body>
        <div class="header-img">
          <a href="homepage.jsp"><img class="logo" src="css/reams_logo.png"/></a>
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
    </body>
</html>
