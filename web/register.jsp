<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/USER_REAMS.css">
        <title>Register Page</title>
    </head>
    <body>
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String fnameErr = (String) session.getAttribute("fnameErr");
            String lnameErr = (String) session.getAttribute("lnameErr");
            String numErr = (String) session.getAttribute("numErr");
            String empErr = (String) session.getAttribute("empErr");
        %>
        <div class="header">
            <h1>Register</h1>
        </div>
        <div class="center">
            <p><span><%=(existErr != null ? existErr : "")%></span><span><%=(empErr != null ? empErr : "")%></span></p>
        </div>

        <form action="RegisterServlet" method="post">
            <table class="tab">
                <tr><td>First Name:</td><td><input type="text" name="fname"></td><td> <%=(fnameErr != null ? fnameErr : "")%></td></tr>
                <tr><td>Last Name:</td><td><input type="text"  name="lname" ></td><td> <%=(lnameErr != null ? lnameErr : "")%></td></tr>
                <tr><td>Date of Birth:</td><td><input type="date" name="dob" ></td></tr>
                <tr><td>Address:</td><td><input type="text"  name="address" ></td></tr>
                <tr><td>Email Address:</td><td><input type="text"  name="email" ></td><td> <%=(emailErr != null ? emailErr : "")%></td></tr>
                <tr><td>Contact number:</td><td><input type="text"  name="number" ></td><td> <%=(numErr != null ? numErr : "")%></td></tr>
                <tr><td>Password:</td><td><input type="password"  name="password" ></td><td> <%=(passErr != null ? passErr : "")%></td></tr>
            </table>

            <table>
                <tr>
                <a class="bttn" href="CancelServlet">Cancel</a>
                <a><input class="bttn" type="submit" value="Register"></a>
                </tr>

            </table>
            <div class="center">
                <tr>
                    <td><a href="login.jsp">Already a member?</a></td>
                    <td><a href="homepage.jsp">Continue as guest</a></td>
                </tr>
            </div>
        </form>
    </body>
</html>
<!-- This is a test comment -->