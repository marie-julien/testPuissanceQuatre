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
        for (int i=0; i<21; i++) {
            Jeton JetonCourant = new Jeton(ListeJoueurs[].couleur);
            Joueur1.ajouterJeton(JetonCourant);
            //eton JetonCourant = new Jeton(ListeJoueurs[1].couleur);
            Joueur2.ajouterJeton(JetonCourant);
        }
        
    }
    
    public void debuterPartie() {
        //deux boucles (l'une dans l'autre) 
        //tant que le jeu n'est pas fini 
        //tant que coup de JoueurCourant n'est pas valide on lui redemande de jouer un coup 
        grilleDeJeu.afficherGrilleSurConsole();
        //dans boucle tant que le jeu n'est pas fini faire l'appel a la fonction etregagnantepourjoueur 
        while (grilleDeJeu.etreGagnantePourJoueur(joueurCourant)!=true && grilleDeJeu.etreRemplie()!=true) {
            int i = 0;
            System.out.println("Dans quelle colonne souhaitez-vous placer votre pion");
            Scanner sc = new Scanner(System.in); //demande le numero de la colonne
            //si dans cellule[libre][colonne] il y a TN => tasserGrille
            if (grilleDeJeu.ajouterJetonDansColonne(ListeJetons[i], sc.nextInt())==true) {
                grilleDeJeu.ajouterJetonDansColonne(ListeJetons[i], sc.nextInt());
            }
            else {
                grilleDeJeu.tasserGrille(sc.nextInt());
                grilleDeJeu.ajouterJetonDansColonne(ListeJetons[i], sc.nextInt());
            }
            grilleDeJeu.afficherGrilleSurConsole();
            i++;
        }     
    }
}
