<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/USER_REAMS.css">
        <title>Add User</title>
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
            String exceptionErr = (String)session.getAttribute("exceptionErr");
        %>
        <div class="header">
            <h1>Add User</h1>
        </div>
        <div class="center">
            <p><span><%=(existErr != null ? existErr : "")%></span><span><%=(empErr != null ? empErr : "")%></span></p>
        </div>

        <form action="AddUserServlet" method="post">
            <table class="tab">
                <tr>
                    <td>First Name:</td><td><input placeholder="Enter first name" type="text" name="fname"></td><td> <%=(fnameErr != null ? fnameErr : "")%></td>
                </tr>
                <tr>
                    <td>Last Name:</td><td><input placeholder="Enter last name" type="text"  name="lname" ></td><td> <%=(lnameErr != null ? lnameErr : "")%></td>
                </tr>
                <tr>
                    <td>Date of Birth:</td><td><input type="date" name="dob" ></td>
                </tr>
                <tr>
                    <td>Address:</td><td><input placeholder="Enter address" type="text"  name="address" ></td>
                </tr>
                <tr>
                    <td>Email Address:</td><td><input placeholder="Enter email address" type="text"  name="email" ></td><td> <%=(emailErr != null ? emailErr : "")%></td>
                </tr>
                <tr>
                    <td>Contact number:</td><td><input placeholder="Enter number" type="text"  name="number" ></td><td> <%=(numErr != null ? numErr : "")%></td>
                </tr>
                <tr>
                    <td>Password:</td><td><input placeholder="Enter password" type="password"  name="password" ></td><td> <%=(passErr != null ? passErr : "")%></td>
                </tr>
            </table>

            <table>
                <tr>
                <a class="bttn" href="sysMain.jsp">Cancel</a>
                <a><input class="bttn" type="submit" value="Register"></a>
                </tr>

            </table>

                <p><%=(exceptionErr != null ? exceptionErr : "")%></p>
        </form>
    </body>
</html>
<!-- This is a test comment -->