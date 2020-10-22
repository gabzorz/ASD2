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
            <div class="row">
                <div class="column">
                    <a1>Pending Tickets</a1>
                    <div class="ticketlistwrapper">
                        <c:if test ="${not empty requestScope['pendinghelpticketslist']}">
                                <c:forEach var="HelpTicket" items="${requestScope['pendinghelpticketslist']}">
                            <c:url var="editTicketLink" value="EditTicketServlet">
                                <c:param name="Ticketid" value="${HelpTicket.helpTicketId}"/>
                            </c:url>
                                    <a href="${editTicketLink}">
                                        <div class="ticket1">
                                        <t1><c:out value="Ticket ID: ${HelpTicket.helpTicketId}"/></t1>
                                        <t1 style="float:right"><c:out value="${HelpTicket.status}"/></t1>
                                        <br>
                                        <t1><c:out value="User ID: ${HelpTicket.userId}"/></t1>
                                        <br>
                                        <t1><c:out value="Subject: ${HelpTicket.subject}"/></t1>
                                    </div>
                                    </a>
                                </c:forEach>
                        </c:if>
                </div>
                </div>
                <div class="column">
                    <a1>Assigned Tickets</a1>
                    <div class="ticketlistwrapper">
                        <c:if test ="${not empty requestScope['assignedhelpticketslist']}">
                                <c:forEach var="HelpTicket" items="${requestScope['assignedhelpticketslist']}">
                            <c:url var="editTicketLink" value="EditTicketServlet">
                                <c:param name="Ticketid" value="${HelpTicket.helpTicketId}"/>
                            </c:url>
                                    <a href="${editTicketLink}">
                                    <div class="ticket2">
                                        <t1><c:out value="Ticket ID: ${HelpTicket.helpTicketId}"/></t1>
                                        <t1 style="float:right"><c:out value="${HelpTicket.status}"/></t1>
                                        <br>
                                        <t1><c:out value="User ID: ${HelpTicket.userId}"/></t1>
                                        <br>
                                        <t1><c:out value="Subject: ${HelpTicket.subject}"/></t1>
                                    </div>
                                    </a>
                                </c:forEach>
                        </c:if>
                </div>
                </div>
                <div class="column">
                    <a1>Completed Tickets</a1>
                    <div class="ticketlistwrapper">
                        <c:if test ="${not empty requestScope['completehelpticketslist']}">
                                <c:forEach var="HelpTicket" items="${requestScope['completehelpticketslist']}">
                            <c:url var="editTicketLink" value="EditTicketServlet">
                                <c:param name="Ticketid" value="${HelpTicket.helpTicketId}"/>
                            </c:url>
                                    <a href="${editTicketLink}">
                                    <div class="ticket3">
                                        <t1><c:out value="Ticket ID: ${HelpTicket.helpTicketId}"/></t1>
                                        <t1 style="float:right"><c:out value="${HelpTicket.status}"/></t1>
                                        <br>
                                        <t1><c:out value="User ID: ${HelpTicket.userId}"/></t1>
                                        <br>
                                        <t1><c:out value="Subject: ${HelpTicket.subject}"/></t1>
                                    </div>
                                    <a/>
                                </c:forEach>
                        </c:if>
                </div>
                </div>
            </div>        
        </div>
    </body>
</html>
