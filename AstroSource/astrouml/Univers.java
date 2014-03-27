package astrouml;

import java.util.ArrayList;

public class Univers {
    /**
     * @associates <{astrouml.Galaxie}>
     */
    private ArrayList<Galaxie> _galaxies = new ArrayList<Galaxie>();
    
    private Etoile _soleil;
    
    private static int _diametrePlanete =  6000;
    
    private int _nextCode = 1;
    
    private Galaxie _voieLactee;
    
    /**
     * Créé un univers en initialisant les valeurs de la voie lactée et du soleil.
     * @param nom nom de la galaxie principale (voie lactée)
     * @param type son type
     * @param eloignement son éloignement
     * @param nomSoleil le nom du soleil
     * @param magnitude sa magnitude
     * @param age son age
     */
    public Univers(String nom, String type, int eloignement, String nomSoleil, int magnitude, String age) {
        this._voieLactee = creerGalaxie(nom, type, eloignement);
        this._soleil = creerEtoile(nomSoleil, magnitude, age, this._voieLactee);
        _nextCode=2;
    }
    

    /**
     * Renvoie la liste de toutes les galaxies
     * @return
     */
    public ArrayList<Galaxie> getAllGalaxies() {
        return _galaxies;
    } 
    
    /**
     * Renvoie la galaxie du nom "nom" ou null si non trouvé
     * @param nom
     * @return 
     */
    public Galaxie getGalaxie(String nom) {
        for(Galaxie g : _galaxies) {
            if(g.getNom().equals(nom))
                return g;
        }
        return null;
    }
    
    /**
     * Renvoie la liste de tous les objets de la galaxie d'entrée
     * @param g
     * @return
     */
    public ArrayList<ObjCeleste> getObjets(Galaxie g) {
        if(g == null)
            throw new IllegalArgumentException("Galaxie incorrecte (null)");
        return g.getObjets();
    }

    /**
     * Créé une nouvelle galaxie et en renvoie une référence
     * @param nom
     * @param type
     * @param eloignement
     * @return
     */
    public Galaxie creerGalaxie(String nom, String type, int eloignement) {
        Galaxie g = new Galaxie(nom, type, eloignement);
        _galaxies.add(g);
        return g;
    }
    
    /**
     * Créé un nouvel objet froid, et détermine son type, et en renvoie une référence
     * @param nom
     * @param rayonOrbite
     * @param diametre
     * @param periode
     * @param centreOrbite
     * @return
     */
    public ObjFroid creerObjetFroid(String nom, int rayonOrbite, int diametre, int periode, ObjCeleste centreOrbite) {
        String type;
        if(centreOrbite == _soleil && diametre >= _diametrePlanete)
            type = "Planète";
        else if(centreOrbite == _soleil)
            type = "Planète naine";
        else if(centreOrbite.getType().equals("Etoile"))
            type = "ExoPlanète";
        else
            type = "Lune";
        ObjFroid obj = new ObjFroid(_nextCode, nom,type, rayonOrbite, diametre, periode, centreOrbite);
        centreOrbite.addSatellite(obj);
        _nextCode++;
        return obj;
    }
    
    /**
     * Créé une nouvelle étoile et l'ajoute à sa galaxie
     * @param nom
     * @param magnitude
     * @param age
     * @param galaxie
     * @return
     */
    public Etoile creerEtoile(String nom, int magnitude, String age, Galaxie galaxie) {
        Etoile etoile = new Etoile(_nextCode, nom, magnitude, age, galaxie);
        _nextCode++;
        galaxie.addEtoile(etoile);
        return etoile;
    }
    
    /**
     * Renvoie la liste de tous les objets celestes de l'univers
     * @return
     */
    public ArrayList<ObjCeleste> getObjets() {
        ArrayList<ObjCeleste> res = new ArrayList<ObjCeleste>();
        for(Galaxie g : this._galaxies) {
            res.addAll(g.getObjets());
        }
        return res;
    }
    
    /**
     * Renvoie l'objet ayant le code en entrée ou null si non trouvé
     * @param code
     * @return
     */
    public ObjCeleste getObjet(int code) {
        ArrayList<ObjCeleste> objets = getObjets();
        for(ObjCeleste o : objets) {
            if(o.getCode() == code)
                return o;
        }
        return null;
    }
    
    /**
     *Renvoie l'objet dont le nom est en paramètre ou null si non trouvé
     * @param nom
     * @return
     */
    public ObjCeleste getObjet (String nom) {   //ajout�e en plus
       ArrayList<ObjCeleste> objets = getObjets();
       for(ObjCeleste o : objets) {
            if(o.getNom().equals(nom))
                return o;
        }
        return null;
    }
    
    /**
     *Renvoie la référence du soleil
     * @return
     */
    public Etoile getSoleil() {
        return this._soleil;
    }
    
    /**
     *Renvoie la référence de la voie lactée
     * @return
     */
    public Galaxie getVoieLactee() {
        return this._voieLactee;
    }
}
