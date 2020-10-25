<%-- 
    Document   : viewOpenDayBookings
    Created on : 19/10/2020, 2:44:58 PM
    Author     : Hamish Lamond
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="uts.asd.model.Open_Day_Booking"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.asd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SEAN_CSS.css">
        <title>Open Day Sessions</title>
    </head>
    <%
        User user = (User) session.getAttribute("user");
        ArrayList<Open_Day_Booking> openDayBookings = (ArrayList<Open_Day_Booking>) session.getAttribute("openDayBookings");
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
                <h1>Open Day Sessions List </h1>
            </div>
            <table border = "1" width = "80%">
                <tr>
                    <th>Date</th>
                    <th>Start Time</th>
                    <th>End Time</th>
                    <th>Status</th>
                </tr>      
                <%
                    for (Open_Day_Booking booking : openDayBookings) {
                %> 
                <tr>
                    <td><%=booking.getDate()%></td>
                    <td><%=booking.getStartTime()%></td>
                    <td><%=booking.getEndTime()%></td>
                    <td><%=booking.getStatus()%></td>
                    <%
                        if (user.getRoleId() == 3) {
                            if (booking.getStatus().equals("Available")) {
                    %>
                    <td><a href="BookOpenDayServlet?bId=<%=booking.getBookingID()%>"><button>Book Session</button></a></td>
                    <%
                        }
                        if (booking.getStatus().equals("Booked")) {
                            if (user.getUserId() == booking.getUserID()) {
                    %>
                    <td><a href="CancelOpenDayBookingServlet?bId=<%=booking.getBookingID()%>"><button>Cancel Booking</button></a></td>
                    <%
                    } else {

                    %>
                    <td>Session Booked</td>
                    <%                        }

                        }
                    } else {
                    %>
                    <td><a href="CancelOpenDayServlet?bId=<%=booking.getBookingID()%>"><button>Cancel</button></a></td>
                    <td><a href="EditOpenDayServlet?bId=<%=booking.getBookingID()%>"><button>Edit</button></a></td>
                    <%
                        }
                    %>
                </tr> 

                <%
                    }
                %>

            </table>
            <%
                if (user.getRoleId() != 3) {
            %>
            <div class="center">
                <a href="createNewOpenDay.jsp"><button>Create New Session</button></a>
            </div>
            <%
                }
            %>
    </body>
</html>
