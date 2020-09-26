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
                                <td><button onclick="">Place Bid</button></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><button>Refresh Auction</button></td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        Time Remaining: <p id="auctionTimeRemaining"></p>
                    </td>
                </tr>
            </table>
        </div>

        <script>
            // Will be auction date.
            var countDownDate = new Date("Sep 28, 2020 09:00:00").getTime();

            var x = setInterval(function () {

                var now = new Date().getTime();

                var distance = countDownDate - now;

                var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                var seconds = Math.floor((distance % (1000 * 60)) / 1000);

                document.getElementById("auctionTimeRemaining").innerHTML = days + "d " + hours + "h "
                        + minutes + "m " + seconds + "s ";

                if (distance < 0) {
                    clearInterval(x);
                    document.getElementById("auctionTimeRemaining").innerHTML = "Auction has ended.";
                }
            }, 1000);
            
            function placeBid(){
                Int newBid = document.getElementById("newBid").value;
            }
        </script>
    </body>
</html>
