<%-- 
    Document   : editAuction
    Created on : 24/09/2020, 5:28:32 PM
    Author     : Hamish Lamond
--%>

<%@page import="uts.asd.model.Property"%>
<%@page import="uts.asd.model.User"%>
<%@page import="uts.asd.model.Auction_Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <%
            String startPriceErr = (String) session.getAttribute("startPriceErr");
            String reservePriceErr = (String) session.getAttribute("reservePriceErr");
            String empErr = (String) session.getAttribute("empErr");
            Property property = (Property) session.getAttribute("property");
            User user = (User) session.getAttribute("user");
            Auction_Item auction = (Auction_Item) session.getAttribute("auction");
        %>
        <div class="header">
            <h1>Edit Auction</h1>
        </div>
        <div class="top_right_link_div">
            <a href="index.jsp">Index</a>
            <a href="homepage.jsp">Homepage</a>
        </div>

        <div class="center">
            <p><span><%=(empErr != null ? empErr : "")%></span></p>
        </div>
        <form action="EditAuctionServlet" method="post">
            <div class="center">
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
                        <td><label for="auctionStartDate">Auction Start Date:</label></td>
                        <td><input type="date" id="auctionStartDate" name="auctionStartDate" value="<%=auction.getStartDate()%>"></td>
                    </tr>
                    <tr>
                        <td><label for="auctionStartTime">Auction Start Time:</label></td>
                        <td><input type="time" id="auctionStartTime" name="auctionStartTime" value="<%=auction.getStartTime().substring(0, 5)%>"></td>
                    </tr>
                    <tr>
                        <td><label for="auctionEndDate">Auction End Date:</label></td>
                        <td><input type="date" id="auctionEndDate" name="auctionEndDate" value="<%=auction.getEndDate()%>"></td>
                    </tr>
                    <tr>
                        <td><label for="auctionEndTime">Auction End Time:</label></td>
                        <td><input type="time" id="auctionEndTime" name="auctionEndTime" value="<%=auction.getEndTime().substring(0, 5)%>"></td>
                    </tr>
                    <tr>
                        <td><label for="startingPrice">Starting Price:</label></td>
                        <td><input type="text" id="startingPrice" name="startingPrice" value="<%=(startPriceErr != null ? startPriceErr : "")%>"</td>
                    </tr>
                    <tr>
                        <td><label for="reservePrice">Reserve Price:</label></td>
                        <td><input type="text" id="reservePrice" name="reservePrice" value="<%=(reservePriceErr != null ? reservePriceErr : "")%>"</td>
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
