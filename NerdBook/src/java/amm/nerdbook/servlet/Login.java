package amm.nerdbook.servlet;

import amm.nerdbook.classi.GruppoFactory;
import amm.nerdbook.classi.Post;
import amm.nerdbook.classi.PostFactory;
import amm.nerdbook.classi.UtenteRegistrato;
import amm.nerdbook.classi.UtenteRegistratoFactory;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(loadOnStartup = 0)

public class Login extends HttpServlet {
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";

    
    
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Apertura della sessione
 
        HttpSession session = request.getSession();
        
        //Se è impostato il parametro GET logout, distrugge la sessione
 
        if(request.getParameter("logout")!=null)
        {
            session.invalidate();
            request.getRequestDispatcher("M3/login.jsp").forward(request, response);
            return;
        }
        
        //Se esiste un attributo di sessione loggedIn e questo vale true
        //(Utente già loggato)
       
    
        
        if (session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) {

            request.getRequestDispatcher("Bacheca").forward(request, response); 
            return; 
        
       
        } 
        else 
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
        
            
         
            if (username != null && password != null){
                int loggedUserID = UtenteRegistratoFactory.getInstance().getIdByUserAndPassword(username, password); 
          
                          
                //se l'utente è valido...
                /*controlo sull'id ottenuto */
                if(loggedUserID!=-1)
                {
                    session.setAttribute("loggedIn", true); 
                    session.setAttribute("loggedUserID", loggedUserID); 
            
                    request.getRequestDispatcher("Bacheca").forward(request, response);  
           
                    return;
                }
                else{
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("M3/login.jsp").forward(request, response);
                    return;
                }
                 
                
                
            }
            request.getRequestDispatcher("M3/login.jsp").forward(request, response);
        }        
    }
    
    @Override
    public void init(){
       String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
       try {
           Class.forName(JDBC_DRIVER);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       }
       UtenteRegistratoFactory.getInstance().setConnectionString(dbConnection);
       GruppoFactory.getInstance().setConnectionString(dbConnection);
       PostFactory.getInstance().setConnectionString(dbConnection);
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