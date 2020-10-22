<%@page import="uts.asd.model.Property"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="uts.asd.model.User"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/SEAN_CSS.css">
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
        <div class="editticketwrapper">
            <div class="editticketblocksa">
                <c0>Ticket Details</c0>
                <br>
                <c1>User ID: <c2><c:out value ="${userView.getUserId()}"/></c2></c1>
                <br>
                <c1>User: <c2><c:out value ="${userView.getfName()}"/> <c:out value ="${userView.getlName()}"/></c2></c1>
                <br>
                <c1>Contact: <c2><c:out value ="${userView.getEmailAddress()}"/> | <c:out value ="${userView.getContactNumber()}"/></c2></c1>
                <br>
                <div class="ticketdetails">
                <d1>Help Ticket ID:</d1> <d2><c:out value ="${edithelpticket.getHelpTicketId()}"/></d2>
                <br>
                <d1>Category:</d1> <d2><c:out value ="${edithelpticket.getCategory()}"/></d2>
                <br>
                <d1>Subject:</d1> <d2><c:out value ="${edithelpticket.getSubject()}"/></d2>
                <br>
                <d1>Date Sent:</d1> <d2><c:out value ="${edithelpticket.getDatesent()}"/></d2>
                <br>
                <d1>Details:</d1> <d2><c:out value ="${edithelpticket.getDetails()}"/></d2>
                </div>
                <br>
            </div>
                <div class="editticketblocksb">
                    <c0>Respond to Ticket</c0>
                    <br>
                    <form action="EditTicketServlet" method="post">
                        <input type="hidden" name="helpticketid" value="${edithelpticket.getHelpTicketId()}">
                        <a2>Assigned to Staff ID: <c:out value ="${edithelpticket.getStaffId()}"/></a2>
                        <br>
                        <a2>Status:</a2>
                        <br>
                        <select name="ticketstatusselect">
                        <option value="Assigned" name="Assigned" ${edithelpticket.getStatus() == 'Assigned' ? 'selected' : ''}>Assigned</option>
                        <option value="Complete" name="Complete" ${edithelpticket.getStatus() == 'Complete' ? 'selected' : ''}>Complete</option>
                        </select>
                        <br>
                        <a2>Response:</a2>
                        <br>
                        <textarea style="resize: none; height: 20em; width: 97%; font:12px Arial, sans-serif;;" maxlength="1000" name="response" placeholder="Write up to 1000 characters"><c:out value ="${edithelpticket.getResponse()}"/></textarea>
                        
                        <div class="helpticketwrapper">
                            <input class="helpticketbutton" type="submit" value="Respond to Ticket" ${edithelpticket.getStatus() == 'Complete' ? 'disabled="disabled"' : ''}>
                            <br>
                            <t2> <%=(ticketdetailsErr != null ? ticketdetailsErr : "")%> </t2>
                        </div>
                        <br>
                    </form>
                </div>
            </div>
    </body>
</html>
