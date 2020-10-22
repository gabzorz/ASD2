<%-- 
    Document   : sendHelpTicket
    Created on : 22/10/2020, 4:35:13 AM
    Author     : Sean
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.Date"%>
<%@page import="uts.asd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/SEAN_CSS.css">
        <title>Help Ticket</title>
    </head>
    <body>
        <%
            String ticketdetailsErr = (String) session.getAttribute("ticketdetailsErr");
        %>
        <div class="header-img">
          <a href="homepage.jsp"><img class="logo" src="css/reams_logo.png"/></a>
        </div>
        
        <div class="topnav">
            <b>
             <form class="search" action="SearchServlet" method="get">
                <input class="searchBox" type="text" name="propertysearch" placeholder="Search by state, suburb or postcode" >
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
        <div class="helpwrapper">
            <div class="helpblocksa">
                <form action="HelpTicketSendServlet" method="post">
                    <a1>Send Help Ticket</a1>
                    <br>
                    <a2>Category:</a2>
                    <br>
                    <select name="ticketcategoryselect">
                        <option value="Account issue" name="Account issue">Account Issue</option>
                        <option value="Property listing issue" name="Property listing issue">Property Listing Issue</option>
                        <option value="Payment issue" name="Payment issue">Payment Issue</option>
                        <option value="Auction issue" name="Auction issue">Auction Issue</option>
                        <option value="Other" name="Other">Other</option>
                        </select>
                    <br>
                    <a2>Details:</a2>
                    <br>
                    <textarea style="resize: none; height: 20em; width: 97%;" maxlength="500" name="htdetails"></textarea>
                    <br>
                    <a2>500 character limit</a2>
                    <br>
                    <div class="helpticketwrapper">
                    <input class="helpticketbutton" type="submit" value="Send Ticket">
                    <br>
                    <t1> <%=(ticketdetailsErr != null ? ticketdetailsErr : "")%> </t1>
                    </div>
                    </form>
            </div>
            <div class="helpblocksb">
                    <a1>Help Tickets</a1>
                    <div class="ticketlistwrapper">
                        <c:if test ="${not empty requestScope['senthelpticketslist']}">
                            <c:forEach var="HelpTicket" items="${requestScope['senthelpticketslist']}">
                                <t1><c:out value="${HelpTicket.category}"/></t1>
                            </c:forEach>
                        </c:if>
                        <c:if test ="${empty requestScope['senthelpticketslist']}">
                            <div class="noresults"><p>No Results</p></div>
                        </c:if>
                    </div>
            </div>        
        </div>
    </body>
</html>
