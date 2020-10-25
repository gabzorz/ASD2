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
        <link rel="stylesheet" href="css/REAMS_CSS.css">
        <title>JSP Page</title>
    </head>
    <%
        User user = (User) session.getAttribute("user");
        Property property = (Property) session.getAttribute("property");
    %>
    <body>
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
