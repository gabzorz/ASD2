<%-- 
    Document   : viewProperty
    Created on : 27/09/2020, 9:25:46 PM
    Author     : Corey
--%>

<%@page import="uts.asd.model.Property"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <% 

            Property property = (Property) session.getAttribute("property");

        %>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table class="tab">
            <tr><td>Suburb:</td><td><input type="text" name="suburb" value="<%=property.getSuburb()%>"></td></tr>
            <tr><td>Address:</td><td><input type="text"  name="address" value="<%=property.getAddress()%>"></td></td></tr>
            <tr><td>Postcode:</td><td><input type="text"  name="postcode" value="<%=property.getPostcode()%>"></td></tr>
            <tr><td>State:</td><td><input type="text"  name="state" value="<%=property.getState()%>"></td><td> </td></tr>
            <tr><td>Description:</td><td><input type="text"  name="desc" value="<%=property.getDesc()%>"></td><td> </td></tr>
            <tr><td>Bathrooms: </td><td><input type="text"  name="bathroom" value="<%=property.getNumOfBathrooms()%>"></td><td> </td></tr>
            <tr><td>Bedrooms: </td><td><input type="text"  name="bedroom" value="<%=property.getNumOfBedrooms()%>"></td><td> </td></tr>
            <tr><td>Garages: </td><td><input type="text"  name="garage" value="<%=property.getNumOfGarages()%>"></td><td></td></tr>
            </table>
    </body>
</html>





<% } %>