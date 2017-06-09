package amm.nerdbook.servlet;

import amm.nerdbook.classi.Post;
import amm.nerdbook.classi.PostFactory;
import amm.nerdbook.classi.Gruppo;
import amm.nerdbook.classi.GruppoFactory;
import amm.nerdbook.classi.UtenteRegistrato;
import amm.nerdbook.classi.UtenteRegistratoFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author giorgia
 */


public class Bacheca extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession sessione = request.getSession(false);
        
         if(sessione!=null && sessione.getAttribute("loggedIn")!=null && sessione.getAttribute("loggedIn").equals(true)){
            
             
            if(request.getParameter("thereIsPost")!=null)
            {
                
                
                String thereIsPost = request.getParameter("thereIsPost");
                String contenuto_testo = request.getParameter("textPost");
                String tipo = request.getParameter("postType");
                
                if(thereIsPost.equals("needConfirm")){
                    request.setAttribute("contenuto_testo", contenuto_testo);
                    request.setAttribute("tipoUrl", tipo);
                    request.setAttribute("newpost", "true");
                    request.getRequestDispatcher("M3/bacheca.jsp").forward(request, response);
                    return;
                }
                else{
                    
                    Post post = new Post();
                    post.setContenuto_testo(contenuto_testo);
                    if(tipo.equals("linkType"))
                        post.setPostType(Post.Type.LINK);
                    if(tipo.equals("imgType"))
                        post.setPostType(Post.Type.IMAGE);
                    else
                        post.setPostType(Post.Type.NULL);
                    
                    post.setUser(UtenteRegistratoFactory.getInstance().getUtentiId((Integer)sessione.getAttribute("loggedUserID")));
                    PostFactory.getInstance().addNewPost(post);
                    request.getRequestDispatcher("Bacheca").forward(request, response);
                }
            }
            else{
                request.getRequestDispatcher("M3/bacheca.jsp").forward(request, response);
                return;
            }
        }
        else{
            request.getRequestDispatcher("Login").forward(request, response);
        }
         
         
         
        if(sessione!=null && sessione.getAttribute("loggedIn")!=null && sessione.getAttribute("loggedIn").equals(true)){
           
           /* String paramUser = request.getParameter("user");
            int userID;
            
            if(paramUser != null){
                userID = Integer.parseInt(paramUser);
            } 
            else
            {
                userID = (Integer)sessione.getAttribute("loggedUserID");

            }

            UtenteRegistrato user = UtenteRegistratoFactory.getInstance().getUtentiId(userID);
            
            if(user != null){
                request.setAttribute("user", user);
                
                List<Post> posts = PostFactory.getInstance().getPostList(user);
                request.setAttribute("posts", posts);

                List<UtenteRegistrato> listaUtenti = UtenteRegistratoFactory.getInstance().getUsersList();
                request.setAttribute("listaUtenti",listaUtenti);
                
                request.getRequestDispatcher("M3/bacheca.jsp").forward(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }*/
         int id_utente_log = (Integer)sessione.getAttribute("id_utente_log");
            
            List<Post> posts; //Lista dei post
            UtenteRegistrato utente_log = UtenteRegistratoFactory.getInstance().getUtentiId(id_utente_log);
 
            String paramUser = request.getParameter("user");
            String paramGroup = request.getParameter("group");
            
            int id_utente = -1;
            int id_gruppo = -1;
            
            
            if(paramGroup != null)
                id_gruppo = Integer.parseInt(paramGroup);
          
            else{
                
                if(paramUser != null)
                    id_utente = Integer.parseInt(paramUser);
                
                
                else
                    id_utente = id_utente_log;
            }

            UtenteRegistrato user = UtenteRegistratoFactory.getInstance().getUtentiId(id_utente);
            Gruppo gruppo = GruppoFactory.getInstance().getGruppoById(id_gruppo);
            
            if(gruppo != null ){ 
                
                posts = PostFactory.getInstance().getPostList(gruppo);
                request.setAttribute("gruppo", gruppo);
                request.setAttribute("bachecaOgruppo","gruppo");
                request.setAttribute("namegr",gruppo.getNome());
            }
            else{
             
                if(user == null) 
                    user = utente_log;
                
                
                posts = PostFactory.getInstance().getPostList(user);
                request.setAttribute("user", user);
                request.setAttribute("bachecaOgruppo","user");
                request.setAttribute("namegr",user.getNome());
            }

            request.setAttribute("posts", posts);
            List<UtenteRegistrato> amici = UtenteRegistratoFactory.getInstance().getFriendList(id_utente_log);
            request.setAttribute("friends", amici);
            List<Gruppo> gruppi = GruppoFactory.getInstance().getListaGruppiperutente(id_utente_log);
            request.setAttribute("groups", gruppi);
            request.getRequestDispatcher("bacheca.jsp").forward(request, response);
        }
        else{
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Accesso Negato</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Errore: Accesso Negato</h1>");
            out.println("</body>");
            out.println("</html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

