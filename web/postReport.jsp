<%-- 
    Document   : postReport
    Created on : 23/10/2020, 2:43:36 PM
    Author     : CristinaFidelino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Payment_Styling.css">
        <title>Post Report</title>
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
        
        
        <main>
        <form method="post" action="PostAddServlet" style="text-align: center;">
            <h1>Add New Report</h1>
            <label for="title">Post Title</label>
            <input id="title" name="title" type="text" required="true" placeholder="Post Title"/>
            <label for="category">Category</label>
            <input id="category" name="category" type="text" required="true" placeholder="Category"/>
            <label for="content">Post Content</label>
            <input id="content" name="content" type="text" required="true" placeholder="Content"/>
            
            <br>
            
            <div>
                <a class="button" href="customerDetails.jsp"> Cancel </a>
                <input class="button" type="submit" value="Publish"/><br>
            </div>
        </form>
        </main>
    </body>
</html>
