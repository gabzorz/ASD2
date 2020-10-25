<%-- 
   Document   : auctionPage
   Created on : 22/09/2020, 10:52:25 AM
   Author     : Hamish Lamond
--%>

<%@page import="uts.asd.model.Property"%>
<%@page import="uts.asd.model.Bid"%>
<%@page import="uts.asd.model.Auction_Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <%
            Auction_Item auction = (Auction_Item) session.getAttribute("auction");
            Property property = (Property) session.getAttribute("property");
            String propertyName = property.getAddress() + ", " + property.getSuburb() + ", " + property.getState();
            String auctionEnd = auction.getEndDate() + " " + auction.getEndTime();
            String auctionStart = auction.getStartDate() + " " + auction.getStartTime();
            int topBid = 0;
            int startPrice = auction.getStartingPrice();
            topBid = startPrice;
            Bid topPlacedBid = (Bid) session.getAttribute("topBid");
            if (topPlacedBid != null) {
                int topPlaceBid = topPlacedBid.getAmount();
                if (topPlaceBid > topBid) {
                    topBid = topPlaceBid;
                }
            }
            String empErr = (String) session.getAttribute("empErr");
            String bidErr = (String) session.getAttribute("bidErr");
        %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv = "refresh" content = "10; url = JoinAuctionServlet?id=<%=auction.getPropertyID()%>" />
        <link rel="stylesheet" href="css/REAMS_CSS.css">
        <title>Auction</title>
    </head>
    <body>
        <div class="header">
            <h1>Auction</h1>
        </div>
        <div class="top_right_link_div">
            <a href="login.jsp">Login</a>
            <a href="register.jsp">Register</a>
            <a href="createAuction.jsp">Create Auction</a>
            <a href="index.jsp">Index</a>
        </div>

        <div class="center">
            <table class="center">
                <tr>
                    <td>
                        <form action="PlaceBidServlet" method="post">
                            <table>
                                <tr>
                                    <td><p></p></td>
                                    <td><p><%=propertyName%></p></td>
                                </tr>
                                <tr>
                                <div class="center">
                                    <p><span><%=(bidErr != null ? bidErr : "")%></span></p>
                                </div>
                                </tr>
                                <tr>
                                    <td><p>Current Bid:</p></td>
                                    <td><p id="currentBid">$<%=topBid%></p></td>
                                </tr>
                                <tr>
                                    <td><p>Enter Bid:</p></td>
                                    <td><input type="text" id="newBid" name="newBid" placeholder="$$$$$$"></td>
                                    <td><input type="submit" value="Place Bid"></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type="button" value="Refresh" onclick="window.location.href = 'JoinAuctionServlet?id=<%=auction.getPropertyID()%>'"></td>
                                </tr>
                            </table>
                        </form>
                    </td>
                    <td>
                        Auction starts: <p id="auctionStart"><%=auctionStart%></p>
                    </td>
                    <td>
                        Auction ends: <p id="auctionEnd"><%=auctionEnd%></p>
                    </td>
                    <td>
                        Time to start: <p id="auctionTimeToStart"></p>
                    </td>
                    <td>
                        Time Remaining: <p id="auctionTimeRemaining"></p>
                    </td>
                </tr>
            </table>
        </div>

        <script>
            var endDateStr = document.getElementById("auctionEnd").innerHTML
            var endCountDown = new Date(endDateStr).getTime();

            var x = setInterval(function () {

                var now = new Date().getTime();

                var distance = endCountDown - now;

                var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                var seconds = Math.floor((distance % (1000 * 60)) / 1000);

                document.getElementById("auctionTimeRemaining").innerHTML = days + "d " + hours + "h "
                        + minutes + "m " + seconds + "s ";

                if (distance < 0) {
                    clearInterval(x);
                    document.getElementById("auctionTimeRemaining").innerHTML = "Auction has ended.";
                }
            }, 1000);
            
            var startDateStr = document.getElementById("auctionStart").innerHTML
            var startCountDown = new Date(startDateStr).getTime();

            var y = setInterval(function () {

                var now = new Date().getTime();

                var distance = startCountDown - now;

                var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                var seconds = Math.floor((distance % (1000 * 60)) / 1000);

                document.getElementById("auctionTimeToStart").innerHTML = days + "d " + hours + "h "
                        + minutes + "m " + seconds + "s ";

                if (distance < 0) {
                    clearInterval(y);
                    document.getElementById("auctionTimeToStart").innerHTML = "Auction has started";
                }
            }, 1000);
        </script>
    </body>
</html>
