<%-- 
    Document   : payment
    Created on : 26/09/2020, 7:50:52 PM
    Author     : CristinaFidelino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payments</title>
    </head>
    <body>
        <main>
            <form method="post" action="payment_list.jsp">
                <h1>Payment Account Information</h1>
                <h2 style="color:red">* marks required fields</h2>
                
                <label for="firstName">First Name</label>
                <input id="firstName" name="firstName" type="text" required="true" placeholder="First Name"/>
                <label for="lastName">Last Name</label>
                <input id="lastName" name="lastName" type="text" required="true" placeholder="Last Name"/>
                <label for="accountNumber">Account Number</label>
                <input id="accountNumber" name="accountNumber" type="text" required="true" placeholder="12345678"/>
                <label for="bsb">BSB</label>
                <input id="bsb" name="bsb" type="text" required="true" placeholder="XXY-ZZZ"/>
                
                <div>
                    <a class="button" href="CancelServlet"> Cancel </a>
                    <input class="button" type="submit" value="Add Payment"/><br>
                </div>
            </form>
        </main>
        
    </body>
</html>
