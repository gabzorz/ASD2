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
        <%
            String inputErr = (String) session.getAttribute("inputErr");
        %>
        

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
        
        <p><span><%=(inputErr != null ? inputErr : "")%></span></p>
        
        <form method="post" action="ShowStampDutyServlet">
            <table class="indvCalTables">
                <tr>
                    <th class="indvCel">Price Category</th>
                    <th class="indvCel">Variable Price</th>
                    <th class="indvCel">Variable Increase</th>
                    <th class="indvCel">Duitable Variable</th>
                </tr>
                <tr>
                    <td class="indvCel"><input type="text" name="priceCat"></td>
                    <td class="indvCel">${variablePrice}</td>
                    <td class="indvCel">${variableIncrease}</td>
                    <td class="indvCel">${duitableVariable}</td>
                </tr>
                <tr>
                    <td class="indvCel"><button>Show</button></td>
                </tr>
            </table>
        </form>
                
        <form method="post" action="AdjustStampDutyServlet">
            <table class="indvCalTables">
                <tr>
                    <th class="indvCel">Price Category</th>
                    <th class="indvCel">Variable Price</th>
                    <th class="indvCel">Variable Increase</th>
                    <th class="indvCel">Duitable Variable</th>
                </tr>
                <tr>
                    <td class="indvCel"><input type="text" name="priceCategory1"></td>
                    <td class="indvCel"><input type="text" name="variablePrice1"></td>
                    <td class="indvCel"><input type="text" name="variableIncrease1"></td>
                    <td class="indvCel"><input type="text" name="duitableVariable1"></td>
                </tr>
                <tr>
                    <td class="indvCel"><button>Adjust</button></td>
                </tr>
            </table>
        </form>
                
        

    <a class="bttn" href="homepage.jsp">Go back</a>

    </body>
</html>
