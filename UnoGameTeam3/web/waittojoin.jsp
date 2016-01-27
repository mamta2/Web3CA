<%-- 
    Document   : waittojoin
    Created on : Jan 18, 2016, 6:59:36 PM
    Author     : dell lap
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="waittojoinstyle.css">
        <title>wait to join</title>
    </head>
    <body>
        <div>
            <div class="title">
                <img src="http://mat.imageg.net/cms_widgets/23/42/2342028_assets/Wk47_Family_UNO.png"/>
            </div>
        </div>
        <form action="StartGame" method="post">
            <table align="center">
                <tr>
                    <td class="text">
                        Game id :
                    </td>
                    <td class="text">

                        <%String gameid = request.getParameter("gamekey");
                            if (gameid != null) {
                                out.println(gameid);
                            }
                        %>
                        <!--${gameId}-->
                    </td>
                </tr>
                <tr>
                    <td class="text">
                        Description :
                    </td>
                    <td class="text">
                        <%String description = request.getParameter("description");
                         if (description != null) {
                             out.println(description);
                         }%>

                        ${description}
                    </td>
                </tr>

                <tr>
                    <td colspan="2" class="text">
                        <p>Waiting for players to join...</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type ="hidden" name="gamekey" value="<%=gameid%>"/>
                        <input class="button" type="submit" name="Start Game" value="Start Game"/> 
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
