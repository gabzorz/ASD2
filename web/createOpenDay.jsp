<%-- 
    Document   : createOpenDay
    Created on : 13/10/2020, 12:07:34 PM
    Author     : Hamish Lamond
--%>

<%@page import="uts.asd.model.User"%>
<%@page import="uts.asd.model.Property"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="header">
            <h1>Create Open Day</h1>
        </div>
        <div class="top_right_link_div">
            <a href="index.jsp">Index</a>
            <a href="homepage.jsp">Homepage</a>
        </div>

        <div class="center">
            <form action="CreateOpenDay" method="post">
                <table class="center">
                    <tr>
                        <td><label for="openDayDate">Auction Start Date:</label></td>
                        <td><input type="date" id="openDayDate" name="openDayDate" value="2020-01-01"></td>
                    </tr>
                    <tr>
                        <td><label for="openDayStartTime">Open Day Start Time:</label></td>
                        <td><input type="time" id="openDayStartTime" name="openDayStartTime" value="12:00"></td>
                    </tr>
                    <tr>
                        <td><label for="openDayEndTime">Open Day End Time:</label></td>
                        <td><input type="time" id="openDayEndTime" name="openDayEndTime" value="12:00"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>Ensure all dates and times are correct!</td>
                    </tr>
                </table>
                <table class="center">
                    <tr>
                        <td><input type="button" value="Cancel" onclick="history.back()"></td>
                        <td><input type="submit" value="Create Open Day"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
