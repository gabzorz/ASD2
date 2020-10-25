<%-- 
    Document   : createAuction
    Created on : 03/09/2020, 11:54:01 AM
    Author     : Hamish Lamond
--%>

<%@page import="uts.asd.model.User"%>
<%@page import="uts.asd.model.Property"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SEAN_CSS.css">
        <title>Create Auction</title>
    </head>
    <body>
        <%
            String startPriceErr = (String) session.getAttribute("startPriceErr");
            String reservePriceErr = (String) session.getAttribute("reservePriceErr");
            String empErr = (String) session.getAttribute("empErr");
            Property property = (Property) session.getAttribute("property");
            User user = (User) session.getAttribute("user");
        %>
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
                <h1>Create Auction</h1>
            </div>

            <div class="center">
                <p><span><%=(empErr != null ? empErr : "")%></span></p>
            </div>
            <div class="center">
                <form action="CreateAuctionServlet" method="post">
                    <table class="centerTable">
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
