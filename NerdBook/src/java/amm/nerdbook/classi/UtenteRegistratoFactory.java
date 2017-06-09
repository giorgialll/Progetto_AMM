package amm.nerdbook.classi;


import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author giorgia
 */
public class UtenteRegistratoFactory {
   
    private static UtenteRegistratoFactory singleton;
    private String connectionString ;
    /*String date = request.getParameter("dataNascita");

    Date date = new SimpleDateFormat("yyyy-MM-gg").parse(date);
    preparedStatement.setData("date", new java.sql.Date(date.getTime());*/

    public static UtenteRegistratoFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteRegistratoFactory();
        }
        return singleton;
    }
    
     
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    
    private ArrayList<UtenteRegistrato> listaUtenti = new ArrayList<UtenteRegistrato>();

    private UtenteRegistratoFactory() {
        //Creazione utenti

        //Bob Dog
      /*  UtenteRegistrato utente1 = new UtenteRegistrato();
        utente1.setId(0);
        utente1.setNome("Bob");
        utente1.setCognome("Dog");
        utente1.setDataNascita("26 Giugno 1993");
        utente1.setFrase("Amo corrrere nei prati");
        utente1.setEmail("bobdog@hotmail.it");
        utente1.setPassword("254866");
        utente1.setUrlProfilo("image/dog.PNG");

        //Lisa Simpson
        UtenteRegistrato utente2 = new UtenteRegistrato();
        utente2.setId(1);
        utente2.setNome("Lisa");
        utente2.setCognome("Simpson");
        utente2.setDataNascita("14 Genaio 1990");
        utente2.setFrase("Il giallo è il mio colore preferito");
        utente2.setEmail("simpson.lisa@hotmail.it");
        utente2.setPassword("982547456");
        utente2.setUrlProfilo("image/profiloLisa.PNG");
        
        
        //Dexter
        
        UtenteRegistrato utente3 = new UtenteRegistrato();
        utente3.setId(2);
        utente3.setNome("Dexter");
        utente3.setCognome("");
        utente3.setDataNascita("31 Dicembre 1995");
        utente3.setFrase("Il mio laboratorio è unico");
        utente3.setEmail("dexter@hotmail.it");
        utente3.setPassword("58464dc4x5");
        utente3.setUrlProfilo("image/Dexter.jpg");
        
        //Peppa
        UtenteRegistrato utente4 = new UtenteRegistrato();
        utente4.setId(3);
        utente4.setNome("Peppa");
        utente4.setCognome("");
        utente4.setDataNascita("25 Maggio 1985");
        utente4.setFrase("Non giudicate un libro dalla copertina");
        utente4.setEmail("peppa@hotmail.it");
        utente4.setPassword("hfgh45");
        utente4.setUrlProfilo("image/Peppa.png");
       
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        listaUtenti.add(utente4);*/        
       
    }
    
    public UtenteRegistrato getUtentiId(int id) {
      /*  for (UtenteRegistrato utente : this.listaUtenti) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;*/
      try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "0000");
            
            String query = 
                      "select * from Utente "
                    + "where utente_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                UtenteRegistrato current = new UtenteRegistrato();
                current.setId(res.getInt("utente_id"));
                current.setNome(res.getString("name"));
                current.setCognome(res.getString("cognome"));
                current.setEmail(res.getString("email"));
                current.setUrlProfilo(res.getString("urldelProfilo"));
                current.setDataNascita(res.getString("datadinascita"));
                current.setFrase(res.getString("frasedipresentazione"));
                current.setPassword(res.getString("password"));                

                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
  
    public int getIdByUserAndPassword(String user, String password){
       /* for(UtenteRegistrato utente : this.listaUtenti){
            if(utente.getNome().equals(user) && utente.getPassword().equals(password)){
                return utente.getId();
            }
        }
        return -1;*/
       
       try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "0000");
            
            String query = 
                      "select utente_id from Utente "
                    + "where name = ? and password = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, user);
            stmt.setString(2, password);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                int id = res.getInt("utente_id");

                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
        
    }
    
 
    
    
   public int login(String nome,String password) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "0000");
            
            String query = 
                      "SELECT utente_id FROM Utente "
                    + "WHERE nome = ? AND password = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, nome);
            stmt.setString(2, password);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            int loggedUser;
                
            // ciclo sulle righe restituite
            if (res.next()) {
                loggedUser = res.getInt("utente_id");
                
                stmt.close();
                conn.close();
                return loggedUser;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public List getFriendList(int id) {
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "0000");
            List<UtenteRegistrato> amici = new ArrayList<>();
            String query = 
                    "SELECT * FROM Utente " +
                    "JOIN Amicizie ON Utente.utente_id = Amicizie.idUtente1 " +
                    "WHERE Amicizie.idUtente2 = ? " +
                    "UNION " +
                    "SELECT * FROM Utente " +
                    "JOIN Amicizie ON Utente.utente_id = Amicizie.idUtente2 " +
                    "WHERE Amicizie.idUtente1 = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            stmt.setInt(2, id);
            
        
            ResultSet res;
            UtenteRegistrato current;
            res = stmt.executeQuery();
            
            // ciclo sulle righe restituite
            while (res.next()) {
                current = new UtenteRegistrato();
                current.setId(res.getInt("utente_id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                current.setUrlProfilo(res.getString("urldelprofilo"));
                current.setFrase(res.getString("frasedipresentazione"));
                current.setDataNascita(res.getString("datadinascita"));
                amici.add(current);
            }
            
            stmt.close();
            conn.close();
            return amici;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void aggiornamentoProfilo(UtenteRegistrato utente){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "0000");
            
            String query = 
                    "UPDATE Utente SET nome = ?, cognome = ?, email = ?, "
                    + "password = ?, frasedipresentazione = ?, urldelprofilo = ?, datadinascita = ? "
                    + "WHERE utente_id = ?";
            
           
            PreparedStatement stmt = conn.prepareStatement(query);
            
            
            stmt.setString(1, utente.getNome());
            stmt.setString(2, utente.getCognome());
            stmt.setString(3, utente.getEmail());
            stmt.setString(4, utente.getPassword());
            stmt.setString(5, utente.getFrase());
            stmt.setString(6, utente.getUrlProfilo());
            stmt.setString(7, utente.getDataNascita());
            stmt.setInt(8,utente.getId());
            // Esecuzione query
            stmt.execute();

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }    
    
    
     public void eliminaUtente(UtenteRegistrato utente) {
        try{
            Connection connessione = DriverManager.getConnection(connectionString, "utente", "0000");
            String query = "delete from UtentePerGruppo where utente = ? ";
            PreparedStatement frase = connessione.prepareStatement(query);
            frase.setInt(1, utente.getId());
            frase.executeUpdate();
            
            query = "delete from Utente where utente_id = ?";
            frase = connessione.prepareStatement(query);
            frase.setInt(1, utente.getId());
            frase.executeUpdate();
            
            frase.close();
            connessione.close();
        } 
        catch (SQLException e) {
            System.out.println("Errore SQL su eliminaListaPost");
            e.printStackTrace();
        }
    }
     
    public List getUsersList() {
        List<UtenteRegistrato> listaUtenti = new ArrayList<UtenteRegistrato>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "0000");
            
            String query = 
                      "select * from Utente";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                UtenteRegistrato current = new UtenteRegistrato();
                
                current.setId(res.getInt("utente_id"));
                current.setNome(res.getString("name"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                current.setUrlProfilo(res.getString("urldelprofilo"));
                current.setFrase(res.getString("frasedipresentazione"));
                current.setDataNascita(res.getString("datadinascita"));
                
                listaUtenti.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaUtenti;
    }
    
    
    
    public List getUsersList(String name) {
        List<UtenteRegistrato> listaGatti = new ArrayList<UtenteRegistrato>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "0000");
            
            String query = 
                      "select * from Utente where nome like ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, "%" + name + "%");
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                UtenteRegistrato current = new UtenteRegistrato();
                
                current.setId(res.getInt("utente_id"));
                current.setNome(res.getString("name"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                current.setUrlProfilo(res.getString("urldelprofilo"));
                current.setFrase(res.getString("frasedipresentazione"));
                current.setDataNascita(res.getString("datadinascita"));
                
                listaUtenti.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaUtenti;
    }
        
}
    
  
   

