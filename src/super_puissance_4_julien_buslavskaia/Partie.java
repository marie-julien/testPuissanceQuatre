/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package super_puissance_4_julien_buslavskaia;

import java.util.Random;
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
        //ListeJoueurs[0].couleur = "rouge";
        //ListeJoueurs[1].couleur = "jaune";
        Random r = new Random();
        boolean couleur;
        couleur = r.nextBoolean();
        if (couleur) {
            ListeJoueurs[0].couleur = "rouge";
            ListeJoueurs[1].couleur = "jaune";
        }
        else {
            ListeJoueurs[0].couleur = "jaune";
            ListeJoueurs[1].couleur = "rouge";
        }
    }
    
    public Joueur ProchainJoueur(Joueur unJoueur) {
        if (ListeJoueurs[0]==joueurCourant) {
            return ListeJoueurs[1];
        }
        return ListeJoueurs[0];
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
        for (int i=0; i<21; i++) {
            Joueur1.ajouterJeton(new Jeton(Joueur1.couleur));
            Joueur2.ajouterJeton(new Jeton(Joueur2.couleur));
        }  
        Random r = new Random();
        boolean premier = r.nextBoolean();
        if (premier) {
            joueurCourant = ListeJoueurs[0];
        }
        else {
            joueurCourant = ListeJoueurs[1];
        }
    }
    
    public boolean recupJeton() {
        int colonne;
        int ligne;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir les coordonnees du jeton a recuperer :");
        System.out.println("Veuillez saisir la colonne :");
        colonne = sc.nextInt()-1;
        while (colonne > 6 || ligne < 0) {
            System.out.println("Erreur : veillez saisir une colonne valide :");
            colonne = sc.nextInt()-1;
        }
        
        if (grilleDeJeu.Cellules[ligne][colonne].JetonCourant!=null) {
            
        }
    }
    
    public void jouerJeton() {
        Scanner sc = new Scanner(System.in);
        boolean resultatAction;
        System.out.println("Veuillez saisir une colonne :");
        int colonne = sc.nextInt() - 1;
        while (colonne > 6 || colonne < 0) {
            System.out.println("Erreur : veuillez saisir une colonne :");
            colonne = sc.nextInt() - 1;
        }
        
        resultatAction = grilleDeJeu.ajouterJetonDansColonne(joueurCourant, colonne);
        while (!resultatAction) {
            System.out.println("La colonne est pleine veillez saisir une autre colonne :");
            colonne = sc.nextInt()-1;
            resultatAction = grilleDeJeu.ajouterJetonDansColonne(joueurCourant, colonne);
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
                    if (grilleDeJeu.ajouterJetonDansColonne(ListeJoueurs[i], sc.nextInt())==true) {
                        grilleDeJeu.ajouterJetonDansColonne(ListeJoueurs[i], sc.nextInt());
                    }
                    else {
                        grilleDeJeu.tasserGrille(sc.nextInt());
                        grilleDeJeu.ajouterJetonDansColonne(ListeJoueurs[i], sc.nextInt());
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
                    if (grilleDeJeu.ajouterJetonDansColonne(ListeJoueurs[i], sc.nextInt())==true) {
                        grilleDeJeu.ajouterJetonDansColonne(ListeJoueurs[i], sc.nextInt());
                    }
                    else {
                        grilleDeJeu.tasserGrille(sc.nextInt());
                        grilleDeJeu.ajouterJetonDansColonne(ListeJoueurs[i], sc.nextInt());
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