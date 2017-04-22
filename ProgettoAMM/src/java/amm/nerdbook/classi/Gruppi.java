/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

/**
 *
 * @author giorgia
 */
public class Gruppi {
    
    private UtentiRegistrati[] users_gruppo ;
    private int id;
    private String nome;
    
    
    public Gruppi(){
        
        nome="";
        id=0;
        users_gruppo= new UtentiRegistrati[30];        
    }
    
     /**
     * @return utenti del gruppo
     */
    public UtentiRegistrati[] getUsersGruppo(){
        return users_gruppo;
    }
    
    /**
     * 
     * @param users_gruppo  utenti gruppo
     */
    public void setUsersGruppo (UtentiRegistrati[] users_gruppo) {
	if (users_gruppo.length!=0) {
                this.users_gruppo = users_gruppo;
        }
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
    
    
    
}
