package astrouml;

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


    public abstract String getType();


    public Integer nbDeSatellites() {
        return 0;
    }

    public Collection getSatellites() {
        return null;
    }


    public abstract Galaxie getGalaxie();


    public ObjCeleste getCentre() {
        return null;
    }
}
