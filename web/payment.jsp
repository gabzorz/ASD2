<%-- 
    Document   : payment
    Created on : 26/09/2020, 7:50:52 PM
    Author     : CristinaFidelino
--%>

<%@page import="uts.asd.model.User"%>
<%@page import="uts.asd.model.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Payment_Styling.css">
        <title>Payments</title>
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
            <a style="float: left;">Real Estate News</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        
        <main>
            <form method="post" action="PaymentAddServlet" style="text-align: center;">
                <h1>Payment Account Information</h1>
                <h2 style="color:red">* marks required fields</h2>
                
                <label for="accountNumber">Account Number*</label>
                <input maxlength="8" id="accountNumber" name="accountNumber" type="text" required="true" placeholder="12345678"/>
                <label for="bsb">BSB*</label>
                <input maxlength="7" id="bsb" name="bsb" type="text" required="true" placeholder="XXYZZZ"/>
                
                <br>
                
                <div>
                    <input class="button" type="submit" value="Add Payment"/><br>
                </div>
            </form>
        </main>
        
    </body>
</html>
