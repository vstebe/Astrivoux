package MainPack;

import astrouml.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int commande, num;
        Scanner sc = new Scanner(System.in);
        Boolean quitter = false;
        Galaxie voieLactee = new Galaxie("Voie Lactée", "spirale", 0);
        Etoile soleil = new Etoile(1, "Soleil",0, "F", voieLactee );
        Univers univ = new Univers(soleil, voieLactee);
        ArrayList<ObjCeleste> tabObj;
        ArrayList<Galaxie> tabGala;
        ObjCeleste obj;
        
        while (!quitter) {
            System.out.println("\n\n**********   Menu   **********\n");
            System.out.println("0. Initialiser le système avec le jeu d'essai.");
            System.out.println("1. Afficher les caractéristiques de l'Objet N° x.");
            System.out.println("2. Lister toutes les galaxies : nom, type, éloignement.");
            System.out.println("3. Lister tous les objets connus de la galaxie de nom \"X\" avec leurs caractéristiques.");
            System.out.println("4. Lister les satellites de l'objet (étoile, planète,...) N° X.");
            System.out.println("5. Afficher le nombre total d'étoiles répertoriées dans l'univers.");
            System.out.println("6. Afficher les caractéristiques du plus gros objet froid.");
            System.out.println("7. Ajouter une nouvelle étoile.");
            System.out.println("8. Ajouter un nouvel objet froid (à une étoile ou à un objet froid).");
            System.out.println("9. Ajouter une galaxie (nom, type, eloign).");
            System.out.println("10 Quitter.");
            
            commande = sc.nextInt();
            
            
            
            switch (commande)
            {
                case 0:     //jeu d'essai
                        jeuDessai();
                    break;
            
            
                case 1:
                System.out.println("Quelle objet voulez-vous afficher ?");
                num = sc.nextInt();
                System.out.println("Affichage de l'objet N°"+num+" :");
                obj = univ.getObjet(num);
                System.out.println(obj.toString());
                    break;   
            
            
                case 2:
                tabGala =  univ.getAllGalaxies();
                System.out.println("\n\nAffichage de toutes les galaxies :\n");
                for (Galaxie g : tabGala)
                {
                    System.out.println(g.toString());
                }
                    break;   
            
                case 3:
                System.out.println("De quelle galaxie voulez-vous affichez les objets ?");
                String nomGala = sc.nextLine();
                Galaxie gala = univ.getGalaxie(nomGala);
                tabObj = univ.getObjets(gala);
                System.out.println("Affichage des objets de "+nomGala+" :");
                for (ObjCeleste o : tabObj) {
                    System.out.toString();
                }
                    break;   
            
                case 4:
                System.out.println("De quel objet voulez-vous lister les satellites ?");
                num = sc.nextInt();
                obj = univ.getObjet(num);
                ArrayList<ObjCeleste> tabSatel = obj.getSatellites();
                System.out.println("Les satellites de l'objet N°"+num+" sont les suivants :");
                    for(ObjCeleste o : tabSatel) {
                        System.out.println(o.toString());
                    }
                    break;   
            
                case 5:
                tabGala = univ.getAllGalaxies();
                int nbEtoiles =0;
                for (Galaxie g : tabGala) {
                    nbEtoiles += g.nbEtoiles();
                }
                
                System.out.println("Le nombre total d'étoile dans l'univers est de :"+ nbEtoiles);
                    break;   
            
            
                case 6:
                System.out.println("Affichage des caractéristiques du plus gros objet froid de l'univers :")
                
                    break;   
            
            
                case 7:
                          ;
                    break;   
            
            
                case 8:
                          ;
                    break;   
            
            
                case 9:
                          ;
                    break;   
            
            
                case 10:
                quitter = true;
                System.out.println("Fermeture de l'application.");
                    break;
            
            
              default:
                System.out.println("Commande non-reconnu, veuillez réessayer.");         
            }
        }
    }
    
    public static void jeuDessai() {
        
    }
}
