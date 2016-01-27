<%-- 
    Document   : displaycard
    Created on : Jan 18, 2016, 3:27:55 PM
    Author     : dell lap
--%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Unocard"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>display card in hand</title>
    </head>
    <body>
        <c:forEach items="${cardinhand}" var="item">
            <h1> ${item.key}</h1><br>
    <c:forEach items="${item.value}" var="card">
      
        <img src ="${card.link}"/>
</c:forEach>
    <hr>
</c:forEach>
    <h1>
        Discarded pile
    </h1>
    <img src ="${topcard.link}"/>
 
    </body>
</html>
