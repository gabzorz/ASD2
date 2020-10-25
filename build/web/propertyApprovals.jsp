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
        <link rel="stylesheet" href="css/SEAN_CSS.css">
        <title>Property Approvals</title>
    </head>

    <%

        User user = (User) session.getAttribute("user");
        if (user != null && user.getRoleId() == 1 || user.getRoleId() == 2) {

    %>
    <body>
        <div class="pagewrapper">
            <p style="float:right; font-size: 12px;"><%= user.getRoleId()%>: You're logged in as <%= user.getfName()%></p>
            <div class="header-img">
                <a href="homepage.jsp"><img class="logo" src="css/reams_logo.png"/></a>
            </div>
            <div class="topnav">
                <a href="LogoutServlet"><button>Logout</button></a>
                <a href="CustomerEditServlet?email='<%=user.getEmailAddress()%>'&password='<%=user.getPassword()%>'" style="color:black;"><button>Profile</button></a>
                <a href="homepage.jsp"><button>Homepage</button></a>
                <b>
                    <form class="search" action="SearchServlet" method="get">
                        <input class="searchBox" type="text" name="propertysearch" placeholder="Search by state, suburb or postcode">
                        <img class="navicon" src="css/icons/icon(bedroom).png" alt=""/>
                        <select name="bedroomselect">
                            <option value="%">Any</option>
                            <option value="1">1 Bed</option>
                            <option value="2">2 Beds</option>
                            <option value="3">3 Beds</option>
                            <option value="4">4 Beds</option>
                            <option value="5">5+ Beds</option>
                        </select>
                        <img class="navicon" src="css/icons/icon(garage).png" alt=""/>
                        <select name="garageselect">
                            <option value="%">Any</option>
                            <option value="1">1 Car</option>
                            <option value="2">2 Cars</option>
                            <option value="3">3 Cars</option>
                            <option value="4">4+ Cars</option>
                        </select>
                        <input type="submit" value="Search Properties"></input>
                    </form>
                </b>
            </div>
            <body>
                <div class="header">
                    <h1>Approval List </h1>
                </div>
                <sql:setDataSource var = "snapshot" driver = "org.apache.derby.jdbc.ClientDriver"
                                   url = "jdbc:derby://localhost:1527/REAMS"
                                   user = "ASDREAMS"  password = "ASDREAMS"/>
                <sql:query dataSource = "${snapshot}" var = "result">
                    SELECT * FROM PROPERTY WHERE STATUS = 'PENDING' OR STATUS = 'pending' OR STATUS = 'Successful' OR STATUS = 'Unsuccessful'
                </sql:query>
                <table border = "1" width = "80%" class="centerTable">
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
                            <td>
                                <c:if test="${row.status == 'pending'}">
                                    <input type="submit" value='Approve' name="Approve">
                                </c:if>
                                <c:if test="${row.status == 'PENDING'}">
                                    <input type="submit" value='Approve' name="Approve">
                                </c:if>
                                <c:if test="${row.status == 'Unsuccessful'}">
                                    <input type="submit" value='Approve' name="Approve">
                                </c:if>
                            </td>
                        </form>
                        </tr>
                    </c:forEach>
                </table>
            </body>
        </table>
        <% } else { %>

        <body>
            <h1>You are not authorized to be here</h1>
        </body>
</body>
</html>
<% }%>


<!-- This is a test comment -->