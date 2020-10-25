<%@page import="uts.asd.model.Keywords"%>
<%@page import="uts.asd.model.Property"%>
<%@page import="uts.asd.model.User"%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/USER_REAMS.css">
        <title>Register Page</title>
    </head>
    <body>
        <div class="header">
            <% 
            User user = (User) session.getAttribute("user");
            Keywords keywords = (Keywords) session.getAttribute("keywords");
            
            if (user != null) {
                if(keywords == null) {
            %>

            <h1>Add keywords:</h1>
        </div>

        <form action="addKeywordsServlet" method="post">
            <table class="tab">
                <tr><td>Number of bedrooms</td><td><input type="number"  name="bedroom" required></td><td> </td></tr>
                <tr><td>Number of bathrooms</td><td><input type="number"  name="bathroom" required></td><td></td></tr>
                <tr><td>Number of Garages</td><td><input type="number"  name="garage" required></td><td></td></tr>
            </table>

            <table>
                <tr>
                <a class="bttn" href="homepage.jsp">Cancel</a>
                <a><input class="bttn" type="submit" value="submit"></a>
                </tr>

            </table>
        </form>

            <% } else { %>

            <h1>Edit keywords:</h1>
                    <form action="updateKeywordsServlet" method="post">
            <table class="tab">
                <tr><td>Number of bedrooms</td><td><input type="number" value="<%= keywords.getNumOfBedrooms() %>"  name="bedroom" required></td><td> </td></tr>
                <tr><td>Number of bathrooms</td><td><input type="number" value="<%= keywords.getNumOfBathrooms()%>"  name="bathroom" required></td><td></td></tr>
                <tr><td>Number of Garages</td><td><input type="number" value="<%= keywords.getNumOfGarages()%>"  name="garage" required></td><td></td></tr>
            </table>

            <table>
                <tr>
                <a class="bttn" href="homepage.jsp">Cancel</a>
                <a><input class="bttn" type="submit" value="Update"></a>
                </tr>

            </table>
        </form>
            <form action="deleteKeywordServlet" method="post">
                <a><input class="bttn" type="submit" value="Delete"></a>
            </form>

                        <% }} else { %>


            <h2>You do not have access to view this page</h2>
            <p>return to the home page <a href="homepage.jsp">here</a>.
            <% } %>

    </body>
</html> 