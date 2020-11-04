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
    Joueur joueurCourant;
    
    
    public void attribuerCouleursAuxJoueurs() {
        ListeJoueurs[0].couleur = "rouge";
        ListeJoueurs[1].couleur = "jaune";
    }
    
    public void initialiserPartie() { // grille + trous + 
        Grille [][] GrilleJeu = new Grille[6][7];
        GrilleJeu[6][7].viderGrille(); 
        GrilleJeu[6][7].placerTrouNoir((int)(Math.random()*6), (int)(Math.random()*7));
        GrilleJeu[6][7].placerDesintegrateur((int)(Math.random()*6), (int)(Math.random()*7));
        Scanner sc = new Scanner(System.in);
        Joueur Joueur1 = new Joueur(sc.nextLine());
        Joueur Joueur2 = new Joueur(sc.nextLine());
        ListeJoueurs[0]=Joueur1;
        ListeJoueurs[1]=Joueur2;
        for (int i=0; i<21; i++) {
            Jeton MonJetonCourant1 = new Jeton(ListeJoueurs[0].couleur);
            Joueur1.ajouterJeton(MonJetonCourant1);
            Jeton MonJetonCourant2 = new Jeton(ListeJoueurs[1].couleur);
            Joueur2.ajouterJeton(MonJetonCourant2);
        }
        
    }
    
    public void debuterPartie() {
        //deux boucles (l'une dans l'autre) 
        //tant que le jeu n'est pas fini 
        //tant que coup de JoueurCourant n'est pas valide on lui redemande de jouer un coup 
        
        //dans boucle tant que le jeu n'est pas fini faire l'appel a la fonction etregagnantepourjoueur 
        //while () {
            
        //}
    }
}
