package amm.nerdbook.classi;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author giorgia
 */
public class PostFactory {
    
    
    private static PostFactory singleton;
    private String connectionString ;
    //request.getParametrer("dataNascita");
    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

   // private ArrayList<Post> listaPost = new ArrayList<Post>();
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
            return this.connectionString;
    }
    private PostFactory() {
        /*
        UtenteRegistratoFactory utenteFactory = UtenteRegistratoFactory.getInstance();

        //Creazione del Post
        Post post1 = new Post();
        post1.setContenuto_testo("I computer sanno contare solo da 0 ad 1, il resto è professionalità.");
        post1.setTipo(Post.Type.NULL);
        post1.setId(1);
        post1.setUser(utenteFactory.getUtentiId(0));
        
     

        Post post2 = new Post();
        post2.setContenuto_testo("Oggi è il Pi greco Day, il giorno del numero forse più importante della scienza e della nostra vita quotidiana.\n" +"Ma ciò che è più importante per mio padre è il CIBO.");
        post2.setPostType(Post.Type.IMAGE);
        post2.setUrl("image/lisahomer.PNG");
        post2.setId(2);
        post2.setUser(utenteFactory.getUtentiId(1));
        

        Post post3 = new Post();
        post3.setContenuto_testo("Today happened to me a horrible thing. Look here!!!!!");
        post3.setTipo(Post.Type.LINK);
        post3.setUrl("https://www.youtube.com/watch?v=8QR-kJyZXBg");
        post3.setId(3);
        post3.setUser(utenteFactory.getUtentiId(2));
   
  

        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);*/
    
    }

    public Post getPostById(int id) {
        /*for (Post post : this.listaPost) {
            if (post.getId()== id) {
                return post;
            }
        }
        return null;*/
        
        UtenteRegistratoFactory utenteFactory = UtenteRegistratoFactory.getInstance();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "0000");
            
            String query = 
                      "select * from Post "
                    + "join tipourl on Post.tipo = TipoUrl.tipourl_id "
                    + "where post_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
           
                current.setContenuto_testo(res.getString("contenuto_testo"));
                
                //imposto il tipo del post
                current.setPostType(this.postTypeFromString(res.getString("tipo")));
               
                //imposto l'autore del post
                UtenteRegistrato autore =utenteFactory.getUtentiId(res.getInt("utente"));
                current.setUser(autore);

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

    public List getPostList(UtenteRegistrato user) {

      /*  List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUser().equals(user)) {
                listaPost.add(post);
            }
        }
        return listaPost;*/
        List<Post> listaPost = new ArrayList<Post>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "0000");
            
            String query = 
                      "select * from Post "
                    + "join posttype on Post.tipo = TipoUrl.tipourl_id "
                    + "where utente = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, user.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
                
                //impost il contenuto del post
                current.setContenuto_testo(res.getString("contenuto_testo"));
                
                //imposto il tipo del post
                current.setPostType(this.postTypeFromString(res.getString("tipo")));
                current.setContenuto_testo(res.getString("url"));
                current.setId(res.getInt("utente"));
                current.setId(res.getInt("gruppo"));

                //imposto l'autore del post
                current.setUser(user);
                
                listaPost.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;
    }
    
    public List getPostList(Gruppo group) {
        List<Post> listaPost = new ArrayList<Post>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "0000");
            
            String query = 
                      "SELECT Post*, tipourl.type FROM Post "
                    + "JOIN tipourl ON Post.tipo = tipourl.tipourl_id "
                    + "WHERE gruppo = ? "
                    + "ORDER BY Post.post_id DESC";
                    
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
           
            stmt.setInt(1, group.getId());
            
            // Esecuzione query
            ResultSet res;
            
            res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                 Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
                
                //impost il contenuto del post
                current.setContenuto_testo(res.getString("contenuto_testo"));
                
                //imposto il tipo del post
                current.setPostType(this.postTypeFromString(res.getString("tipo")));
                current.setContenuto_testo(res.getString("url"));
                current.setId(res.getInt("utente"));
                current.setId(res.getInt("gruppo"));
                
                listaPost.add(current);
            }
            
            stmt.close();
            conn.close();
            return listaPost;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
     private Post.Type postTypeFromString(String type){
        
        if(type.equals("IMAGE"))
            return Post.Type.IMAGE;
        if(type.equals("LINK"))
            return Post.Type.LINK;
        
        return Post.Type.NULL;
    }
     
     public void addNewPost(Post post){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "0000");
            
            String query = 
                      "insert into posts (post_id, contenuto_testo, tipo, utente) "
                    + "values (default, ? , ? , ? )";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
           
            stmt.setString(1, post.getContenuto_testo());

            stmt.setInt(2, this.postTypeFromEnum(post.getPostType()));
            
            stmt.setInt(3, post.getUser().getId());
            
         
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
     
    public void deletePost(Post post){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "0000");
            
            String query = 
                    "delete" + "from post" + "where post_id =? ";
            
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
           
            stmt.setInt(1, post.getId());          
         
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    private int postTypeFromEnum(Post.Type type){
     
        if(type == Post.Type.IMAGE){
            return 1;            
        }
                
        if(type == Post.Type.LINK){
               return 2;
            
        }         
        return 0;
    }
    
    public void deleteALlPost(UtenteRegistrato utente ){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "0000");
            
            String query = 
                    "delete" + "from post" + "where utente  =? ";
            
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
           
            stmt.setInt(1, utente.getId());          
         
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
