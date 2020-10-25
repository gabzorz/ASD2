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
        <link rel="stylesheet" href="css/REAMS_CSS.css">
        <title>Open Day Sessions</title>
    </head>
    <%
        User user = (User) session.getAttribute("user");
        ArrayList<Open_Day_Booking> openDayBookings = (ArrayList<Open_Day_Booking>) session.getAttribute("openDayBookings");
    %>
    <body>
        <div class="header">
            <h1>Open Day Sessions List </h1>
        </div>

        <div class="top_right_link_div">
            <a style="text-decoration:none" href="sysMain.jsp">sysMain</a>
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
                       System.out.println(booking.getBookingID());
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
                <td><a href="BookOpenDayServlet?bId=<%=booking.getBookingID()%>">Book Session</a></td>
                <%
                    }
                    if (booking.getStatus().equals("Booked")) {
                        if (user.getUserId()== booking.getUserID()) {
                %>
                <td><a href="CancelOpenDayBookingServlet?bId=<%=booking.getBookingID()%>">Cancel Booking</a></td>
                <%
                } else {

                %>
                <td>Session Booked</td>
                <%                        }

                    }
                } else {
                %>
                <td><a href="CancelOpenDayServlet?bId=<%=booking.getBookingID()%>">Cancel</a></td>
                <td><a href="EditOpenDayServlet?bId=<%=booking.getBookingID()%>">Edit</a></td>
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
        <a href="createNewOpenDay.jsp">Create New Session</a>
        <%
            }
        %>
    </body>
</html>
