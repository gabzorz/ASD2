<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="uts.asd.model.User"%>
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
        if (user != null && user.getRoleId() == 1 || user.getRoleId() == 2 ) {

    %>
    <body>

        <div class="header">
            <h1>Approval List </h1>
        </div>
    <body>
        <sql:setDataSource var = "snapshot" driver = "org.apache.derby.jdbc.ClientDriver"
                           url = "jdbc:derby://localhost:1527/REAMS"
                           user = "ASDREAMS"  password = "ASDREAMS"/>
         <sql:query dataSource = "${snapshot}" var = "result">
        SELECT * FROM PROPERTY WHERE STATUS = 'pending'
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
                <th>Approve</th>
            </tr>      
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
                <form action="propertyApproval" method="get">
                <input type="hidden" value="${row.userid}" name="id">
                <td><input type="submit" value='Approve' name="Approve"</td>
                </form>
                </tr>
            </c:forEach>
        </table>

        Click <a href="homepage.jsp">here</a> to go back.
    </body>
</table>
<% } else { %>

<body>
    <h1>You are not authorized to be here</h1>
    Click <a href="homepage.jsp">here</a> to go back.            
</body>
</body>
</html>
<% }%>


<!-- This is a test comment -->