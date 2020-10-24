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
            <c:forEach var = "session" items = "${openDayBookings}">
                <tr>
                    <td><c:out value = "${session.getDate()}"/></td>
                    <td><c:out value = "${session.getStartTime()}"/></td>
                    <td><c:out value = "${session.getEndTime()}"/></td>
                    <td><c:out value = "${session.getStatus()}"/></td>
                    <%
                        if (user.getRoleId() == 3) {
                    %>
                    <td><a href="">Book</a></td>
                    <%
                    } else {
                    %>
                    <td><a href="CancelOpenDayServlet?bId=<c:out value = "${session.getBookingID()}"/>">Cancel</a></td>
                    <td><a href="EditOpenDayServlet?bId=<c:out value = "${session.getBookingID()}"/>">Edit</a></td>
                    <%
                        }
                    %>
                </tr>
            </c:forEach>
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
