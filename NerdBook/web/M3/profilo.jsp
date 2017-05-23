<%-- 
    Document   : profilo.jsp
    Author     : giorgia
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>
    <head>
        <title>NerdBook - Profilo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Giorgia Lallai">
        <meta name="keywords" content="Profilo iscrizione gratis NerdBook gratutio cerca  amore nerd social amicizie amici ">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        
        <c:set var="page" value="profilo" scope="request"/>
        
        <div class="blockbar" >
            <jsp:include page="header.jsp"/>
            
            <c:set var="page" value="profilo" scope="request"/>
            <jsp:include page="nav.jsp"/>

            
            
            <div class="Friends" >
                <div class="list">
                    <h3>Amici </h3>
                    <ul>
                        <li><a href="Bacheca.html" >Bob Dog</a></li>
                        <li><a href="Bacheca.html" >Lisa Simposn</a></li>
                        <li><a href="Bacheca.html">Dexter</a></li>
                    </ul>

                    <h3>Gruppi</h3>

                    <ul>
                        <li><a href="Profilo.html">Nerd for nerd</a></li>
                        <li><a href="Profilo.html">Travel</a></li>
                    </ul>                
                </div>
            </div> 
            
            <div id="Logout" class="list">
                <ul>
                    <li><a>Peppa</a> 
                    <li><a id="Log_out" href="Descrizione.html">Logout</a> </li>
                </ul>
            </div>
        </div>
      
        <div id="imgprofilo">
                <img alt="Immagine profilo" src="image/profile.png" >
        </div>
       
        <div id="profileDataForm">
            
            <form action="servlet.java" method="post"  > <!-- cosa va messo nel campo action?-->
                
                <label for="name" class="etichetta" >Nome:</label>
                <input type="text" id="name" name="name" >
                               
                
                <label for="cognome" class="etichetta" >Cognome:</label>
                <input type="text" id="cognome" name="cognome" > 
               
                
              
                <label for="URL" class="etichetta" >URL:    </label>
                <input type="url" id="URL" name="URL">
              
             
                
                <label for="textArea" class="etichetta" > Inserire una frase di presentazione</label>
                <textarea name="textPresentation" id="textArea"  ></textarea>
                
                
                
                <label for="dataNascita" id="etichettadata" class="etichetta" >Inserire la data di nascita:    </label>
                <input type="date" id="dataNascita" name="dataNascita">
              
                
                <label for="pswd" class="etichetta" >Password:</label>
                <input type="password" id="pswd" name="pswd">
                
                
                
                <label for="cpswd" class="etichetta" >Conferma password: </label>
                <input type="password" id="cpswd" name="cpswd">
                
                
                <button type="submit">AGGIORNA</button>
                
            </form>
             
        </div>
        
    </body>
</html>
