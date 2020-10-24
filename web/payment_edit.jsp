<%-- 
    Document   : edit_cardDetails
    Created on : 07/06/2020, 7:03:17 PM
    Author     : CristinaFidelino
--%>


<%@page import="uts.asd.model.User"%>
<%@page import="uts.asd.model.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Card Details</title>
    </head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Payment_Styling.css">
        <title>Edit</title>
    </head>
    
    <body>
        
        <%
            Payment payment =(Payment)session.getAttribute("payment");
        %>
        
        <div class="header-img">
          <a href="index.jsp"><img class="logo" src="css/reams_logo.png"/></a>
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
        
        <main class="main-content">
             <div class="greeting">
            <h1>Edit Account Details</h1>
        </div>
            
            <form method="post" action="PaymentEditServlet">
                <h2 class="h2 instructions">Account Details</h2>
                <input id="paymentID" name="paymentID" value="${payment.paymentID}"/>
                
                <label for="firstName">First Name</label>
                <input id="firstName" name="firstName" type="text" placeholder="First Name" value = "<%=payment.getFirstName()%>"/>
                <label for="lastName">Last Name</label>
                <input id="lastName" name="lastName" type="text" placeholder="Last Name" value = "<%=payment.getLastName()%>"/>
                <label for="accountNumber">Account Number</label>
                <input id="accountNumber" name="accountNumber" type="text" placeholder="12345678" value ="<%=payment.getAccountNumber()%>"/>
                <label for="bsb">BSB</label>
                <input id="bsb" name="bsb" type="text" placeholder="XXYZZZ" value="<%=payment.getBsb()%>"/>
                
                <br>
                
                <div>
                    <input class="button" type="submit" value="Save"/><br>
                <p class="p instructions">Return to <a class="p"href = "payment_list.jsp">Payment List</a> </p>
                </div>
                
            </form>
        </main>
    </body>
</html>