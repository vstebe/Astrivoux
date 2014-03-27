package astrouml;

import java.util.ArrayList;
import java.util.Collection;

public abstract class ObjCeleste {
    /**
     * @attribute
     */
    private Integer code;

    /**
     * @attribute
     */
    private String nom;
    
    private ArrayList<ObjCeleste> satellites = new ArrayList<ObjCeleste>();
    
    public ObjCeleste(int code, String nom) {
        this.code = code;
        this.nom = nom;
    }
    
    
    /**
     *Renvoie tous les objets céleste gravitant autour (ses satellites et les satellites de ses satellites)
     * Est récursif
     * @return
     */
    public ArrayList<ObjCeleste> getObjets() {
        ArrayList<ObjCeleste> res = new ArrayList<ObjCeleste>();
        for(ObjCeleste satellite : satellites) {
            res.add(satellite);
            res.addAll(satellite.getObjets());
        }
        return res;
    }

    public abstract String getType();


    /**
     *Renvoie le nombre de satellites de l'objet
     * @return
     */
    public Integer nbDeSatellites() {
        return satellites.size();
    }
    
    /**
     * Renvoie les satellites de l'objet
     * @return
     */
    public ArrayList<ObjCeleste> getSatellites() {
        return satellites;
    }
    
    public void addSatellite(ObjFroid obj) {
        satellites.add(obj);
    }

    public String getNom() {
        return this.nom;
    }
    
    public int getCode() {
        return code;
    }

    /**
     *Renvoie la galaxie de l'objet
     * Abstrait car pour une étoile, on la connait directement, pour les objets froid cela dépend de l'étoile
     * @return
     */
    public abstract Galaxie getGalaxie();


    @Override
    public String toString() {
        return this.nom + " : " + getType() + " ; galaxie : " + getGalaxie().getNom();
    }
}
