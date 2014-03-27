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
    
    
    /**
     *Constructeur
     * @param nom
     * @param type
     * @param eloignement
     */
    public Galaxie(String nom, String type, int eloignement) {
        this.nom = nom;
        this.type = type;
        this.eloignement = eloignement;
    }

/**
     *Liste toutes les étoiles de la galaxie
     * @return
     */
    public ArrayList<Etoile> listeEtoiles() {
        return etoiles;
    }

    /**
     *Renvoie le nombre d'étoiles
     * @return
     */
    public int nbEtoiles() {
        return etoiles.size();
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void addEtoile(Etoile e) {
        etoiles.add(e);
    }
    
    /**
     *Renvoie la liste de tous les objets célestes de la galaxie
     * @return
     */
    public ArrayList<ObjCeleste> getObjets(){
        ArrayList<ObjCeleste> res = new ArrayList<ObjCeleste>();
        for(Etoile etoile : etoiles) {
            res.add(etoile);
            res.addAll(etoile.getObjets());
        }
        return res;
    }
    
    @Override
    public String toString() {
        return getNom() + " (type = " + type + " ; eloignement : " + this.eloignement + ")";
    }

    
        
}
