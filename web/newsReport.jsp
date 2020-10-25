<%-- 
    Document   : newsReports
    Created on : 23/10/2020, 3:01:22 PM
    Author     : CristinaFidelino
--%>

<%@page import="uts.asd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.asd.model.Post"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Payment_Styling.css">
        <title>News Reports</title>
        <%
            Post post = (Post) session.getAttribute("post");
            User user = (User) session.getAttribute("user");
        %>
    </head>
    <body>
        <div class="header-img">
          <a href="homepage.jsp"><img class="logo" src="css/reams_logo.png"/></a>
        </div>
        
        <div class="topnav">
            <a href="index.jsp"style="float: left;">Home</a>
            <a style="float: left;">Find a Property</a>
            <a style="float: left;">Find Agents</a>
            <a style="float: left;">For Owners</a>
            <a href="newsReport.jsp"style="float: left;">Real Estate News</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        
        <main  style="text-align: center;">
            <h1><%= post.getTitle()%></h1>
            <h2><%= post.getCategory()%></h2>
            <h3><%= post.getContent()%></h3>
        </main>
        
        <%if (user.getRoleId() == 2) {%>
        <table>
            <a class="button" style="text-align: center; "href="editReport.jsp">Edit Report</a>
            <a class="button" href="DeleteServlet">Delete Report</a></p>
        </table>
        <%}%>
    </body>
</html><%-- 
=======--%>
<%-- 
    Document   : newsReports
    Created on : 23/10/2020, 3:01:22 PM
    Author     : CristinaFidelino
--%>
<%-- 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.asd.model.Post"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Payment_Styling.css">
        <title>News Reports</title>
        <%
            Post post = (Post) session.getAttribute("post");
        %>
    </head>
    <body>
        <div class="header-img">
          <a href="homepage.jsp"><img class="logo" src="css/reams_logo.png"/></a>
        </div>
        
        <div class="topnav">
            <a href="index.jsp"style="float: left;">Home</a>
            <a style="float: left;">Find a Property</a>
            <a style="float: left;">Find Agents</a>
            <a style="float: left;">For Owners</a>
            <a href="newsReport.jsp"style="float: left;">Real Estate News</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        
        <main  style="text-align: center;">
            <h1><%= post.getTitle()%></h1>
            <h2><%= post.getCategory()%></h2>
            <h3><%= post.getContent()%></h3>
        </main>
    </body>
</html>
>>>>>>> Cristina
--%>
