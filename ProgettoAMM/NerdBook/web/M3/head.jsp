<%-- 
    Document   : head
    Created on : 27-apr-2017, 12.05.24
    Author     : giorgia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:choose>
            <c:when test="${page=='Descrizione'}">
                <title>NerdBook </title>
            </c:when>
            
                <c:when test="${page=='Profilo'}">
                    <title>NerdBook - Profilo</title>
                </c:when>  
                    
                <c:when test="${ page == 'Bacheca'}">
                     <title>NerdBook - Bacheca </title>
                </c:when>
                <c:otherwise>
                    <title>NerdBook - Login </title>
                </c:otherwise>
        </c:choose>
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Giorgia Lallai">
        <meta name="keywords" content="NerdBook gratis gratuito cerca  amore nerd social amicizie amici">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen"> 
    </head>
    
</html>
