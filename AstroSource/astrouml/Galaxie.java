package astrouml;

import java.util.*;

import java.util.Collection;

public class Galaxie {
    /**
     * @associates <{astrouml.Etoile}>
     */
    ArrayList<Etoile> etoiles = new ArrayList<Etoile>();
    

    String nom;
    /**
     * @attribute
     */

    /**
     * @attribute
     */
    private String type;

    /**
     * @attribute
     */
    private Integer eloignement;
    
    public Galaxie(String nom, String type, int eloignement) {
        this.nom = nom;
        this.type = type;
        this.eloignement = eloignement;
    }


    public ArrayList<Etoile> listeEtoiles() {
        return etoiles;
    }

    public int nbEtoiles() {
        return etoiles.size();
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void addEtoile(Etoile e) {
        etoiles.add(e);
    }

    
        
}
