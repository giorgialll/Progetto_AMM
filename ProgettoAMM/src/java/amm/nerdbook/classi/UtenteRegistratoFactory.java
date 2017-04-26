
package amm.nerdbook.classi;
import java.util.ArrayList;

/**
 *
 * @author giorgia
 */
public class UtenteRegistratoFactory {
   
    private static UtenteRegistratoFactory singleton;

    public static UtenteRegistratoFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteRegistratoFactory();
        }
        return singleton;
    }

    private ArrayList<UtenteRegistrato> listaUtenti = new ArrayList<UtenteRegistrato>();

    private UtenteRegistratoFactory() {
        //Creazione utenti

        //Bob Dog
        UtenteRegistrato utente1 = new UtenteRegistrato();
        utente1.setId(0);
        utente1.setNome("Bob");
        utente1.setCognome("Dog");
        utente1.setDataNascita("26 Giugno 1993");
        utente1.setFrase("Amo corrrere nei prati");
        utente1.setEmail("bobdog@hotmail.it");
        utente1.setPassword("254866");
        utente1.setUrlProfilo("image/dog.PNG");

        //Lisa Simpson
        UtenteRegistrato utente2 = new UtenteRegistrato();
        utente2.setId(1);
        utente2.setNome("Lisa");
        utente2.setCognome("Simpson");
        utente2.setDataNascita("14 Genaio 1990");
        utente2.setFrase("Il giallo è il mio colore preferito");
        utente2.setEmail("simpson.lisa@hotmail.it");
        utente2.setPassword("982547456");
        utente2.setUrlProfilo("image/profiloLisa.PNG");
        
        
        //Dexter
        
        UtenteRegistrato utente3 = new UtenteRegistrato();
        utente3.setId(2);
        utente3.setNome("Dexter");
        utente3.setDataNascita("31 Dicembre 1995");
        utente3.setFrase("Il mio laboratorio è unico");
        utente3.setEmail("dexter@hotmail.it");
        utente3.setPassword("58464dc4x5");
        utente3.setUrlProfilo("image/Dexter.jpg");
        
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        
       
    }

    public UtenteRegistrato getUtentiId(int id) {
        for (UtenteRegistrato utente : this.listaUtenti) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }
    
   
}
