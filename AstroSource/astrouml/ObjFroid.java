package astrouml;

import java.util.Collection;

public class ObjFroid extends ObjCeleste {
    /**
     * @attribute
     */
    private String type;
    

    /**
     * @attribute
     */
    private Integer rayon;

    /**
     * @attribute
     */
    private Integer periode;

    /**
     * @attribute
     */
    private Integer diametre;

    /**
     */
    ObjCeleste centre;
    
    public ObjFroid(int code, String nom, String type, int rayon, int diametre, int periode, ObjCeleste centre) {
        super(code, nom);
        this.rayon = rayon;
        this.diametre = diametre;
        this.periode = periode;
        this.centre = centre;
        this.type = type;
    }
    
    public Galaxie getGalaxie() {
        return centre.getGalaxie();
    }


    public String getType() {
        return this.type;
    }
    
    public ObjCeleste getCentre() {
        return centre;
    }
    
    @Override
    public String toString() {
        String str = super.toString();
        str += "; gravite autour de " + getCentre().getNom() + " à " + this.diametre+" mkm; " + getSatellites().size() + " satellites";
        return str;
    }
   
}
