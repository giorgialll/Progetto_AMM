package amm.nerdbook.classi;

/**
 *
 * @author giorgia
 */
public class UtenteRegistrato {
    
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String urlProfilo;
    private String datanascita;
    private String frase;
    private String password;
    
    
     public UtenteRegistrato() {
        id = 0;
        nome = "";
        cognome = "";
        email = "";
        password = "";
        frase="";
        datanascita="";
        urlProfilo="";
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
    
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome il cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
   

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
     /**
     * @return la data di nascita
     */
    public String getDataNascita() {
        return password;
    }

    /**
     * @param datanascita data di nascuta
     */
    public void setDataNascita(String datanascita) {
        this.datanascita = datanascita;
    }
    
     /**
     * @return la frase di presetazione
     */
    public String getFrase() {
        return password;
    }

    /**
     * @param frase frase di presentazione
     */
    public void setFrase(String frase) {
        this.frase = frase;
    }
    
    /**
     * @return the urlProfilo
     */
    public String getUrlProfilo() {
        return urlProfilo;
    }
    
    /**
     * @param urlProfilo url del profilo
     */
    public void setUrlProfilo(String urlProfilo){
        this.urlProfilo = urlProfilo;
    }

    @Override
    public boolean equals(Object altroUtente) {
        if (altroUtente instanceof UtenteRegistrato)
            if (this.getId() == ((UtenteRegistrato)altroUtente).getId()) return true;
        return false;
    }

    

    
}
