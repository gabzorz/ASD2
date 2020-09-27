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
        <title>Payment Information</title>
    </head>
    <body>
        
        <%
            Payment payment = (Payment)session.getAttribute("payment");
        %>
        
        <main>
            <h1>Linked Accounts</h1>
            
            <table>
                <tr>
                  <th>Payment ID</th>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Account Number</th>
                  <th>BSB</th>
                </tr>
                <tr>
                  <td>${payment.paymentID}</td>
                  <td>${payment.firstName}</td>
                  <td>${payment.lastName}</td>
                  <td>${payment.accountNumber}</td>
                  <td>${payment.bsb}</td>
                </tr>
            </table>
        </main>
        
    </body>
</html>
