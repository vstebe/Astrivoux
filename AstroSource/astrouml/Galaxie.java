package astrouml;

import java.util.*;

import java.util.Collection;

public class Galaxie {
    /**
     * @associates <{astrouml.Etoile}>
     */
    Collection etoiles;

    /**
     * @attribute
     */
    private String nom;

    /**
     * @attribute
     */
    private String type;

    /**
     * @attribute
     */
    private Integer eloignement;
    
    public Galaxie(String nom, String type) {
        this.nom = nom;
        this.type = type;
    }


    public ArrayList<Etoile> listeEtoiles() {
        return null;
    }

    public static int nbEtoiles() {
        return 0;
    }
    
        
}
