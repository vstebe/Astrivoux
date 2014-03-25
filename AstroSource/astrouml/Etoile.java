package astrouml;

import java.util.Collection;

public class Etoile extends ObjCeleste {
    /**
     * @attribute
     */
    private Integer magnitude;

    /**
     * @attribute
     */
    private String ageLettre;

    /**
     */
    Galaxie galaxie;
    
    public Etoile(int code, String nom, int magnitude, String ageLettre, Galaxie galaxie) {
        super(code, nom);
        this.magnitude = magnitude;
        this.ageLettre = ageLettre;
        this.galaxie = galaxie;
    }
    
    public Galaxie getGalaxie() {
        return this.galaxie;
    }
    
    
    public String getType() {
        return "Etoile";
    }
    
    @Override
    public String toString() {
        return super.toString() + "; age : " + this.ageLettre + " ; " + this.getSatellites().size() + " satellites";
    }


}
