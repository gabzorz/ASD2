<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/USER_REAMS.css">
        <title>Add User</title>
    </head>
    <body>
        <%
            String id = request.getParameter("userId");
            String driverName = "org.apache.derby.jdbc.ClientDriver";
            String connectionUrl = "jdbc:derby://localhost:1527/REAMS";
            String dbName = "REAMS";
            String userId = "ASDREAMS";
            String password = "ASDREAMS";

            try {
                Class.forName(driverName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
        %>
        <div class="header">
            <h1>User List</h1>
        </div>
        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr>

            </tr>
            <tr>
                <td><b>User ID</b></td>
                <td><b>First Name</b></td>
                <td><b>Last Name</b></td>
                <td><b>Email</b></td>
            </tr>
            <%
                try {
                    connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
                    statement = connection.createStatement();
                    String sql = "SELECT * FROM USER_ACCOUNT";

                    resultSet = statement.executeQuery(sql);
                    while (resultSet.next()) {
            %>
            <tr>

                <td><%=resultSet.getString("USERID")%></td>
                <td><%=resultSet.getString("FNAME")%></td>
                <td><%=resultSet.getString("LNAME")%></td>
                <td><%=resultSet.getString("EMAILADDRESS")%></td>

            </tr>

            <%
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </table>




    </body>
</html>
<!-- This is a test comment -->