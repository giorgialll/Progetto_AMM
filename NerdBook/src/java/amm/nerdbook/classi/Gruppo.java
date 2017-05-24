/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giorgia
 */
public class Gruppo {

   
    
    private List<UtenteRegistrato> users_gruppo ;
    private int id;
    private String nome;
    private String descrizione;
    private UtenteRegistrato amministratore;
    
    public Gruppo(){   
        nome="";
        id=0;
        users_gruppo= new ArrayList<>();       
       
    }
    
     /**
     * @return utenti del gruppo
     */
    public List<UtenteRegistrato> getUsersGruppo(){
        return users_gruppo;
    }
    
    /**
     * 
     * @param users_gruppo  utenti gruppo
     */
    public void setUsersGruppo (List<UtenteRegistrato> users_gruppo) {
	if (users_gruppo.size()!=0) {
                this.users_gruppo = users_gruppo;
        }
    }
    
    public void addUtente(UtenteRegistrato utente){
        this.users_gruppo.add(utente);
    }
    
     /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
     /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
     /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
     /**
     * @return the amministratore
     */
    public UtenteRegistrato getAmministratore() {
        return amministratore;
    }

    /**
     * @param amministratore the amministratore to set
     */
    public void setAmministratore(UtenteRegistrato amministratore) {
        this.amministratore = amministratore;
    }
}
