<%-- 
    Document   : editOpenDay
    Created on : 19/10/2020, 4:36:04 PM
    Author     : Hamish Lamond
--%>

<%@page import="uts.asd.model.Open_Day_Booking"%>
<%@page import="uts.asd.model.Property"%>
<%@page import="uts.asd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <%
        User user = (User) session.getAttribute("user");
        Property property = (Property) session.getAttribute("property");
        Open_Day_Booking openDayBooking = (Open_Day_Booking) session.getAttribute("openDayBooking");
    %>
    <body>
        <div class="center">
            <form action="UpdateOpenDayServlet" method="post">
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
                        <td><input type="date" id="openDayStartDate" name="openDayDate" value="<%=openDayBooking.getDate()%>"></td>
                    </tr>
                    <tr>
                        <td><label for="openDayStartTime">Open Day Start Time:</label></td>
                        <td><input type="time" id="openDayStartTime" name="openDayStartTime" value="<%=openDayBooking.getStartTime()%>"></td>
                    </tr>
                    <tr>
                        <td><label for="openDayEndTime">Open Day End Time:</label></td>
                        <td><input type="time" id="openDayEndTime" name="openDayEndTime" value="<%=openDayBooking.getEndTime()%>"></td>
                    </tr>
                </table>
                <table class="center">
                    <tr>
                        <td><input type="button" value="Back" onclick="history.back()"></td>
                        <td><input type="submit" value="Edit Open Day Session"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
