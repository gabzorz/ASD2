<%-- 
    Document   : payment_list
    Created on : 26/09/2020, 8:26:48 PM
    Author     : CristinaFidelino
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="uts.asd.model.Payment"%>
<%@page import="uts.asd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Payment_Styling.css">
        <title>Payment Information</title>
    </head>
<<<<<<< HEAD
    <body>       
        <div class="header-img">
          <a href="homepage.jsp"><img class="logo" src="css/reams_logo.png"/></a>
=======
    <body>
        
        <%
            ArrayList<Payment> payments = (ArrayList<Payment>) session.getAttribute("payments");
            String existErr = (String) session.getAttribute("existErr");
            String deleted = (String) session.getAttribute("deleted");
        %>
        
        <div class="header-img">
          <a href="index.jsp"><img class="logo" src="css/reams_logo.png"/></a>
>>>>>>> caf89223a649b714d999363a5fdf89ced84a7858
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
        <table border="1" cellpadding="5">
            
            <h1>Linked Accounts</h1>
            <tr>
                <th>Payment ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Account Number</th>
                <th>BSB</th>
                <th></th>
            </tr>
<<<<<<< HEAD
            <c:forEach var="payment" items="${payment}">
=======
            <c:forEach var="payment" items="${payments}">
>>>>>>> caf89223a649b714d999363a5fdf89ced84a7858
                <tr>
                    <td><c:out value="${payment.paymentID}" /></td>
                    <td><c:out value="${payment.firstName}" /></td>
                    <td><c:out value="${payment.lastName}" /></td>
                    <td><c:out value="${payment.accountNumber}" /></td>
                    <td><c:out value="${payment.bsb}" /></td>
                    <td>
                        <a href="PaymentEditServlet?id=<c:out value ="${payment.paymentID}"/>Edit Payment</a>
                    <br>
                        <a href="PaymentRemoveServlet?id=<c:out value ="${payment.paymentID}"/>Delete</a>      
                    </td>
                </tr>
            </c:forEach>
        </table>
<<<<<<< HEAD
                    <div>
                        <a id="pyb" class="button" href="payment.jsp"> Add New Payment </a>
                    </div>
                    
                    
=======
                    <a id="pyb" class="button" href="payment.jsp"> Add New Payment </a>
>>>>>>> caf89223a649b714d999363a5fdf89ced84a7858
        </main>
    </body>
</html>
