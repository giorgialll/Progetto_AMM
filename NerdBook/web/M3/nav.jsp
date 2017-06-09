<%-- 
    Document   : nav
    Author     : giorgia
--%>


<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:if test="${page != 'login'}">
    <c:if test="${page == 'descrizione'}">
         <nav id="Summury" class="Friends">            
                <ul>
                    <li><a href="#Descrizione">In che cosa consiste</a></li>
                    <li><a href="#Iscrizione">Come iscriversi</a></li>
                    <li><a href="#gratis">Pagamento</a></li>
                </ul>

            </nav>
    </c:if>

    <c:if test="${page != 'descrizione' }">

        <div class="nav">
            <c:choose>
                <c:when test="${page=='bacheca'}">        

                    <nav id="link" class="barra" >         
                        <ul>
                            <li><a href="descrizione.jsp">Home</a></li>
                            <li><a href="profilo.jsp">Profilo</a></li>
                            <li><a class ="pg_attuale" href="bacheca.jsp">Bacheca </a></li>
                        </ul>     
                    </nav>                    

                </c:when>

                <c:when test="${page=='profilo'}">
                    
                        <nav class="barra" >
                            <ul>
                                <li><a href="descrizione.jsp">Home</a></li>
                                <li><a class="pg_attuale" href="profilo.jsp">Profilo</a></li>
                                <li><a href="bacheca.jsp">Bacheca </a></li>

                            </ul>
                        </nav>

                    

                </c:when>

            </c:choose>
    </c:if>   

</c:if>
