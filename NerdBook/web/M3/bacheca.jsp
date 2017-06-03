<%-- 
    Document   : bacheca
    Created on : 25-apr-2017, 15.52.49
    Author     : giorgia
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
       <title>NerdBook - Bacheca </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Giorgia Lallai">
        <meta name="keywords" content="Bacheca iscrizione gratis NerdBook gratutio cerca  amore nerd social amicizie amici profilo">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/javascript.js"></script>
    </head>
    
    <body>
        
        
        <div id="Bacheca" class="blockbar">
            
            <c:set var="page" value="bacheca" scope="request"/>
            
            <jsp:include page="header.jsp"/>
            
            <jsp:include page="nav.jsp"/>
            
            <div id="logout" class="list">
                <ul>
                    <li><a>${user.nome}</a> 
                    <li><a id="log_out" href="descrizione.jsp" >Logout</a> </li>
                </ul>
            </div>
        </div>
            
        <div class="Friends" >
            
            <div id="searchUtente">
                <input id="searchField" type="text" placeholder="search..." value="">
                <button id="cerca">CERCA</button>
            </div>
            
            
            <div id="usersList">
                <c:forEach var="utente" items="${utenti}">
                    <div class="user">
                        <div class="profilepic">  
                            <img alt="Immagine del profilo" src="${utente.urlProfilo}" > 
                        </div>
                        <div class="nameprofile">
                            <strong>${utente.nome} ${utente.cognome}</strong>>
                            <a href="index.html?user=${utente.id}">Link al profilo</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
            
            
            <div class="list">
                <h3>Amici </h3>
                <ul>
                    <li><a href="#bob"  >${user.nome}</a></li>
                    <li><a href="#lisa" >${user.nome}</a></li>
                    <li><a href="#dexter" >${user.nome}</a></li>
                </ul>
                
                <h3>Gruppi</h3>
               
                    <ul>
                        <li><a href="bacheca.jsp">Nerd for nerd</a></li>
                        <li><a href="bacheca.jsp">Travel</a></li>
                    </ul>
            </div>
        </div>
        
        <div id="Posts">
            <div class="post">
                <div id="pforpost">
                     <p>Crea un post</p>
                </div>
                <c:choose>
                    <c:when test="${empty newpost}">
                    <div id="nuovopost">
                        <form action="servlet.java" method="post"  > 
                            <textarea name="newpost" id="newpost" class="post" >Aggiungi qui il tuo post...</textarea>

                            <div id="radio">
                                <label for="textType">Link</label>
                                <input type="radio" name="postType" value="textType" id="textType">

                                <label for="imgType">Immagine</label>
                                <input type="radio" name="postType" value="imgType" id="imgType">
                                <div> 
                                    <input type="url" id="url" name="URL" value="Inserire l'url...">
                                </div>
                            </div>
                            <button type="submit" name="thereIsPost" value="needConfirm" id="pubblica">Pubblica</button>
                        </form>
                    </div>
                    </c:when>
                    <c:otherwise>
                    <div id="nuovopost">
                        <form action="servlet.java" method="post">
                            <p ${contenuto_testo}</p>
                                
                            <c:if test="${TipoUrl == 'linkType'}">
                                <p>${url}</p>
                            </c:if>
                            <c:if test="${TipoUrl == 'imgType'}">
                                <p>${url}</p>
                            </c:if>
                            <input type="text" hidden name="newPost" value="${contenuto_testo}">
                            <input type="text" hidden name="postType" value="${TipoUrl}">
                            <input type="url" hidden name="url" value="${url}">
                            <button type="submit" name="thereIsPost" value="needConfirm" id="pubblica">Pubblica</button>
                        </form>
                    </div>
                    </c:otherwise>
                </c:choose>
            </div>
            <c:forEach var="post" items="${posts}">
                <div class="post">
                    <div class="profilepic">
                        <img alt="Immagine del profilo" src="${user.urlProfilo}" > 
                    </div> 
                    <div class="nameprofile">
                        <strong>${user.nome} ${user.cognome}</strong
                    </div>
                    <c:choose>
                        <c:when test="${post.postType == 'IMAGE'}">
                            <img alt="Post con foto" src="${post.url}">
                        </c:when>
                        <c:when test="${post.postType == 'LINK'}">
                            <a href="${post.content}">${post.url}</a>
                        </c:when>
                        <c:otherwise>
                            <div class="userData">
                                <p>${post.conteuto_text}</p>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:forEach>
            
        </div>
    </body>
</html>
