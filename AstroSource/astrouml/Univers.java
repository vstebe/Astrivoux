package astrouml;

import java.util.ArrayList;

public class Univers {
    /**
     * @associates <{astrouml.Galaxie}>
     */
    private ArrayList galaxies;
    
    private Etoile soleil;
    
    private Galaxie galaxy;
    
    private ArrayList<ObjCeleste> obj = new ArrayList<ObjCeleste>();

    public ArrayList<Galaxie> getAllGalaxies() {
        return null;
    } 
    
    public Galaxie getGalaxie(String nom) {
        return null;
    }

    public Galaxie creerGalaxie(String nom, String type, int eloignement) {
        return null;
    }
    
    public ObjFroid creerObjetFroid(String nom, int rayonOrbite, int diametre, int periode, ObjFroid centreOrbite) {
        return null;
    }
    
    public Etoile creerEtoile(String nom, int magnitude, char age, Galaxie galaxie) {
        return null;
    }
    
    public ObjCeleste getObjet(int code) {
        for(ObjCeleste o : obj) {
            if(o.getCode() == code)
                return o;
        }
        return null;
    }
}
