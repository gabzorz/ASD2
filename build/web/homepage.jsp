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
        %>
    </head>
    <body>
        <% if (user != null) {%>
        <div class="header">
            <h1>Welcome to REAMS</h1>
        </div>

        <div class="top_right_link_div">
            <a href="LogoutServlet"><button>Logout</button></a>
        </div>

        <p>You're logged in as <%= user.getfName()%></p>
        <a href="CustomerEditServlet?email='<%=user.getEmailAddress()%>'&password='<%=user.getPassword()%>'" style="color:black;">View Profile</a>
        <a href="addProperty.jsp" style="color:black;">Add property</a>
        <a href="viewProperty.jsp" style="color:black;">View property</a>
        <a href="calculator.jsp" style="color:black;">Calculators</a>

        

        <%
        } else {
        %>
        <div class="header">
            <h1>Welcome to REAMS</h1>
        </div>
        <div class="top_right_link_div">
            <a href="index.jsp">Index</a>
        </div>
        <p>You're not signed in <a href='register.jsp'>register</a> or <a href="login.jsp"> login</a></p>
        <%}%>

    </body>
</html>
<!-- This is a test comment -->