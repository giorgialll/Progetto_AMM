package amm.nerdbook.classi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giorgia
 */
public class PostFactory {
    
    
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private ArrayList<Post> listaPost = new ArrayList<Post>();

    private PostFactory() {
        
        UtenteRegistratoFactory utenteFactory = UtenteRegistratoFactory.getInstance();

        //Creazione del Post
        Post post1 = new Post();
        post1.setContenuto_testo("I computer sanno contare solo da 0 ad 1, il resto è professionalità.");
        post1.setId(1);
        post1.setUser(utenteFactory.getUtentiId(0));
     

        Post post2 = new Post();
        post2.setContenuto_testo("Oggi è il Pi greco Day, il giorno del numero forse più importante della scienza e della nostra vita quotidiana.\n" +"Ma ciò che è più importante per mio padre è il CIBO.");
        post2.setContenuto_im("image/lisahomer.PNG");
        post2.setId(2);
        post2.setUser(utenteFactory.getUtentiId(0));
        post2.setPostType(Post.Type.TEXT);
        post2.setPostType(Post.Type.IMAGE);

        Post post3 = new Post();
        post3.setContenuto_testo("Today happened to me a horrible thing. Look here!!!!!");
        post3.setContenuto_link("https://www.youtube.com/watch?v=8QR-kJyZXBg");
        post3.setId(3);
        post3.setUser(utenteFactory.getUtentiId(0));
        post3.setPostType(Post.Type.LINK);
  

        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
    
    }

    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId()== id) {
                return post;
            }
        }
        return null;
    }

    public List getPostList(UtenteRegistrato user) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUser().equals(user)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
}
