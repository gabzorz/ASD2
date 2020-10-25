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
        if (user != null) {
    %>
   
    <body>

        <div class="header">
            <h1>User List</h1>
        </div>
        <sql:setDataSource var = "snapshot" driver = "org.apache.derby.jdbc.ClientDriver"
                           url = "jdbc:derby://localhost:1527/REAMS"
                           user = "ASDREAMS"  password = "ASDREAMS"/>
         <sql:query dataSource = "${snapshot}" var = "result">
        SELECT * FROM USER_ACCOUNT
           </sql:query>
        <table class="centerTable" border = "1" width = "80%">
            <tr>

                <th style="height: 40px">First Name</th>
                <th style="height: 40px">Last Name</th>
                <th style="height: 40px">Address</th>
                <th style="height: 40px">Date of Birth</th>
                <th style="height: 40px">Email</th>
                <th style="height: 40px">Number</th>
                <th style="height: 40px">Password</th>
                <th style="height: 40px">User ID</th>
            </tr>        
            <c:forEach var = "row" items = "${result.rows}">
                <tr:hover>
                <td style="height: 25px"><c:out value = "${row.fName}"/></td>
                <td style="height: 25px"><c:out value = "${row.lName}"/></td>
                <td style="height: 25px"><c:out value = "${row.address}"/></td>
                <td style="height: 25px"><c:out value = "${row.dateofbirth}"/></td>
                <td style="height: 25px"><c:out value = "${row.emailaddress}"/></td>
                <td style="height: 25px"><c:out value = "${row.contactnumber}"/></td>
                <td style="height: 25px"><c:out value = "${row.password}"/></td>
                <td style="height: 25px"><c:out value = "${row.roleid}"/></td>
                </tr>
            </c:forEach>
        </table>
        Click <a href="homepage.jsp">here</a> to go back.
    </body>
<% } else { %>

    <h1>There are no registered users</h1>
    Click <a href="sysMain.jsp">here</a> to go back.            
</body>
</html>
<% }%>
<!-- This is a test comment -->