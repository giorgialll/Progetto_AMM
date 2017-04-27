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
        TEXT, IMAGE,LINK
    };
    
    protected int id;
    protected UtenteRegistrato user;
    private String contenuto_testo;
    private String contenuto_im;
    private String contenuto_link;
    
    private Type postType;
    
    public Post() {
        id = 0;
        user = null;
        contenuto_im = "";
        contenuto_testo="";
        contenuto_link="";
        postType = Type.TEXT;
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
     * @return the contenuto_im
     */
    public String getContenuto_im() {
        return contenuto_im;
    }

    /**
     * @param contenuto_im the contenuto_im to set
     */
    public void setContenuto_im(String contenuto_im) {
        this.contenuto_im = contenuto_im;
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
     * @return the contenuto_link
     */
    public String getContenuto_link() {
        return contenuto_link;
    }

    /**
     * @param contenuto_link the contenuto_link to set
     */
    public void setContenuto_link(String contenuto_link) {
        this.contenuto_link = contenuto_link;
    }

    
}
