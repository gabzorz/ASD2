<%-- 
    Document   : payment
    Created on : 26/09/2020, 7:50:52 PM
    Author     : CristinaFidelino
--%>

<<<<<<< HEAD
<%@page import="uts.asd.model.Payment"%>
=======
>>>>>>> caf89223a649b714d999363a5fdf89ced84a7858
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
<<<<<<< HEAD
          <a href="homepage.jsp"><img class="logo" src="css/reams_logo.png"/></a>
=======
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
<<<<<<< HEAD
            <form method="post" action="PaymentAddServlet" style="text-align: center;">
=======
            <form method="post" action="payment_list.jsp" style="text-align: center;">
>>>>>>> caf89223a649b714d999363a5fdf89ced84a7858
                <h1>Payment Account Information</h1>
                <h2 style="color:red">* marks required fields</h2>
                
                <label for="firstName">First Name*</label>
                <input id="firstName" name="firstName" type="text" required="true" placeholder="First Name"/>
                <label for="lastName">Last Name*</label>
                <input id="lastName" name="lastName" type="text" required="true" placeholder="Last Name"/>
                <label for="accountNumber">Account Number*</label>
                <input id="accountNumber" name="accountNumber" type="text" required="true" placeholder="12345678"/>
                <label for="bsb">BSB*</label>
                <input id="bsb" name="bsb" type="text" required="true" placeholder="XXYZZZ"/>
                
                <br>
                
                <div>
<<<<<<< HEAD
                    <a class="button" href="customerDetails.jsp"> Cancel </a>
=======
                    <a class="button" href="CancelServlet"> Cancel </a>
>>>>>>> caf89223a649b714d999363a5fdf89ced84a7858
                    <input class="button" type="submit" value="Add Payment"/><br>
                </div>
            </form>
        </main>
        
    </body>
</html>
