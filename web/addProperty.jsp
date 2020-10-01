<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/USER_REAMS.css">
        <title>Register Page</title>
    </head>
    <body>
        <div class="header">
            <h1>Add property:</h1>
        </div>

        <form action="addPropertyServlet" method="post">
            <table class="tab">
                <tr><td>Suburb</td><td><input type="text" name="suburb"></td><td></td></tr>
                <tr><td>Address</td><td><input type="text"  name="address" ></td><td></td></tr>
                <tr><td>Postcode</td><td><input type="number" name="postcode" ></td></tr>
                <tr><td>State</td><td><input type="text"  name="state" ></td></tr>
                <tr><td>Property Description</td><td><input type="text"  name="desc" ></td><td> </td></tr>
                <tr><td>Number of bedrooms</td><td><input type="number"  name="bedroom" ></td><td> </td></tr>
                <tr><td>Number of bathrooms</td><td><input type="number"  name="bathroom" ></td><td></td></tr>
                <tr><td>Number of Garages</td><td><input type="number"  name="garage" ></td><td></td></tr>
            </table>

            <table>
                <tr>
                <a class="bttn" href="CancelServlet">Cancel</a>
                <a><input class="bttn" type="submit" value="submit"></a>
                </tr>

            </table>
        </form>
    </body>
</html>