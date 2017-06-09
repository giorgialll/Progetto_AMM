/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giorgia
 */
public class GruppoFactory {
    
    private static GruppoFactory singleton;
    private String connectionString ;

    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }

    private ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();

    private GruppoFactory() {
        
        
       /* 
        UtenteRegistratoFactory utenteregistratoFactory =UtenteRegistratoFactory.getInstance();
        
        UtenteRegistrato utente0 = utenteregistratoFactory.getUtentiId(0);
        UtenteRegistrato utente1 = utenteregistratoFactory.getUtentiId(1);
        UtenteRegistrato utente2 = utenteregistratoFactory.getUtentiId(2);
        
        //Creazione dei gruppi
        Gruppo gruppo1 = new Gruppo();
        gruppo1.setId(1);
        gruppo1.setNome("Nerd for nerd");
        gruppo1.setDescrizione("Solo per nerd");
        gruppo1.addUtente(utente0);
        gruppo1.addUtente(utente1);
        
        Gruppo gruppo2 = new Gruppo();
        gruppo2.setId(2);
        gruppo2.setNome("Travel");
        gruppo2.setDescrizione("Adatto a chi ama viaggiare e conoscere nuove culture");
        gruppo2.addUtente(utente0);
        gruppo2.addUtente(utente2);
        
        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
        
        */
       
    }
    
    
    public List<Gruppo> getListaGruppiperutente(int user){
         try {
            
            Connection conn = DriverManager.getConnection(connectionString, "utente", "0000");
            
            String query = "SELECT * FROM gruppo "
                         + "JOIN utentepergruppo ON gruppo.gruppo_id = utentepergruppo.gruppo "
                         + "WHERE utente = ?";
            
         
            PreparedStatement stmt = conn.prepareStatement(query);
        
            stmt.setInt(1, user);

            ResultSet res = stmt.executeQuery();
            List<Gruppo> ListaGruppi = new ArrayList();
         
            while (res.next()) {
                Gruppo gruppoAttuale = new Gruppo();  
                
                gruppoAttuale.setId(res.getInt("gruppo_id"));
                gruppoAttuale.setNome(res.getString("nome"));
                gruppoAttuale.setDescrizione(res.getString("descrizione"));
                gruppoAttuale.setAmministratore(res.getInt("amministratore"));
                
                ListaGruppi.add(gruppoAttuale);
            }
            
             
            stmt.close();
            conn.close();
            return ListaGruppi;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;                 
    }
    
    
     public Gruppo getGruppoById(int id) {
         UtenteRegistratoFactory utenteFactory =UtenteRegistratoFactory.getInstance();
        //GruppoFactory gruppoFactory =GruppoFactory.getInstance();
        try {
            Connection conn= DriverManager.getConnection(connectionString,"utente","0000");
            String quesry =
                    " select* from gruppo "
                    +" join UtentePerGruppo on UtentePerGruppo.gruppo = gruppo.gruppo_id"
                    +"where gruppo_id=?";
            PreparedStatement stmt= conn.prepareStatement(quesry);
            stmt.setInt(1, id);
            ResultSet res=stmt.executeQuery();
            if(res.next()){
                Gruppo current= new Gruppo();
                current.setId(res.getInt("gruppo_id"));
                current.setNome(res.getString("nome"));
                UtenteRegistrato amministratore = utenteFactory.getUtentiId(res.getInt("amministratore"));
                current.setDescrizione(res.getString("descrizione"));
                current.setAmministratore(res.getInt("amministratore"));

                stmt.close();
                conn.close();
                return current;
            }
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();  
        }
        /*for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }*/
        return null;
    }
     public Gruppo getUtenteByName(int nomeGruppo)
    {
        for (Gruppo gruppo : this.listaGruppi) 
        {
            if (gruppo.getNome().equals(nomeGruppo));
                return gruppo;
        }
        return null;
    }
     
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
            return this.connectionString;
    }
}
