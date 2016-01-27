<%-- 
    Document   : loginpage
    Created on : Jan 18, 2016, 8:57:37 PM
    Author     : dell lap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="loginpagestyle.css">
        <title>login page</title>
    </head>
    <body>
        <div>
            <div class="title">
                <img src="http://mat.imageg.net/cms_widgets/23/42/2342028_assets/Wk47_Family_UNO.png"/>
            </div>
        </div>
        <form action="login" method="post">
            <table align="center">
                <tr>
                    <td class="text">
                        User Id:
                    </td>
                    <td>
                        <input  type="text" name="userid">
                    </td>
                </tr>
                <tr>
                    <td class="text">
                        Password:
                    </td>
                    <td>
                        <input  type="password" name="password">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input class="button" type="submit" value="LOGIN"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
