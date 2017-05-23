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
public class Post { 
  
    public enum Type {
        NULL,IMAGE,LINK
    };
    
    protected int id;
    protected UtenteRegistrato user;
    private String contenuto_testo;
    private String url;
    private Type tipo;
    
    private Type postType;
    
    public Post() {
        id = 0;
        user = null;
        url = "";
        contenuto_testo="";
        tipo = Type.NULL;
      
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
     * @param user the user to set
     */
    public void setUser(UtenteRegistrato user) {
        this.user = user;
    }

    /**
     * @return the user
     */
    public UtenteRegistrato getUser() {
        return user;
    }

    /**
     * @return the postType
     */
    public Type getPostType() {
        return postType;
    }

    /**
     * @param postType the postType to set
     */
    public void setPostType(Type postType) {
        this.postType = postType;
    }
    
        
    /**
     * @return the contenuto_testo
     */
    public String getContenuto_testo() {
        return contenuto_testo;
    }

    /**
     * @param contenuto_testo the contenuto_testo to set
     */
    public void setContenuto_testo(String contenuto_testo) {
        this.contenuto_testo = contenuto_testo;
    }

       /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
      /**
     * @return the tipo
     */
    public Type getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }


}
