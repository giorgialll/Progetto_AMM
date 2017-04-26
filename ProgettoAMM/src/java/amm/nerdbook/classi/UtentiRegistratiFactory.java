
package amm.nerdbook.classi;
import java.util.ArrayList;

/**
 *
 * @author giorgia
 */
public class UtentiRegistratiFactory {
   
    private static UtentiRegistratiFactory singleton;

    public static UtentiRegistratiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiRegistratiFactory();
        }
        return singleton;
    }

    private ArrayList<UtentiRegistrati> listaUtenti = new ArrayList<UtentiRegistrati>();

    private UtentiRegistratiFactory() {
        //Creazione utenti

        //Bob Dog
        UtentiRegistrati utente1 = new UtentiRegistrati();
        utente1.setId(0);
        utente1.setNome("Bob");
        utente1.setCognome("Dog");
        utente1.setDataNascita("26 Giugno 1993");
        utente1.setFrase("Amo corrrere nei prati");
        utente1.setEmail("bobdog@hotmail.it");
        utente1.setPassword("254866");
        utente1.setUrlProfilo("image/dog.PNG");

        //Lisa Simpson
        UtentiRegistrati utente2 = new UtentiRegistrati();
        utente2.setId(0);
        utente2.setNome("Lisa");
        utente2.setCognome("Simpson");
        utente2.setDataNascita("14 Genaio 1990");
        utente2.setFrase("Il giallo è il mio colore preferito");
        utente2.setEmail("simpson.lisa@hotmail.it");
        utente2.setPassword("982547456");
        utente2.setUrlProfilo("image/profiloLisa.PNG");
        
        
        //Dexter
        
        UtentiRegistrati utente3 = new UtentiRegistrati();
        utente3.setId(0);
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

    public UtentiRegistrati getUtentiId(int id) {
        for (UtentiRegistrati utente : this.listaUtenti) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }
    
   
}
