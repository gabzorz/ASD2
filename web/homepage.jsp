<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.asd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/SEAN_CSS.css">
        <title>Home Page</title>
        <%
            User user = (User) session.getAttribute("user");
        %>
    </head>
    <body>
        <div class="pagewrapper">
        <% if (user != null) {%>
        <p style="float:right; font-size: 12px;"><%= user.getRoleId()%>: You're logged in as <%= user.getfName()%></p>
        <div class="header-img">
          <a href="homepage.jsp"><img class="logo" src="css/reams_logo.png"/></a>
        </div>
        <div class="topnav">
            <a href="LogoutServlet"><button>Logout</button></a>
            <a href="CustomerEditServlet?email='<%=user.getEmailAddress()%>'&password='<%=user.getPassword()%>'" style="color:black;"><button>Profile</button></a>
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
            <div class="content">
                <row>
                <a href="properties.jsp" class="lmaoproperty" style="color:black; background-color:cornflowerblue">View all Auctions</a>
                <a href="addKeywords.jsp" class="lmaokeywords" style="color:black; background-color:orange">Add keywords</a>
                <a href="myKeywords.jsp" class="lmaokeywords" style="color:black; background-color:orange">My Keywords</a>
                <a href="calculator.jsp" class="lmaokeywords" style="color:black; background-color:cadetblue">Calculators</a>
        <% if(user.getRoleId() == 3) { %>
                <a href="HelpTicketUserServlet?id=<%=user.getUserId()%>" class="lmaokeywords" style="color:black; background-color:palevioletred">Help Tickets</a>
                <a href="addProperty.jsp" class="lmaoproperty" style="color:black; background-color:#99cc00">Add property</a>
                <a href="viewProperty.jsp" class="lmaoproperty" style="color:black; background-color:#99cc00">View property</a>
        <% } %>
        <% if(user.getRoleId() == 1 || user.getRoleId() == 2) { %>
                <a href="adjustCalculator.jsp" class="lmaokeywords" style="color:black; background-color:cadetblue">Adjust Calculator Variables</a>
                <a href="HelpTicketStaffServlet?id=<%=user.getUserId()%>" class="lmaokeywords" style="color:black; background-color:palevioletred">Help Tickets</a>
                <a href="propertyApprovals.jsp" class="lmaoproperty" style="color:black; background-color:#99cc00">Property Approvals</a>
        <% } %>
        <% if(user.getRoleId() == 1) { %>
        <a href="viewUsers.jsp" class="lmaoproperty" style="color:black; background-color:#9966ff">View all Users</a>
                <a href="addUser.jsp" class="lmaoproperty" style="color:black; background-color:#9966ff">Add new user</a>
        <%}%>
                </row>
            </div>
        </div>

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