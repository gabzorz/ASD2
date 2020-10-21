<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.asd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/USER_REAMS.css">
        <title>Home Page</title>
        <%
            User user = (User) session.getAttribute("user");
            int number = user.getUserId();
        %>
    </head>
    <body>
        <% if (user != null) {%>
        <div class="header">
            <h1>Welcome to REAMS</h1>
        </div>

        <div class="top_right_link_div">
            <a href="LogoutServlet"><button>Logout</button></a>
            <b>
                <form class="search" action="SearchServlet" method="get">
                <input class="searchBox" type="text" name="propertysearch" placeholder="Search by state, suburb or postcode" >
                <img class="icon" src="css/icon(bedroom).png" alt=""/>
                <select name="bedroomselect">
                    <option value="%">Any</option>
                    <option value="1">1 Bed</option>
                    <option value="2">2 Beds</option>
                    <option value="3">3 Beds</option>
                    <option value="4">4 Beds</option>
                    <option value="5">5+ Beds</option>
                </select>
                <img class="icon" src="css/icon(garage).png" alt=""/>
                <select name="garageselect">
                    <option value="%">Any</option>
                    <option value="1">1 Car</option>
                    <option value="2">2 Cars</option>
                    <option value="3">3 Cars</option>
                    <option value="4">4 Cars</option>
                    <option value="5">5+ Cars</option>
                </select>
                <input type="submit" value="Search Properties"></input>
                </form>
            </b>
        </div>

        <p>You're logged in as <%= user.getfName()%></p>
        <a href="CustomerEditServlet?email='<%=user.getEmailAddress()%>'&password='<%=user.getPassword()%>'" style="color:black;">View Profile</a>
        <a href="addProperty.jsp" style="color:black;">Add property</a>
        <a href="viewProperty.jsp" style="color:black;">View property</a>
        <a href="calculator.jsp">Calculators</a>
        <% if(user.getRoleId() == 2) { %>
            <a href="propertyApprovals.jsp" style="color:black;">View property</a>
            <a href="adjustCalculator.jsp">Adjust Calculator Variables</a>
        <% } %>
        

        <%
        } else {
        %>
        <div class="header">
            <h1>Welcome to REAMS</h1>
        </div>
        <div class="top_right_link_div">
            <a style="text-decoration:none" href="index.jsp">Index</a>
        </div>
        <p>You're not signed in <a style="text-decoration:none" href='register.jsp'>register</a> or <a style="text-decoration:none" href="login.jsp"> login</a></p>
        <p><a href="calculator.jsp">Calculators</a></p>
        <%}%>

    </body>
</html>
<!-- This is a test comment -->