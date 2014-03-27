package astrouml;

import java.util.ArrayList;
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
    
    /**
     *Constructeur
     * @param code
     * @param nom
     * @param magnitude
     * @param ageLettre
     * @param galaxie
     */
    public Etoile(int code, String nom, int magnitude, String ageLettre, Galaxie galaxie) {
        super(code, nom);
        this.magnitude = magnitude;
        this.ageLettre = ageLettre;
        this.galaxie = galaxie;
    }
    
    /**
     *Renvoie la galaxie de l'étoile
     * @return
     */
    public Galaxie getGalaxie() {
        return this.galaxie;
    }
    

    
    @Override
    public String getType() {
        return "Etoile";
    }
    
    @Override
    public String toString() {
        return super.toString() + "; age : " + this.ageLettre + " ; " + this.getSatellites().size() + " satellites";
    }


}
