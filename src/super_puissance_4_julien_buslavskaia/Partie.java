/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package super_puissance_4_julien_buslavskaia;

import java.util.Scanner;

/**
 *
 * @author mjulien
 */
public class Partie {
    Joueur [] ListeJoueurs = new Joueur[2];
    Jeton [] ListeJetons = new Jeton[21];
    Grille grilleDeJeu = new Grille();
    Joueur joueurCourant;
    
    public void attribuerCouleursAuxJoueurs() {
        ListeJoueurs[0].couleur = "rouge";
        ListeJoueurs[1].couleur = "jaune";
    }
    
    public void initialiserPartie() { 
        //Grille [][] GrilleJeu = new Grille[6][7];
        grilleDeJeu.viderGrille(); 
        for (int i=0; i<3; i++) {
            grilleDeJeu.placerTrouNoir((int)(Math.random()*(6-i)), (int)(Math.random()*(7-i)));
            grilleDeJeu.placerDesintegrateur((int)(Math.random()*(6-i)), (int)(Math.random()*(7-i)));
        }
        //grilleDeJeu.placerTrouNoir((int)(Math.random()*6), (int)(Math.random()*7));
        //grilleDeJeu.placerDesintegrateur((int)(Math.random()*6), (int)(Math.random()*7));
        //grilleDeJeu.placerTrouNoir((int)(Math.random()*4), (int)(Math.random()*5));
        //grilleDeJeu.placerDesintegrateur((int)(Math.random()*4), (int)(Math.random()*5));
        System.out.println("Merci de rentrer le pseudo de Joueur 1");
        Scanner sc = new Scanner(System.in);
        Joueur Joueur1 = new Joueur(sc.nextLine());
        System.out.println("Merci de rentrer le pseudo de Joueur 2");
        Joueur Joueur2 = new Joueur(sc.nextLine());
        ListeJoueurs[0]=Joueur1;
        ListeJoueurs[1]=Joueur2;
        attribuerCouleursAuxJoueurs();
        //ajout des jetons
        for (int i=0; i<42; i++) {
            if (i<21) {
                joueurCourant = ListeJoueurs[0];
                String couleur = joueurCourant.couleur;
                ListeJetons[i] = new Jeton(couleur);
                joueurCourant.ajouterJeton(ListeJetons[i]);
            }
            else {
                joueurCourant = ListeJoueurs[1];
                String couleur = joueurCourant.couleur;
                ListeJetons[i] = new Jeton(couleur);
                joueurCourant.ajouterJeton(ListeJetons[i]);
            }
        }   
    }
    
    public void debuterPartie() {
        //deux boucles (l'une dans l'autre) 
        //tant que le jeu n'est pas fini 
        //tant que coup de JoueurCourant n'est pas valide on lui redemande de jouer un coup 
        //dans boucle tant que le jeu n'est pas fini faire l'appel a la fonction etregagnantepourjoueur 
        grilleDeJeu.afficherGrilleSurConsole();
        while (grilleDeJeu.etreGagnantePourJoueur(joueurCourant)!=true && grilleDeJeu.etreRemplie()!=true) {
            int i = 0; //i - coup
            if (joueurCourant == ListeJoueurs[0]) {
                System.out.println("Dans quelle colonne souhaitez-vous placer votre pion");
                Scanner sc = new Scanner(System.in);    //demande le numero de la colonne
                                                        //si dans cellule[libre][colonne] il y a TN => tasserGrille
                if (sc.nextInt()<7) {                                        
                    if (grilleDeJeu.ajouterJetonDansColonne(ListeJetons[i], sc.nextInt())==true) {
                        grilleDeJeu.ajouterJetonDansColonne(ListeJetons[i], sc.nextInt());
                    }
                    else {
                        grilleDeJeu.tasserGrille(sc.nextInt());
                        grilleDeJeu.ajouterJetonDansColonne(ListeJetons[i], sc.nextInt());
                    }
                    grilleDeJeu.afficherGrilleSurConsole();
                    joueurCourant = ListeJoueurs[1];
                }  
                else {
                    System.out.println("Le numero de la colonne doit être inferieur à 7");
                }
            }    
            else if (joueurCourant == ListeJoueurs[1]) {
                System.out.println("Dans quelle colonne souhaitez-vous placer votre pion");
                Scanner sc = new Scanner(System.in);    //demande le numero de la colonne
                                                        //si dans cellule[libre][colonne] il y a TN => tasserGrille
                if (sc.nextInt()<7) {                                        
                    if (grilleDeJeu.ajouterJetonDansColonne(ListeJetons[i], sc.nextInt())==true) {
                        grilleDeJeu.ajouterJetonDansColonne(ListeJetons[i], sc.nextInt());
                    }
                    else {
                        grilleDeJeu.tasserGrille(sc.nextInt());
                        grilleDeJeu.ajouterJetonDansColonne(ListeJetons[i], sc.nextInt());
                    }
                    grilleDeJeu.afficherGrilleSurConsole();
                    joueurCourant = ListeJoueurs[0];
                } 
                else {
                    System.out.println("Le numero de la colonne doit être inferieur à 7");
                }
            } 
            i++;
        }     
    }
}
//notre code n'est pas fonctionnel, mais on n'a pas reussi à aller plus loin : nous ne comprenions pas notre erreur