package astrouml;

import java.util.ArrayList;

public class Univers {
    /**
     * @associates <{astrouml.Galaxie}>
     */
    private ArrayList<Galaxie> galaxies = new ArrayList<Galaxie>();
    
    private Etoile soleil;
    
    private int nextCode = 0;
    
    private Galaxie voieLactee;
    
    public Univers(Etoile soleil, Galaxie voieLactee) {
        this.soleil = soleil;
        this.voieLactee = voieLactee;
    }
    
    private ArrayList<ObjCeleste> obj = new ArrayList<ObjCeleste>();

    public ArrayList<Galaxie> getAllGalaxies() {
        return galaxies;
    } 
    
    public Galaxie getGalaxie(String nom) {
        for(Galaxie g : galaxies) {
            if(g.getNom().equals(nom))
                return g;
        }
        return null;
    }
    
    public ArrayList<ObjCeleste> getObjets(Galaxie g) {
        ArrayList<ObjCeleste> res= new ArrayList<ObjCeleste>();
        for(ObjCeleste o : obj) {
            if(o.getGalaxie() == g)
            res.add(o);
        }
        return res;
    }

    public Galaxie creerGalaxie(String nom, String type, int eloignement) {
        Galaxie g = new Galaxie(nom, type, eloignement);
        galaxies.add(g);
        return g;
    }
    
    public ObjFroid creerObjetFroid(String nom, int rayonOrbite, int diametre, int periode, ObjCeleste centreOrbite) {
        String type;
        if(centreOrbite == soleil && diametre >= 6000)
            type = "Planète";
        else if(centreOrbite == soleil)
            type = "Planète naine";
        else if(centreOrbite.getType().equals("Etoile"))
            type = "ExoPlanète";
        else
            type = "Lune";
        ObjFroid obj = new ObjFroid(nextCode, nom,type, rayonOrbite, diametre, periode, centreOrbite);
        centreOrbite.addSatellite(obj);
        nextCode++;
        return obj;
    }
    
    public Etoile creerEtoile(String nom, int magnitude, String age, Galaxie galaxie) {
        Etoile etoile = new Etoile(nextCode, nom, magnitude, age, galaxie);
        nextCode++;
        return etoile;
    }
    
    public ObjCeleste getObjet(int code) {
        for(ObjCeleste o : obj) {
            if(o.getCode() == code)
                return o;
        }
        return null;
    }
}
