<%-- 
    Document   : nav
    Author     : giorgia
--%>


<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<nav>
    <ul>
        <c:choose>
            <c:when test="${page=='Descrizione'}">
                <li><a href="#Descrizione">In che cosa consiste</a></li>
                <li><a href="#Iscrizione">Come iscriversi</a></li>
                <li><a href="#gratis">Pagamento</a></li>
            </c:when>

            <c:when test="${page == 'Bacheca'}">
                <li><a href="Descrizione.html">Home</a></li>
                <li><a href="Profilo.html">Profilo</a></li>
                <li><a class ="pg_attuale" href="Bacheca.html">Bacheca </a></li>
            </c:when>

            <c:when test="${page == 'Profilo'}">
                <li><a href="Descrizione.html">Home</a></li>
                <li><a class="pg_attuale" href="Profilo.html">Profilo</a></li>
                <li><a href="Bacheca.html">Bacheca </a></li>
            </c:when>

        </c:choose>  
    </ul>
</nav>

