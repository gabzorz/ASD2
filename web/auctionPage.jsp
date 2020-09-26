<%-- 
    Document   : auctionPage
    Created on : 22/09/2020, 10:52:25 AM
    Author     : Hamish Lamond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auction</title>
    </head>
    <body>
        <h1>Auction</h1>
        <div>
            <table>
                <tr>
                    <td>
                        <p>Placeholder for image.</p>
                    </td>
                    <td>
                        <table>
                            <tr>
                                <td><p></p></td>
                                <td><p>Placeholder for property name.</p></td>
                            </tr>
                            <tr>
                                <td><p>Current Bid:</p></td>
                                <td><p>$10000</p></td>
                            </tr>
                            <tr>
                                <td><p>Enter Bid:</p></td>
                                <td><input type="number" id="newBid" name="newBid" placeholder="10000"></td>
                                <td><button>Place Bid</button></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><button>Refresh Auction</button></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
