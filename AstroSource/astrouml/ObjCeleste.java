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
    
    public ObjCeleste(int code, String nom) {
        this.code = code;
        this.nom = nom;
    }
    
    private ArrayList<ObjCeleste> satellites = new ArrayList<ObjCeleste>();


    public abstract String getType();


    public Integer nbDeSatellites() {
        return satellites.size();
    }

    public Collection getSatellites() {
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

    public abstract Galaxie getGalaxie();


    @Override
    public String toString() {
        return this.nom + " : " + getType() + " ; galaxie : " + getGalaxie().getNom();
    }
}
