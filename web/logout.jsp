<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/REAMS_CSS.css">
        <title>Logout Page</title>
    </head>
    <body>
        
        <%
            session.invalidate();
        %>
        <div class="header">
            <h1>You've successfully logged out from REAMS</h1>
        </div>
        <div class="top_right_link_div">
            <a href="index.jsp">Index</a>
        </div>
        <p><a href="index.jsp">Click here</a> to return to REAMS</p>
    </body>
</html>
<!-- This is a test comment -->