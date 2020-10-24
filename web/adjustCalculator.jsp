<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.asd.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/USER_REAMS.css">
        <title>Adjust Calculator Page</title>
    </head>
    <body>

        <div class="header">
            <h1>Adjust Calculators</h1>
        </div>

        <div class="top_right_link_div">
            <a href="LogoutServlet"><button>Logout</button></a>
            <div class="top_left_link_div">
                <a href="homepage.jsp"><button>Home</button></a>
            </div>
        </div>
        
        <p>Select a calculator you want to adjust</p>

        <table class="calTables">
            <tr>
                <td class="calCel">
                    Stamp Duty Calculator
                    <p class="descp">Find out how much you could put towards your deposit.</p>
                    <a href="adjustStampDuty.jsp"><button>Adjust</button></a>
                </td>
            </tr>
        </table>

        
    <a class="bttn" href="staffMain.jsp">Go back</a>


    </body>
</html>
