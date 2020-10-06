<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.asd.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/USER_REAMS.css">
        <title>Calculator Page</title>
    </head>
    <body>

        <div class="header">
            <h1>Calculators</h1>
        </div>

        <div class="top_right_link_div">
            <a href="LogoutServlet"><button>Logout</button></a>
            <div class="top_left_link_div">
                <a href="homepage.jsp"><button>Home</button></a>
            </div>
        </div>

        <table class="calTables">
            <tr>
                <td class="calCel">
                    Equity Calculator
                    <p class="descp">Calculate how much equity you may be able to access</p>
                    <input type="button" value="Calculate" onClick="equity();"/>
                </td>
                <td class="calCel">
                    Repayment Calculator
                    <p class="descp">See how much your monthly repayments would be</p>
                </td>
                <td class="calCel">
                    Refinance Savings Calculator
                    <p class="descp">Work out how much you could save on your home loan</p>
                </td>
            </tr>
        </table>
        
        

    </body>
</html>