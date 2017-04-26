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
    protected UtentiRegistrati user;
    private String contenuto;
    private Type postType;
    
    public Post() {
        id = 0;
        user = null;
        contenuto = "";
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
    public void setUser(UtentiRegistrati user) {
        this.user = user;
    }

    /**
     * @return the user
     */
    public UtentiRegistrati getUser() {
        return user;
    }

  
    
    
    /**
     * @return the content
     */
    public String getContenuto() {
        return contenuto;
    }

    /**
     * @param contenuto the content to set
     */
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
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
    
    
}
