<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.asd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/USER_REAMS.css">
        <title>Add User Success</title>
    </head>
    <body>
        <div class="header">
            <h1>Add User </h1>
        </div>
        <%
            User user = (User) session.getAttribute("user");
        %>

        <div class="top_right_link_div">
            <a href="LogoutServlet"><button>Logout</button></a>
        </div>

        <p>You're logged in as <%= user.getfName()%></p>
        
        <div> 
            <p> User has has been added successfully. </p>
        </div>
        <div>
            <a class="bttn" href="sysMain.jsp">Return</a>
        </div>
                
    </body>
</html>