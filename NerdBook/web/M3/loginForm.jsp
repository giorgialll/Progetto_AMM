<%-- 
    Document   : loginForm
    Author     : giorgia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <head>
        <title>NerdBook - Login </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Giorgia Lallai">
        <meta name="keywords" content="login Login iscrizione gratis NerdBook gratutio cerca  amore nerd social amicizie amici profilo">
        <link rel="stylesheet" type="text/css" href="M3/style.css" media="screen">
    </head>
    
    </head>

    <body>
        <c:set var="page" value="login" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <div id="accessForm">
           
                
            <c:if test="${invalidData == true}"> 
                <div id="invalidDataWarning">I dati inseriti non sono corretti!!!</div>
            </c:if>
            <!-- action= lo passa alla servlet login(nome servler -->
            <form action="Login" method="post">
                 <label for="name" class="credenziali" >Username:</label><br>
                <input type="text" id="name" name="name" ><br>
                <label for="pswd" class="credenziali" >Password:</label><br>
                <input type="password" id="pswd" name="pswd"><br>
                
                <button class="botton" type="submit">LOGIN</button>
            </form>
            
        </div>
        
    </body>
</html>
