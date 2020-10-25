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
            String detailsSaved = (String) session.getAttribute("detailsSaved");
            String subjectSaved = (String) session.getAttribute("subjectSaved");
            
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
                <form action="HelpTicketUserServlet" method="post">
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
                    <a2>Subject:</a2>
                    <br>
                    <input type="text" style="width:97%; font:12px Arial, sans-serif;" name="subject" maxlength="50" placeholder="Write up to 100 characters" value="<%=(subjectSaved != null ? subjectSaved : "")%>"/>
                    <br>
                    <a2>Details:</a2>
                    <br>
                    <textarea style="resize: none; height: 20em; width: 97%; font:12px Arial, sans-serif;;" maxlength="500" name="htdetails" placeholder="Write up to 500 characters"><%=(detailsSaved != null ? detailsSaved : "")%></textarea>
                    <br>
                    <div class="helpticketwrapper">
                    <input class="helpticketbutton" type="submit" value="Send Ticket">
                    <br>
                    <t2> <%=(ticketdetailsErr != null ? ticketdetailsErr : "")%> </t2>
                    </div>
                    </form>
            </div>
            <div class="helpblocksb">
                    <a1>Help Tickets</a1>
                    <div class="ticketlistwrapper">
                        <c:if test ="${not empty requestScope['senthelpticketslist']}">
                                <c:forEach var="HelpTicket" items="${requestScope['senthelpticketslist']}">
                                    <c:url var="viewTicketLink" value="ViewTicketServlet">
                                        <c:param name="Ticketid" value="${HelpTicket.helpTicketId}"/>
                                    </c:url>
                                    <a href="${viewTicketLink}">
                                    <div class="ticket" style="${HelpTicket.status == 'Complete' ? 'background-color:#ade700;' : ''} ${HelpTicket.status == 'Assigned' ? 'background-color:#ffcc00;' : ''} ${HelpTicket.status == 'Cancelled' ? 'background-color:#d6d6d6;' : ''}">
                                        <t1><c:out value="Ticket ID: ${HelpTicket.helpTicketId}"/></t1>
                                        <t1 style="float:right"><c:out value="${HelpTicket.status}"/></t1>
                                        <br>
                                        <t1><c:out value="Subject: ${HelpTicket.subject}"/></t1>
                                        <br>
                                        <t1><t1><c:out value="Date Sent: ${HelpTicket.datesent}"/></t1></t1>
                                    </div>
                                    </a>
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
