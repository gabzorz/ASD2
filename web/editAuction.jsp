<%-- 
    Document   : editAuction
    Created on : 24/09/2020, 5:28:32 PM
    Author     : Hamish Lamond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="header">
            <h1>Edit Auction</h1>
        </div>
        <div class="top_right_link_div">
            <a href="index.jsp">Index</a>
            <a href="homepage.jsp">Homepage</a>
        </div>
        <form action="homepage.jsp" method="post">
            <table>
                <tr>
                    <td><label for="auctionStartDate">Auction Start Date:</label></td>
                    <td><input type="date" id="auctionStartDate" name="auctionStartDate"></td>
                </tr>
                <tr>
                    <td><label for="auctionStartTime">Auction Start Time:</label></td>
                    <td><input type="time" id="auctionStartTime" name="auctionStartTime"></td>
                </tr>
                <tr>
                    <td><label for="auctionEndDate">Auction End Date:</label></td>
                    <td><input type="date" id="auctionEndDate" name="auctionEndDate"></td>
                </tr>
                <tr>
                    <td><label for="auctionEndTime">Auction End Time:</label></td>
                    <td><input type="time" id="auctionEndTime" name="auctionEndTime"></td>
                </tr>
                <tr>
                    <td><label for="startingPrice">Starting Price:</label></td>
                    <td><input type="number" id="startingPrice" name="startingPrice" placeholder="400000"></td>
                </tr>
                <tr>
                    <td><label for="reservePrice">Reserve Price:</label></td>
                    <td><input type="number" id="reservePrice" name="reservePrice" placeholder="500000"></td>
                </tr>
            </table>
            <table>
            <tr>
                <td><input type="button" value="Cancel" onclick="history.back()"></td>
                <td><input type="submit" value="Update Auction"></td>
            </tr>
            </table>
        </form>
    </body>
</html>
