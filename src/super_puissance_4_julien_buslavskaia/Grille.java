/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package super_puissance_4_julien_buslavskaia;

/**
 *
 * @author mjulien
 */
public class Grille {

    Cellule Cellules[][] = new Cellule[6][7];

    public Grille() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Cellules[i][j] = new Cellule();
            }
        }
    }

    public boolean ajouterJetonDansColonne(Jeton MonJeton, int Colonne) {
        if (colonneRemplie(Colonne) == true) {
            return false;//la colonne est deja remplie on ne peut pas ajouter de jetons
        } else {
            for (int j = 0; j < 6; j++) {
                if (Cellules[j][Colonne].recupererJeton() == null) {
                    Cellules[j][Colonne].affecterJeton(MonJeton);
                    return true;//un jeton a ete ajoute a la colonne       
                }
            }
        }
        return false;
    }

    public boolean colonneRemplie(int Colonne) {
        if (Cellules[5][Colonne].recupererJeton() == null) {
            return false; //la colonne n'est pas remplie
        } else {
            return true;//la colonne est remplie
        }

    }

    public boolean etreRemplie() {
        for (int Colonne = 0; Colonne < 7; Colonne++) {
            for (int j = 0; j < 6; j++) {
                if (Cellules[j][Colonne].recupererJeton() == null) {
                    return false; //la grille n'est pas remplie
                } else {
                    return true; //la grille est remplie
                }
            }

        }
        return true;
    }

    public void viderGrille() {
        for (int Colonne = 0; Colonne < 7; Colonne++) {
            for (int j = 0; j < 6; j++) {
                Cellules[j][Colonne].supprimerJeton();
                 Cellules[j][Colonne].trouNoir =false;
                 Cellules[j][Colonne].desintegrateur  =false;
                 
            }
        }
    }

    public boolean celluleOccupee(int Colonne, int j) {
        if (Cellules[j][Colonne].recupererJeton() == null) {
            return false;// cellule vide
        } else {
            return true;// cellule pleine
        }
    }

    public String lireCouleurDuJeton(int Colonne, int j) {
        return Cellules[j][Colonne].lireCouleurJeton();
    }

    public boolean etreGagnantePourJoueur(Joueur JetonCourant) {
        for (int Colonne = 0; Colonne < 7; Colonne++) {
            for (int j = 0; j < 3; j++) { // ligne => carre bleu 
                if ((Cellules[j][Colonne].lireCouleurJeton() == JetonCourant.couleur) && (Cellules[j][Colonne + 1].lireCouleurJeton() == JetonCourant.couleur) && (Cellules[j][Colonne + 2].lireCouleurJeton() == JetonCourant.couleur) && (Cellules[j][Colonne + 3].lireCouleurJeton() == JetonCourant.couleur)) {
                    return true;
                }
            }
        }
        for (int j = 0; j < 6; j++) {
            for (int Colonne = 0; Colonne < 4; Colonne++) { // colonne => carre rouge 
                if ((Cellules[j][Colonne].lireCouleurJeton() == JetonCourant.couleur) && (Cellules[j + 1][Colonne].lireCouleurJeton() == JetonCourant.couleur) && (Cellules[j + 2][Colonne].lireCouleurJeton() == JetonCourant.couleur) && (Cellules[j + 3][Colonne].lireCouleurJeton() == JetonCourant.couleur)) {
                    return true;
                }
            }
        }
        for (int j = 0; j < 3; j++) {
            for (int Colonne = 0; Colonne < 4; Colonne++) { // diagonale descendante => carre vert
                if ((Cellules[j][Colonne].lireCouleurJeton() == JetonCourant.couleur) && (Cellules[j + 1][Colonne + 1].lireCouleurJeton() == JetonCourant.couleur) && (Cellules[j + 2][Colonne + 2].lireCouleurJeton() == JetonCourant.couleur) && (Cellules[j + 3][Colonne + 3].lireCouleurJeton() == JetonCourant.couleur)) {
                    return true;
                }
            }
        }
        for (int j = 3; j < 6; j++) {
            for (int Colonne = 0; Colonne < 4; Colonne++) { // diagonale montante => carre noir
                if ((Cellules[j][Colonne].lireCouleurJeton() == JetonCourant.couleur) && (Cellules[j - 1][Colonne + 1].lireCouleurJeton() == JetonCourant.couleur) && (Cellules[j - 2][Colonne + 2].lireCouleurJeton() == JetonCourant.couleur) && (Cellules[j - 3][Colonne + 3].lireCouleurJeton() == JetonCourant.couleur)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean placerTrouNoir(int Colonne, int j) {
        if (Cellules[j][Colonne].placerTrouNoir() == true) {
            return true;//l'ajout s'est bien passe
        } else {
            return false;
        }

    }

    public boolean placerDesintegrateur(int Colonne, int j) {
        if (Cellules[j][Colonne].placerDesintegrateur() == true) {
            return true;//l'ajout s'est bien passe
        } else {
            return false;
        }

    }

    public boolean supprimerJeton(int Colonne, int j) {
        if (Cellules[j][Colonne].supprimerJeton() == true) {
            return true;//la suppression s'est bien passe
        } else {
            return false;
        }

    }

    public Jeton recupererJeton(int Colonne, int j) {
        return Cellules[j][Colonne].recupererJeton();
    }

    public void afficherGrilleSurConsole() {
        //pour chaque cellule afficher s'il y a un jeton sa couleur ou un T ou un D
         for (int j = 5; j >= 0; j--) {
             for (int Colonne = 0; Colonne < 7; Colonne++) {
           
                if (Cellules[j][Colonne].presenceTrouNoir()== true) {
                    System.out.print("T");
                }
                else if (Cellules[j][Colonne].presenceDesintegrateur()== true) {
                    System.out.print("D");
                }
                else if (Cellules[j][Colonne].JetonCourant == null) {
                    System.out.print("N");
                }
                else if (Cellules[j][Colonne].JetonCourant != null) {
                    Jeton JetonCourant = Cellules[j][Colonne].recupererJeton();
                    if (JetonCourant.lireCouleur() == "rouge") {
                        System.out.print("R");
                    } else {
                        System.out.print("J");
                    }
                }
            }
             System.out.println();
        }
    }

    public void tasserGrille(int Colonne) {
        for (int j = 5; j >= 1; j--) {//on met i-- car on part du bas de la grille: la ligne 5
            if (Cellules[j][Colonne].JetonCourant  == null) {
               Cellules[j][Colonne].JetonCourant = Cellules[j - 1][Colonne].JetonCourant;
               Cellules[j - 1][Colonne].JetonCourant= null;
               
            }
        }
    }
}
