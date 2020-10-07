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

        <%
            String inputErr = (String) session.getAttribute("inputErr");
        %>

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
                    <a href="equity.jsp"><button>calculate</button></a>
                </td>
                <td class="calCel">
                    Repayment Calculator
                    <p class="descp">See how much your monthly repayments would be</p>
                    <a href="repayment.jsp"><button>calculate</button></a>
                </td>
                <td class="calCel">
                    Stamp Duty Calculator
                    <p class="descp">Work out how much you could save on your home loan</p>
                    <a href="stampDuty.jsp"><button>calculate</button></a>
                </td>
            </tr>
        </table>

        <p><span><%=(inputErr != null ? inputErr : "")%></span></p>


        <form method="get" action="CalculateRepaymentServlet">
            <table class="indvCalTables">
                <tr>
                    <th class="indvCel">Estimated Property Price</th>
                </tr>
                <tr>
                    <td class="indvCel"><input type="text" name="estPropertyPrice"></td>
                </tr>
                <tr>
                    <td class="indvCel"><button>Calculate</button></td>
                </tr>
                <tr>
                    <th class="indvCel">Stamp duty cost</th>
                </tr>
                <tr>
                    <td class="indvCel">${stamp_duty}</td>
                </tr>
            </table>
        </form>

    </body>
</html>