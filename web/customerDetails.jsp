<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.asd.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/USER_REAMS.css">
        <title>Customer Details Page</title>
    </head>
    <body>
        <%
            String updated = (String) session.getAttribute("updated");
            User user = (User) session.getAttribute("user");
            String fnameErr = (String) session.getAttribute("fnameErr");
            String lnameErr = (String) session.getAttribute("lnameErr");
            String numErr = (String) session.getAttribute("numErr");
            String passErr = (String) session.getAttribute("passErr");
            String empErr = (String) session.getAttribute("empErr");
        %>

        <div class="header">
            <h1>Personal Information</h1>
        </div>

        <div class="top_right_link_div">
            <a href="LogoutServlet"><button>Logout</button></a>
        </div>

        <div class="center">
            <p>Enter the new details in the text box and click update if you would like to change your details</p>
            <span><%=(updated != null ? updated : "")%></span><span><%=(empErr != null ? empErr : "")%></span>
        </div>

        <form action="CustomerUpdateServlet" method="post">
            <table class="tab">
                <tr><td>First Name:</td><td><input type="text" name="fname" value="<%=user.getfName()%>"></td><td> <%=(fnameErr != null ? fnameErr : "")%></td></tr>
                <tr><td>Last Name:</td><td><input type="text"  name="lname" value="<%=user.getlName()%>"></td><td> <%=(lnameErr != null ? lnameErr : "")%></td></tr>
                <tr><td>Address:</td><td><input type="text"  name="address" value="<%=user.getAddress()%>"></td></tr>
                <tr><td>Contact number:</td><td><input type="text"  name="number" value="<%=user.getContactNumber()%>"></td><td> <%=(numErr != null ? numErr : "")%></td></tr>
                <tr><td>Password:</td><td><input type="password"  name="password" value="<%=user.getPassword()%>"></td><td> <%=(passErr != null ? passErr : "")%></td></tr>
                <tr><td>Email: </td><td><input type="text"  name="email" value="<%=user.getEmailAddress()%>"></td><td> <%=(passErr != null ? passErr : "")%></td></tr>
            </table>

            <table>
                <tr>
                <a class="bttn" href="homepage.jsp">Go back</a>
                <a><input class="bttn" type="submit" value="Update"></a>
                </tr>
            </table>
        </form>

        <%if (user.getRoleId() == 3) {%>

        <p>If you wish to delete your account click <a href="DeleteServlet"><button class="bttn">Delete</button></a></p>

        <%} else {
            }%>



    </body>
</html>
