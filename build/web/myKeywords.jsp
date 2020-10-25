<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="uts.asd.model.*"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/USER_REAMS.css">
        <title>Add User</title>
    </head>

    <%

        User user = (User) session.getAttribute("user");
        if (user != null) {
        Keywords keywords = (Keywords) session.getAttribute("keywords");
    %>
    <body>

        <div class="header">
            <h1>Auction List </h1>
        </div>
    <body>
        <sql:setDataSource var = "snapshot" driver = "org.apache.derby.jdbc.ClientDriver"
                           url = "jdbc:derby://localhost:1527/REAMS"
                           user = "ASDREAMS"  password = "ASDREAMS"/>
        <sql:query dataSource = "${snapshot}" var = "result">
            SELECT * FROM PROPERTY WHERE STATUS = 'approved' AND BATHROOM = '<%=keywords.getNumOfBedrooms()%>' AND BEDROOM = '<%=keywords.getNumOfBathrooms()%>' AND GARAGE = '<%=keywords.getNumOfGarages()%>'
        </sql:query>
        <table border = "1" width = "80%">
            <tr>
                <th>Address</th>
                <th>Suburb</th>
                <th>State</th>
                <th>Postcode</th>
                <th>Bathrooms</th>
                <th>Bedrooms</th>
                <th>Garages</th>
                <th>Desc</th>
                <th>Status</th>
                <th>Auction</th>
                <th>Open Days</th>
            </tr>      
            <c:if test="keywords!=null">
            <c:forEach var = "row" items = "${result.rows}">
                <tr>
                    <td><c:out value = "${row.address}"/></td>
                    <td><c:out value = "${row.suburb}"/></td>
                    <td><c:out value = "${row.state}"/></td>
                    <td><c:out value = "${row.postcode}"/></td>
                    <td><c:out value = "${row.bathroom}"/></td>
                    <td><c:out value = "${row.bedroom}"/></td>
                    <td><c:out value = "${row.garage}"/></td>
                    <td><c:out value = "${row.descr}"/></td>
                    <td><c:out value = "${row.status}"/></td>
                    <td></td>
                    <td><a href="ViewOpenDayListServlet?id=<c:out value = "${row.propertyid}"/>">View</a></td>
                </tr>
            </c:forEach>
            </c:if>
        </table>
        Click <a href="homepage.jsp">here</a> to go back.
    </body>
    <% } else { %>

    <body>
        <h1>Oops something went wrong</h1>
        Click <a href="homepage.jsp">here</a> to go back.            
    </body>
</body>
</html>
<% }%>
