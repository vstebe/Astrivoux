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


    public abstract String getType();


    public Integer nbDeSatellites() {
    }

    public Collection getSatellites() {
    }


    public Galaxie getGalaxie() {
    }


    public ObjCeleste getCentre() {
    }
}
