<%-- 
    Document   : createAuction
    Created on : 03/09/2020, 11:54:01 AM
    Author     : Hamish Lamond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/REAMS_CSS.css">
        <title>Create Auction</title>
    </head>
    <body>
        <%
            String startPriceErr = (String) session.getAttribute("startPriceErr");
            String reservePriceErr = (String) session.getAttribute("reservePriceErr");
            String empErr = (String) session.getAttribute("empErr");
        %>
        <div class="header">
            <h1>Create Auction</h1>
        </div>
        <div class="top_right_link_div">
            <a href="index.jsp">Index</a>
            <a href="homepage.jsp">Homepage</a>
        </div>

        <div class="center">
            <p><span><%=(empErr != null ? empErr : "")%></span></p>
        </div>
        <div class="center">
            <form action="CreateAuctionServlet" method="post">
                <table class="center">
                    <tr>
                        <td><label for="auctionStartDate">Auction Start Date:</label></td>
                        <td><input type="date" id="auctionStartDate" name="auctionStartDate" value="2020-01-01"></td>
                    </tr>
                    <tr>
                        <td><label for="auctionStartTime">Auction Start Time:</label></td>
                        <td><input type="time" id="auctionStartTime" name="auctionStartTime" value="12:00"></td>
                    </tr>
                    <tr>
                        <td><label for="auctionEndDate">Auction End Date:</label></td>
                        <td><input type="date" id="auctionEndDate" name="auctionEndDate" value="2020-01-01"></td>
                    </tr>
                    <tr>
                        <td><label for="auctionEndTime">Auction End Time:</label></td>
                        <td><input type="time" id="auctionEndTime" name="auctionEndTime" value="12:00"></td>
                    </tr>
                    <tr>
                        <td><label for="startingPrice">Starting Price:</label></td>
                        <td><input type="text" id="startingPrice" name="startingPrice" placeholder="$$$$$$"><%=(startPriceErr != null ? startPriceErr : "")%></td>
                    </tr>
                    <tr>
                        <td><label for="reservePrice">Reserve Price:</label></td>
                        <td><input type="text" id="reservePrice" name="reservePrice" placeholder="$$$$$$"><%=(reservePriceErr != null ? reservePriceErr : "")%></td>
                    </tr>
                </table>
                <table class="center">
                    <tr>
                        <td><input type="button" value="Cancel" onclick="history.back()"></td>
                        <td><input type="submit" value="Create Auction"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
