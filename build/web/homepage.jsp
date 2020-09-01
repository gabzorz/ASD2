<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.asd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/REAMS_CSS.css">
        <title>Home Page</title>
    </head>
    <body>
        <div class="header">
            <h1>Welcome to REAMS</h1>
        </div>

        <%
            User user = new User();

            String userId = request.getParameter("userId");
            String sysAdminId = request.getParameter("sysId");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String address = request.getParameter("address");
            String dob = request.getParameter("dob");
            String emailAddress = request.getParameter("email");
            String number = request.getParameter("number");
            String password = request.getParameter("password");

            session.setAttribute("name", user);

            user.setUserId(userId);
            user.setSysAdminId(sysAdminId);
            user.setFname(fname);
            user.setLname(lname);
            user.setAddress(address);
            user.setDob(dob);
            user.setEmailAddress(emailAddress);
            user.setNumber(number);
            user.setPassword(password);

            if (user.getFname() != null) {

        %>
        
        <div class="top_right_link_div">
            <a href="logout.jsp">Logout</a>
        </div>
        
        <p>You're logged in as <%= user.getFname()%></p>

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