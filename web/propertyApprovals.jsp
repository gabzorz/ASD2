<%-- 
    Document   : propertyApprovals
    Created on : 03/10/2020, 10:24:16 PM
    Author     : Corey
--%>

<%@page import="uts.asd.model.User"%>
<%@page import="java.util.HashMap"%>
<%@page import="uts.asd.model.Property"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% HashMap<Integer, Property> properties = (HashMap<Integer, Property>) session.getAttribute("properties"); 
        Gson gson = new Gson();
        
        
            int size = properties.size();
            User user = (User) session.getAttribute("user");
            Property property;
            if (properties != null) {
               
            if (user.getRoleId() == 2) {
        %> 
    </head>
    <body>
        <h1>Approvals</h1>
        <table>
            <tr>
                <th>Address</th>
                <th>Suburb</th>
                <th>State</th>
                <th>Postcode</th>
                <th>Bathrooms</th>
                <th>Bedrooms</th>
                <th>Garages</th>
                <th>Desc</th>
                <th>Email:</th>
                <th>Approval?</th>
            </tr>
            <%
            for(int i = 0; i < size; i++){
                property = properties.get(i);
                %>
                <tr>
                    <th><%=property.getAddress()%></th>
                    <th><%=property.getSuburb()%></th>
                    <th><%=property.getState()%></th>
                    <th><%=property.getPostcode()%></th>
                    <th><%=property.getNumOfBathrooms()%></th>
                    <th><%=property.getNumOfBedrooms()%></th>
                    <th><%=property.getNumOfGarages()%></th>
                    <th><%=property.getDesc()%></th>
                    <th><%=property.getUserEmail() %></th>
                </tr>   
                <% }}} %>
        </table>
    </body>
</html>
