<%-- 
    Document   : confirmAuction
    Created on : 08/09/2020, 1:19:53 PM
    Author     : Hamish Lamond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/REAMS_CSS.css">
        <title>Confirm Auction</title>
    </head>
    <body>
        <%
            String auctionStartDate = request.getParameter("auctionStartDate");
            String auctionStartTime = request.getParameter("auctionStartTime");
            String auctionEndDate = request.getParameter("auctionEndDate");
            String auctionEndTime = request.getParameter("auctionEndTime");
            String startingPrice = request.getParameter("startingPrice");
            String reservePrice = request.getParameter("reservePrice");
        %>
        <h1>Confirm Auction</h1>
        
        <table>
                <tr>
                    <td>Auction Start Date (YYYY/MM/DD):</td>
                    <td><%=auctionStartDate%></td>
                </tr>
                <tr>
                    <td>Auction Start Time:</td>
                    <td><%=auctionStartTime%></td>
                </tr>
                <tr>
                    <td>Auction End Date (YYYY/MM/DD):</td>
                    <td><%=auctionEndDate%></td>
                </tr>
                <tr>
                    <td>Auction End Time:</td>
                    <td><%=auctionEndTime%></td>
                </tr>
                <tr>
                    <td>Starting Price:</td>
                    <td>$<%=startingPrice%></td>
                </tr>
                <tr>
                    <td>Reserve Price:</td>
                    <td>$<%=reservePrice%></td>
                </tr>
                <tr>
                    <td><a href="homepage.jsp">Confirm</a></td>
                    <td><button onclick="history.back()">Go Back</button></td>
                </tr>
        </table>
    </body>
</html>
