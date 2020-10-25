<%-- 
    Document   : createNewOpenDay
    Created on : 19/10/2020, 3:00:58 PM
    Author     : Hamish Lamond
--%>

<%@page import="uts.asd.model.Property"%>
<%@page import="uts.asd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SEAN_CSS.css">
        <title>New Session</title>
    </head>
    <%
        User user = (User) session.getAttribute("user");
        Property property = (Property) session.getAttribute("property");
    %>
    <body>
        <div class="pagewrapper">
            <p style="float:right; font-size: 12px;"><%= user.getRoleId()%>: You're logged in as <%= user.getfName()%></p>
            <div class="header-img">
                <a href="homepage.jsp"><img class="logo" src="css/reams_logo.png"/></a>
            </div>
            <div class="topnav">
                <a href="LogoutServlet"><button>Logout</button></a>
                <a href="CustomerEditServlet?email='<%=user.getEmailAddress()%>'&password='<%=user.getPassword()%>'" style="color:black;"><button>Profile</button></a>
                <a href="homepage.jsp"><button>Homepage</button></a>
                <b>
                    <form class="search" action="SearchServlet" method="get">
                        <input class="searchBox" type="text" name="propertysearch" placeholder="Search by state, suburb or postcode">
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
            <div class="header">
                <h1>Create New Session</h1>
            </div>
            <div class="center">
                <form action="CreateOpenDayServlet" method="post">
                    <table class="center">
                        <tr>
                            <td><label for="propertyAddress">Property Address:</label></td>
                            <td><%=property.getAddress()%></td>
                        </tr>
                        <tr>
                            <td><label for="propertySuburb">Property Suburb</label></td>
                            <td><%=property.getSuburb()%></td>
                        </tr>
                        <tr>
                            <td><label for="openDayDate">Open Day Date:</label></td>
                            <td><input type="date" id="openDayStartDate" name="openDayDate" value="2020-01-01"></td>
                        </tr>
                        <tr>
                            <td><label for="openDayStartTime">Open Day Start Time:</label></td>
                            <td><input type="time" id="openDayStartTime" name="openDayStartTime" value="12:00"></td>
                        </tr>
                        <tr>
                            <td><label for="openDayEndTime">Open Day End Time:</label></td>
                            <td><input type="time" id="openDayEndTime" name="openDayEndTime" value="12:00"></td>
                        </tr>
                    </table>
                    <table class="center">
                        <tr>
                            <td><input type="button" value="Cancel" onclick="history.back()"></td>
                            <td><input type="submit" value="Create Open Day Session"></td>
                        </tr>
                    </table>
                </form>
            </div>
    </body>
</html>
