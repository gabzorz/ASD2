<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/REAMS_CSS.css">
        <title>Register Page</title>
    </head>
    <body>
        <div class="header">
            <h1>Register</h1>
        </div>
        <div class="top_right_link_div">
            <a href="index.jsp">Index</a>
        </div>
        <form action="homepage.jsp" method="post">
            <table>
                <tr><td>First Name:</td><td><input type="text" placeholder="Enter first name" name="fname" required="true"></td></tr>
                <tr><td>Last Name:</td><td><input type="text" placeholder="Enter last name" name="lname" required="true"></td></tr>
                <tr><td>Date of Birth:</td><td><input type="date" name="dob" required="true"></td></tr>
                <tr><td>Address:</td><td><input type="text" placeholder="Enter Address" name="address" required="true"></td></tr>
                <tr><td>Email:</td><td><input type="text" placeholder="Enter email" name="email" required="true"></td></tr>
                <tr><td>Contact number:</td><td><input type="text" placeholder="Enter contact number" name="number" required="true"></td></tr>
                <tr><td>Password:</td><td><input type="password" placeholder="Enter password" name="password" required="true"></td></tr>
            </table>
       
        <table>
            <tr>
                <td><a href="index.jsp"><button>Cancel</button></a></td>
                <td><input type="submit" value="Register"></td>
            </tr>
            <tr>
                <td><a href="login.jsp">Already a member?</a></td>
            </tr>
        </table>
 </form>
    </body>
</html>
<!-- This is a test comment -->