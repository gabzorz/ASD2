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
        <title>Properties</title>
    </head>

    <%

        User user = (User) session.getAttribute("user");
        if (user != null) {

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
            <div class="header">
                <h1>Auction List </h1>
            </div>
            <body>
                <sql:setDataSource var = "snapshot" driver = "org.apache.derby.jdbc.ClientDriver"
                                   url = "jdbc:derby://localhost:1527/REAMS"
                                   user = "ASDREAMS"  password = "ASDREAMS"/>
                <sql:query dataSource = "${snapshot}" var = "result">
                    SELECT * FROM PROPERTY WHERE STATUS = 'approved'
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
                        <th>Auction</th>
                        <th>Open Days</th>
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
                            <c:if test = "${row.status eq 'approved'}">
                                <%            if (user.getRoleId() != 3) {
                                %>
                                <td>
                                    <a href="JoinAuctionServlet?id=<c:out value = "${row.propertyid}"/>"><button>Join Auction</button></a>
                                    <a href="StartEditAuctionServlet?id=<c:out value = "${row.propertyid}"/>"><button>Edit Auction</button></a>
                                    <a href="CloseAuctionServlet?id=<c:out value = "${row.propertyid}"/>"><button>Close Auction</button></a>
                                </td>
                                <%
                                } else {
                                %>
                                <td><a href="JoinAuctionServlet?id=<c:out value = "${row.propertyid}"/>"><button>Join Auction</button></a></td>
                                <%
                                    }
                                %>
                            </c:if>
                            <c:if test = "${row.status ne 'approved'}">
                            </c:if>
                            <td><a href="ViewOpenDayListServlet?id=<c:out value = "${row.propertyid}"/>"><button>View</button></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </body>
            <% } else { %>

            <body>
                <h1>Oops something went wrong</h1>
                Click <a href="homepage.jsp">here</a> to go back.            
            </body>
    </body>
</html>
<% }%>


<!-- This is a test comment -->