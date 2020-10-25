<%-- 
   Document   : auctionPage
   Created on : 22/09/2020, 10:52:25 AM
   Author     : Hamish Lamond
--%>

<%@page import="uts.asd.model.User"%>
<%@page import="uts.asd.model.Property"%>
<%@page import="uts.asd.model.Bid"%>
<%@page import="uts.asd.model.Auction_Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        User user = (User) session.getAttribute("user");
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
        <link rel="stylesheet" href="css/SEAN_CSS.css">
        <title>Auction</title>
    </head>
    <body>
        <div class="pagewrapper">
            <p style="float:right; font-size: 12px;"><%= user.getRoleId()%>: You're logged in as <%= user.getfName()%></p>
            <div class="header-img">
                <a href="homepage.jsp"><img class="logo" src="css/reams_logo.png"/></a>
            </div>
            <div class="topnav">
                <a href="LogoutServlet"><button>Logout</button></a>
                <a href="CustomerEditServlet?email='<%=user.getEmailAddress()%>'&password='<%=user.getPassword()%>'" style="color:black;"><button>Profile</button></a>
                <a href="homepage.jsp"><button>Homepage</button></a>
                <b>
                    <form class="search" action="SearchServlet" method="get">
                        <input class="searchBox" type="text" name="propertysearch" placeholder="Search by state, suburb or postcode">
                        <img class="navicon" src="css/icons/icon(bedroom).png" alt=""/>
                        <select name="bedroomselect">
                            <option value="%">Any</option>
                            <option value="1">1 Bed</option>
                            <option value="2">2 Beds</option>
                            <option value="3">3 Beds</option>
                            <option value="4">4 Beds</option>
                            <option value="5">5+ Beds</option>
                        </select>
                        <img class="navicon" src="css/icons/icon(garage).png" alt=""/>
                        <select name="garageselect">
                            <option value="%">Any</option>
                            <option value="1">1 Car</option>
                            <option value="2">2 Cars</option>
                            <option value="3">3 Cars</option>
                            <option value="4">4+ Cars</option>
                        </select>
                        <input type="submit" value="Search Properties"></input>
                    </form>
                </b>
            </div>
            <div class="header">
                <h1>Auction</h1>
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
                        <td class="auctionIndicator">
                            Auction starts: <p id="auctionStart"><%=auctionStart%></p>
                        </td>
                        <td class="auctionIndicator">
                            Auction ends: <p id="auctionEnd"><%=auctionEnd%></p>
                        </td>
                        <td class="auctionIndicator">
                            Time to start: <p id="auctionTimeToStart"></p>
                        </td>
                        <td class="auctionIndicator">
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
