<%-- 
    Document   : Joingame
    Created on : Jan 19, 2016, 12:16:21 PM
    Author     : dell lap
--%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.AllGames" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="joingamestyle.css">
        <title>Join game</title>
    </head>
    <body>
        <div>
            <div class="title">
                <img src="http://mat.imageg.net/cms_widgets/23/42/2342028_assets/Wk47_Family_UNO.png"/>
            </div>
        </div>
        <table align="center">
            <c:forEach items="${allgames.waitingGamesMap}" var="game">

                <tr>
                    <td class="text">
                        <c:url value="/AddPlayer" var="link">
                            <c:param name="gamekey" value="${game.key}"/>
                            <c:param name="description" value="${game.value.description}"/>

                        </c:url>

                        <a href="${link}">Game id:${game.key}</a>
                    </td>
                </tr>
                <tr>
                    <td class="text">
                        Description:${game.value.description}
                    </td>
                </tr>
                <tr>
                    <td class="text">
                        Created by:${game.value.creater}
                    </td>
                </tr>

            </c:forEach>

        </table>
    </body>
</html>
