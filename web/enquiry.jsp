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
            User loggedinuser = (User) session.getAttribute("user"); 
            String enquiryuserId = request.getParameter("id");
        %>
        <div class="header-img">
          <a href="homepage.jsp"><img class="logo" src="css/reams_logo.png"/></a>
        </div>

        </div>
        <div class="enquirebox">
            <div class="enquirebox2">
                <form action="EnquiryServlet" method="post">
                    <input type="hidden" name="receiverId" value="<c:out value ="${sendto}"/>">
                    
                    <a2>Enquiry Details:</a2>
                    <br>
                    <textarea style="resize: none; height: 20em; width: 97%; font:12px Arial, sans-serif;;" maxlength="1000" name="message" placeholder="Write up to 1000 characters"></textarea>
                    <br>
                    <div class="helpticketwrapper">
                    <input class="helpticketbutton" type="submit" value="Send Enquiry">
                    <br>
                    </div>
                    </form>
            </div>
                   
        </div>
    </body>
</html>
