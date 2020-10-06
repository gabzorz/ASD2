<%-- 
    Document   : viewProperty
    Created on : 27/09/2020, 9:25:46 PM
    Author     : Corey
--%>

<%@page import="uts.asd.model.User"%>
<%@page import="uts.asd.model.Property"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <% 

            Property property = (Property) session.getAttribute("property");
            User user = (User) session.getAttribute("user");
            if (property != null ) {
        %>
    </head>
    <body>
       <%if (property.getStatus() == "pending" && user.getRoleId() == 3 || user.getRoleId() == 2) {%>
       
        <h1>Your property:</h1>
            <form action="UpdatePropertyServlet" method="post">
                <table class="tab">
                    <tr><td>Suburb:</td><td><input type="text" name="suburb" value="<%=property.getSuburb()%>" required></td></tr>
                    <tr><td>Address:</td><td><input type="text"  name="address" value="<%=property.getAddress()%>" required></td></td></tr>
                    <tr><td>Postcode:</td><td><input type="number"  name="postcode" value="<%=property.getPostcode()%>" required></td></tr>
                    <tr><td>State:</td><td><input type="text"  name="state" value="<%=property.getState()%>" required></td><td> </td></tr>
                    <tr><td>Description:</td><td><input type="text"  name="desc" value="<%=property.getDesc()%>" required></td><td> </td></tr>
                    <tr><td>Bathrooms: </td><td><input type="number"  name="bathroom" value="<%=property.getNumOfBathrooms()%>" required></td><td> </td></tr>
                    <tr><td>Bedrooms: </td><td><input type="number"  name="bedroom" value="<%=property.getNumOfBedrooms()%>" required></td><td> </td></tr>
                    <tr><td>Garages: </td><td><input type="number"  name="garage" value="<%=property.getNumOfGarages()%>" required></td><td></td></tr>
                    <tr><td>Status: </td><td><input type="text"  name="status" value="<%=property.getStatus()%>" readonly></td><td></td></tr>
                    </table>
                    <input type="submit" name="Update" value="Update">    
            </form>
        
            <form action="DeletePropertyServlet" method="post">
                <input type="hidden" name="hidden">
                <input type="submit" name="Delete" value="Delete">
            </form>
        <% } %>
            <form action="homepage.jsp" method="post">
                <input type="hidden" name="hidden">
                <input type="submit" name="Go Back" value="Go Back">
            </form>
    </body>
</html>





<% } else { %>

    <body>
        <h1>You do not have any properties!</h1>
        Click <a href="homepage.jsp">here</a> to return home.
        
            
    </body>
</html>

<% } %>