/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giorgia
 */
public class GruppoFactory {
    
    private static GruppoFactory singleton;

    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }

    private ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();

    private GruppoFactory() {
        
        GruppoFactory gruppoFactory = GruppoFactory.getInstance();
        
        UtenteRegistratoFactory utenteregistratoFactory =UtenteRegistratoFactory.getInstance();
        
        UtenteRegistrato utente0 = utenteregistratoFactory.getUtentiId(0);
        UtenteRegistrato utente1 = utenteregistratoFactory.getUtentiId(1);
        UtenteRegistrato utente2 = utenteregistratoFactory.getUtentiId(2);
        
        //Creazione dei gruppi
        Gruppo gruppo1 = new Gruppo();
        gruppo1.setId(1);
        gruppo1.setNome("Nerd for nerd");
        gruppo1.setDescrizione("Solo per i nerd");
        gruppo1.addUtente(utente0);
        gruppo1.addUtente(utente1);
        
        Gruppo gruppo2 = new Gruppo();
        gruppo2.setId(2);
        gruppo2.setNome("Travel");
        gruppo2.setDescrizione("Adatto a chi ama viaggiare e conoscere nuove culture");
        gruppo2.addUtente(utente0);
        gruppo2.addUtente(utente1);
        gruppo2.addUtente(utente2);
        
        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
        

       
    }

  
     public Gruppo getUtenteByName(int nomeGruppo)
    {
        for (Gruppo gruppo : this.listaGruppi) 
        {
            if (gruppo.getNome().equals(nomeGruppo));
                return gruppo;
        }
        return null;
    }
}
