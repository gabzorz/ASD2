<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.asd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/USER_REAMS.css">
        <title>Staff Home Page</title>
    </head>
    <body>
        <div class="header">
            <h1>Staff Mode (REAMS</h1>
        </div>
        <%
            User user = (User) session.getAttribute("user");
        %>

        <% if (user.getfName() != null) {%>

        <div class="top_right_link_div">
            <a href="LogoutServlet"><button>Logout</button></a>
        </div>

        <p>You're logged in as <%= user.getfName()%></p>

         <a href="CustomerEditServlet?email='<%=user.getEmailAddress()%>'&password='<%=user.getPassword()%>'" style="color:black;">View Profile</a>
        
        <%
        } else {
        %>
        <div class="top_right_link_div">
            <a href="index.jsp">Index</a>
        </div>
        <p>You're not signed in <a href='register.jsp'>register</a> or <a href="login.jsp"> login</a></p>
        <%}%>

    </body>
</html>
<!-- This is a test comment -->