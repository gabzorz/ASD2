<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/USER_REAMS.css">
        <title>Index Page</title>
    </head>
    <body>
        <div class="header">
            <h1>Welcome to REAMS</h1>
        </div>
        <div class="top_right_link_div">
            <a href="login.jsp">Login</a>
            <a href="register.jsp">Register</a>
            <a href="homepage.jsp">Continue as guest</a>
            <a href="createAuction.jsp">Create Auction</a>
        </div>
        <h1>Real Estate Auction Management System</h1>
    </body>
    <jsp:include page="/ConnServlet" flush="true"/>
</html>
