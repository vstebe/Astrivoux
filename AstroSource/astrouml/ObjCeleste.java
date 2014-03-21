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

    /**
     * @attribute
     */
    private static Integer s_nextCode;

    public Galaxie getGalaxie() {
    }

    public abstract String getType();

    public static Collection s_getObjets(Galaxie g) {
    }

    public static ObjCeleste s_getObjet(Integer num) {
    }

    public ObjCeleste getCentre() {
    }

    public Integer nbDeSatellites() {
    }

    public Collection getSatellites() {
    }

    public Galaxie getGalaxie() {
    }

    public static Collection s_getObjets(Galaxie g) {
    }

    public static ObjCeleste s_getObjet(Integer num) {
    }

    public ObjCeleste getCentre() {
    }
}
