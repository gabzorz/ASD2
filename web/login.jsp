<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/USER_REAMS.css">
        <title>Login Page</title>
    </head>
    <body>
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String empErr = (String) session.getAttribute("empErr");
        %>
        <div class="header">
            <h1>Sign in to REAMS</h1>
        </div>
         <div class="center">
            <p><span><%=(existErr != null ? existErr : "")%></span><span><%=(empErr != null ? empErr : "")%></span></p>
        </div>
        <div class="center">
            <form method="post" action="LoginServlet">
                <table class="center">
                    <tr>
                        <td>Email Address</td>
                    </tr>
                    <tr>
                        <td><input type="text" name="email"></td><td><%=(emailErr != null ? emailErr : "")%></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                    </tr>
                    <tr>
                        <td><input type="password" name="password"></td><td><%=(passErr != null ? passErr : "")%></td>
                    </tr>
                </table>
                <div class="center">
                    <a class="bttn" href="CancelServlet">Cancel</a>
                    <a><input class="bttn" type="submit" value="Login"></a>
                </div>
            </form>
        </div>
        <div class="center">
            <p>Don't have account? <a href="register.jsp">Sign up</a>
            <p>or continue as guest <a href="homepage.jsp">click here</a> </p>
        </div>
    </body>
</html>
