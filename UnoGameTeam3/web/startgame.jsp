<%-- 
    Document   : startgame
    Created on : Jan 21, 2016, 12:56:22 PM
    Author     : dell lap
--%>

<%@page import="Model.Player"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Game</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" type="text/css" href="startgamestyle.css">

        <script src="lib/jquery-2.2.0.min.js"></script>
        <script src="ShowCards.js"></script>
    </head>
    <body>
        <h1 id="connectbutton"></h1>


        <table>
            <tr>
                <td>
                    <h1>Deck</h1>
                    <img src="Images/back.png"/>
                </td>
                <td>
                    <h1 align="center">Discarded pile</h1>
                    <img class="pile" id="pile" />
                </td>
                <td>
                    <% String gameid = (String) request.getAttribute("gamekey");
                        Player p = (Player) request.getSession().getAttribute("user");
                        String userid = (String) p.getUserid();
                        System.out.println("game id in start game = " + gameid);%>
                    <input type="hidden" name="gamekey" id="gamekey" value="<%=gameid%>"/>
                    <input type="hidden" name="userkey" id="userkey" value="<%=userid%>"/>
                    <button class="button" type="submit" id="showcards">Show Cards</button>
                </td>
                <td>
                    <h1>Winning Score</h>
                        <h1 id="score">0</h1>
                </td>
                <td>
                    <form action="logout" method="post">
                        <button id="logout" class="button" type="submit">Logout</button>
                    </form>
                </td>
            </tr>
        </table>


        <h1 align="center">My Cards</h1>
        <div id="mycards"></div>
        <ul id="chats"></ul>
    </body>
</html>
