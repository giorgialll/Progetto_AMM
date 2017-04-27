<%-- 
    Document   : header
    Created on : 26-apr-2017, 17.36.18
    Author     : giorgia
--%>

<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="header" >
    <!-- uguale per tutti -->
    
    <c:choose>
        
        <c:when test="${page=='Descrizione'}">
            <header>
                <div id="title">
                    <h1>Nerd Book</h1>
                </div>
            </header>
        </c:when>
        
        <c:when  test="${page == 'Bacheca' || page == 'Profilo'}">
            <header>
                <h1>Nerd Book</h1>            
            </header>
        </c:when>
        
    </c:choose>
  
    
   
        
    
    <!-- non login -->
    <c:if test="${page!='Login'}">
        <c:set var="page" value="profilo" scope="request"/>
        <jsp:include page="nav.jsp"/>
    </c:if>
    <!-- fine non login -->
    
</div>