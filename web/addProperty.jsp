<%@page import="uts.asd.model.Property"%>
<%@page import="uts.asd.model.User"%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/USER_REAMS.css">
        <title>Register Page</title>
    </head>
    <body>
        <div class="header">
            <% 
            User user = (User) session.getAttribute("user");
            Property property = (Property) session.getAttribute("property");
            
            if (property != null) {
                
            %>
            
            <h2>You already have a property listed.</h2>
            <p>Click <a href="viewProperty.jsp">here</a> to view your listed property.
            <p>Return to the home page <a href="homepage.jsp">here</a>.
               
            <%    
            } else if (user.getRoleId() == 3 || user.getRoleId() == 2) {
            %>
            
            <h1>Add property:</h1>
        </div>

        <form action="addPropertyServlet" method="post">
            <table class="tab">
                <tr><td>Suburb</td><td><input type="text" name="suburb" required></td><td></td></tr>
                <tr><td>Address</td><td><input type="text"  name="address" required></td><td></td></tr>
                <tr><td>Postcode</td><td><input type="number" name="postcode" required></td></tr>
                <tr><td>State</td><td><input type="text"  name="state" required></td></tr>
                <tr><td>Property Description</td><td><input type="text"  name="desc" required></td><td> </td></tr>
                <tr><td>Number of bedrooms</td><td><input type="number"  name="bedroom" required></td><td> </td></tr>
                <tr><td>Number of bathrooms</td><td><input type="number"  name="bathroom" required></td><td></td></tr>
                <tr><td>Number of Garages</td><td><input type="number"  name="garage" required></td><td></td></tr>
            </table>

            <table>
                <tr>
                <a class="bttn" href="CancelServlet">Cancel</a>
                <a><input class="bttn" type="submit" value="submit"></a>
                </tr>

            </table>
        </form>
            
            <% } else { %>
            
            <h2>You do not have access to view this page</h2>
            <p>return to the home page <a href="homepage.jsp">here</a>.
            
            
            <% } %>
    </body>
</html>