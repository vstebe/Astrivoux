package MainPack;

import astrouml.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    
    static Galaxie voieLactee;
    static Etoile soleil;
    static Univers univ;
    
    public static void main(String[] args) {
        

        
        voieLactee = null;
        soleil = null;
        univ = null;

        int commande, num;
        Scanner scInt = new Scanner(System.in);         //Scanner pour les int
        Scanner scStr = new Scanner(System.in);         //Scanner pour les String
        Boolean quitter = false;
        ArrayList<ObjCeleste> tabObj;
        ArrayList<Galaxie> tabGala;
        ObjCeleste obj;
        String nomGala;
        
        while (!quitter) {
            System.out.println("\n\n**********   Menu   **********\n");
            System.out.println("0. Initialiser le systéme avec le jeu d'essai.");
            System.out.println("1. Afficher les caractéristiques de l'Objet Né x.");
            System.out.println("2. Lister toutes les galaxies : nom, type, éloignement.");
            System.out.println("3. Lister tous les objets connus de la galaxie de nom \"X\" avec leurs caractéristiques.");
            System.out.println("4. Lister les satellites de l'objet (étoile, planéte,...) Né X.");
            System.out.println("5. Afficher le nombre total d'étoiles répertoriées dans l'univers.");
            System.out.println("6. Afficher les caractéristiques du plus gros objet froid.");
            System.out.println("7. Ajouter une nouvelle étoile.");
            System.out.println("8. Ajouter un nouvel objet froid (é une étoile ou é un objet froid).");
            System.out.println("9. Ajouter une galaxie (nom, type, eloign).");
            System.out.println("10 Quitter.");
            
            commande = scInt.nextInt();
            
            
            
            switch (commande)
            {
                case 0:
                        jeuDessai();
                    break;
            
            
                case 1:     //Bug : impossible d'afficher l'objet 1 (soleil) : cheat fail ! 
                if(univ == null) {
                    System.out.println("Univers non initialisé ");
                    break;
                }
                
                System.out.println("\n\nQuelle objet voulez-vous afficher ?");
                num = scInt.nextInt();
                obj = univ.getObjet(num);
                if (obj != null)
                {
                  System.out.println("\nAffichage de l'objet Né"+num+" :");
                  System.out.println(obj.toString());
                }
                else {
                    System.out.println("\nObjet N�"+num+" introuvable.");
                }
                    break;   
            
            
                case 2:     //n'affiche pas la voie lactée, n'affiche pas toutes les infos (need un toString())
                if(univ == null) {
                    System.out.println("Univers non initialisé ");
                    break;
                }
                tabGala =  univ.getAllGalaxies();
                System.out.println("\n\nAffichage de toutes les galaxies :\n");
                for (Galaxie g : tabGala)
                {
                    System.out.println(g.toString());
                }
                    break;   
            
                case 3: //fonctionne correctement
                if(univ == null) {
                    System.out.println("Univers non initialisé ");
                    break;
                }
                System.out.println("\n\nDe quelle galaxie voulez-vous affichez les objets ?");
                nomGala = scStr.nextLine();
                Galaxie gala = univ.getGalaxie(nomGala);
                tabObj = univ.getObjets(gala);
                System.out.println("\nAffichage des objets de "+nomGala+" :\n");
                for (ObjCeleste o : tabObj) {
                    System.out.println(o.toString());
                }
                    break;   
            
                case 4:     //fonctionne
                if(univ == null) {
                    System.out.println("Univers non initialisé ");
                    break;
                }
                System.out.println("\n\nDe quel objet voulez-vous lister les satellites ?");
                num = scInt.nextInt();
                obj = univ.getObjet(num);
                ArrayList<ObjFroid> tabSatel = obj.getSatellites();
                if(!tabSatel.isEmpty())
                {
                System.out.println("\nLes satellites de "+obj.getNom()+" sont les suivants :\n");
                    for(ObjCeleste o : tabSatel) {
                        System.out.println(o.toString());
                    }
                }
                else
                    System.out.println("\n"+obj.getNom()+" ne comporte pas de satellites.");
                    break;   
            
                case 5: //fonctionne pas
                if(univ == null) {
                    System.out.println("Univers non initialisé ");
                    break;
                }
                tabGala = univ.getAllGalaxies();
                int nbEtoiles =0 ;
                for (Galaxie g : tabGala) {
                    nbEtoiles += g.nbEtoiles();     //nbEtoiles à pas l'air de marcher
                    System.out.println(g.getNom());     // voie lactée pas dans tabGala
                }
                
                System.out.println("\n\nLe nombre total d'étoile dans l'univers est de : "+ nbEtoiles);
                    break;   
            
            
                case 6: //fonction BigFroid() ?
                if(univ == null) {
                    System.out.println("Univers non initialisé ");
                    break;
                }
                System.out.println("\n\nAffichage des caractéristiques du plus gros objet froid de l'univers : ");
                
                    break;   
            
            
                case 7:             //é l'air de fonctionner
                if(univ == null) {
                    System.out.println("Univers non initialisé ");
                    break;
                }
                System.out.println("\n\nAjout d'une nouvelle étoile.");
                System.out.print("     -Nom ? ");
                String nomEtoile = scStr.nextLine();
                System.out.print("     -Magnitude ? ");
                int magEtoile = scInt.nextInt();
                System.out.print("     -Age (lettre) ? ");
                String ageEtoile = scStr.nextLine();
                System.out.print("     -Galaxie ? ");
                nomGala = scStr.nextLine();
                gala = univ.getGalaxie(nomGala);
                
                if (gala == null) {
                    System.out.println("\nGalaxie invalide !");
                }
                else {
                    univ.creerEtoile(nomEtoile, magEtoile, ageEtoile, gala);
                    System.out.println("\n"+nomEtoile + " a bien été créé.");
                }
                    break;   
            
            
                case 8:     //ne fonctionne pas
                if(univ == null) {
                    System.out.println("Univers non initialisé ");
                    break;
                }
                System.out.println("\n\nAjout d'un nouvel objet froid.");
                System.out.print("     -Nom ? ");
                String nomObj = scStr.nextLine();
                System.out.print("     -Rayon ? ");
                int rayObj = scInt.nextInt();
                System.out.print("     -Diamétre ? ");
                int diamObj = scInt.nextInt();
                System.out.print("     -Période ? ");
                int periodeObj = scInt.nextInt();
                System.out.print("     -Centre de l'orbite ?");
                String centreObj = scStr.nextLine();
                obj = univ.getObjet(centreObj);
                if (obj == null) {
                    System.out.println("\nLe centre de l'orbite est invalide !");
                }
                else {
                    univ.creerObjetFroid(nomObj,rayObj,diamObj,periodeObj,obj);
                    System.out.println("\n"+nomObj + " a bien été créé.");
                }
                    break;   
            
            
                case 9:
                if(univ == null) {
                    System.out.println("Univers non initialisé ");
                    break;
                }
                System.out.println("\n\nAjout d'une nouvelle galaxie.");
                System.out.print("     -Nom ? ");
                nomGala = scStr.nextLine();
                System.out.print("     -Type ? ");
                String typeGala = scStr.nextLine();
                System.out.print("     -Eloignement ? ");
                int eloiGala = scInt.nextInt();
                
                univ.creerGalaxie(nomGala,typeGala,eloiGala);
                
                System.out.println("\nLa galaxie "+nomGala+" a bien été créee.");
                    break;   
            
            
                case 10:
                if(univ == null) {
                    System.out.println("Univers non initialisé ");
                    break;
                }
                quitter = true;
                System.out.println("\n\nFermeture de l'application.");
                    break;
            
           
              default:
                System.out.println("\n\nCommande non-reconnu, veuillez réessayer.");         
            }
            scStr.nextLine();
        }
    }
    
    
    
    //initialise le programme
    public static void jeuDessai() {
        
        voieLactee = new Galaxie("Voie Lactée", "spirale", 0);
        soleil = new Etoile(1, "Soleil",0, "F", voieLactee );
        univ = new Univers("Voie Lactée", "spirale", 0, "Soleil", 0, "F");
        
        
       ObjCeleste terre = univ.creerObjetFroid("Terre", 150000, 13000, 365, soleil);
       ObjCeleste lune = univ.creerObjetFroid("Lune", 200, 5000, 30, terre);
       ObjCeleste mars = univ.creerObjetFroid("Mars",200000,11000,750, soleil);
       ObjCeleste phobos = univ.creerObjetFroid("Phobos", 150,500,40,mars);
       ObjCeleste pluton = univ.creerObjetFroid("Pluton", 1200000, 4000, 900, soleil);
       
       Etoile sirius = univ.creerEtoile("Sirius", 2,"B",voieLactee);
       ObjCeleste big1 = univ.creerObjetFroid("BIG1", 1000, 50000, 333, sirius);
       
       Galaxie m31 = univ.creerGalaxie("M31", "lenticulaire", 900000);
       Etoile xs67 = univ.creerEtoile("XS67",8,"F", m31);
       ObjCeleste xp88 = univ.creerObjetFroid("XP88", 160000,40000,400, xs67);
       
       System.out.println("\n\nLe jeu d'essai a été créé avec succés !");
    }
}
