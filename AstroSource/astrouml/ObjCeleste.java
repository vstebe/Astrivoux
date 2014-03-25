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
        return 0;
    }

    public Collection getSatellites() {
        return null;
    }

    public String getNom() {
        return this.nom;
    }
    
    public int getCode() {
        return code;
    }

    public abstract Galaxie getGalaxie();


    public ObjCeleste getCentre() {
        return null;
    }
    
    @Override
    public String toString() {
        return this.nom + " : " + getType() + " ; galaxie : " + getGalaxie().getNom();
    }
}
