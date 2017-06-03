<%-- 
    Document   : listaUtentiJson
    Author     : giorgia
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <<c:forEach var="user" items="${listaUtenti}">
        <json:object>
            
            <json:property name="id" value="${user.id}"/>
            <json:property name="nome" value="${user.nome}"/>
            <json:property name="cognome" value="${user.cognome}"/>
            <json:property name="datanascita" value="${user.datanascita}"/>
            <json:property name="frase" value="${user.frase}"/>
            <json:property name="email" value="${user.email}"/>
            <json:property name="password" value="${user.password}"/>
            <json:property name="urProfilo" value="${user.urlProfilo}"/>
            
        </json:object>
    </c:forEach>
</json:array>
