<%-- 
    Document   : header
    Author     : giorgia
--%>

<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${page == 'login'}">
    <div id="navblock" >
        <header>   
            <img id="NB" alt="NerdBook" src="M3/image/NB.png" >
            <h1>NerdBook </h1>              
        </header>
    </div>
    
</c:if>



<c:choose>
    <c:when test="${page == 'bacheca'}">
        <div id="Bacheca" class="blockbar" >
            <div class="header">
                <header>
                    <h1>NerdBook</h1>            
                </header>
            </div>
        </div>
    </c:when>
    <c:when test="${page=='descrizione'}">
        <header>
            <div id="title">
                <h1>Nerd Book</h1>
            </div>
        </header>
    </c:when>

    <c:when  test="${page == 'profilo'}">
        <div class="header">
            <header>
                <h1>Nerd Book</h1>            
            </header>
        </div>
    </c:when>


</c:choose>

