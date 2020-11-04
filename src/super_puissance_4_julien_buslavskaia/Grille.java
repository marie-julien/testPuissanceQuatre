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
    Cellule [][] Cellules=new Cellule[6][7]; 
    //[0][0] en bas a gauche 
    
    //initialisation de la grille 
    //on cree 42 cellules vides 
    Grille() {
        for (int j=0; j<6; j++) {
            for (int Colonne=0; Colonne<7; Colonne++) {
                Cellules[j][Colonne] = new Cellule();
            }
        }
    }
     
    public boolean ajouterJetonDansColonne(Jeton MonJeton,int Colonne){
        if(colonneRemplie(Colonne)==true){
           return false;//la colonne est deja remplie on ne peut pas ajouter de jetons
        }
        else{
            for(int j=0; j<6; j++){
                if (Cellules[j][Colonne].recupererJeton()!=null){
                    j++;
                }
                else{
                    Cellules[j][Colonne].affecterJeton(MonJeton);
                }
            return true;//un jeton a ete ajoute a la colonne       
        }      
    }   
    return true;
}
    public boolean colonneRemplie(int Colonne){
        if (Cellules[5][Colonne].recupererJeton()==null){
            //5 - en haut de colonne
            return false; //la colonne n'est pas remplie
        }
        else{
            int j=0;//j est la ligne
            while(Cellules[j][Colonne].recupererJeton()!=null && j<7){
                j++;
            }
            return true;//la colonne est remplie
         }
            
        }
    public boolean etreRemplie(){
        for (int Colonne=0; Colonne<7; Colonne++){
            for (int j=0; j<6; j++){
                if (Cellules[j][Colonne].recupererJeton()==null){
                    return false; //la grille n'est pas remplie
                }
                else{
                    return true; //la grille est remplie
                }
            }
            
        }
        return true;
    }
    public void viderGrille(){
        for (int Colonne=0; Colonne<7; Colonne++){
            for (int j=0; j<6; j++){ 
               Cellules[j][Colonne].supprimerJeton();
            }
            }  
    }
    public boolean celluleOccupee(int Colonne, int j){
      if(Cellules[j][Colonne].recupererJeton()==null){ 
          return false;// cellule vide
      }
      else{
          return true;// cellule pleine
      }
    }
    public String lireCouleurDuJeton(int Colonne, int j){
        return Cellules[j][Colonne].lireCouleurJeton();  
    }
    
    
    public boolean etreGagnantePourJoueur(Joueur JetonCourant){
        for (int Colonne=0; Colonne<7; Colonne++){
            for (int j=0; j<3; j++){ // ligne => carre rouge 
                if ((Cellules[j][Colonne].lireCouleurJeton()==JetonCourant.couleur)&&(Cellules[j][Colonne+1].lireCouleurJeton()==JetonCourant.couleur)&&(Cellules[j][Colonne+2].lireCouleurJeton()==JetonCourant.couleur)&&(Cellules[j][Colonne+3].lireCouleurJeton()==JetonCourant.couleur)){
                    return true;
                }
            }   
        }    
        for (int j=0; j<6; j++){
            for (int Colonne=0; Colonne<4; Colonne++){ // colonne => carre vert 
                if ((Cellules[j][Colonne].lireCouleurJeton()==JetonCourant.couleur)&&(Cellules[j+1][Colonne].lireCouleurJeton()==JetonCourant.couleur)&&(Cellules[j+2][Colonne].lireCouleurJeton()==JetonCourant.couleur)&&(Cellules[j+3][Colonne].lireCouleurJeton()==JetonCourant.couleur)){
                    return true;
                }
            }   
        } 
        for (int j=0; j<3; j++){
            for (int Colonne=0; Colonne<4; Colonne++){ // diagonale descendante => carre orange
                if ((Cellules[j][Colonne].lireCouleurJeton()==JetonCourant.couleur)&&(Cellules[j+1][Colonne+1].lireCouleurJeton()==JetonCourant.couleur)&&(Cellules[j+2][Colonne+2].lireCouleurJeton()==JetonCourant.couleur)&&(Cellules[j+3][Colonne+3].lireCouleurJeton()==JetonCourant.couleur)){
                    return true;
                }
            }   
        } 
        for (int j=3; j<6; j++){
            for (int Colonne=0; Colonne<4; Colonne++){ // diagonale montante => carre noir
                if ((Cellules[j][Colonne].lireCouleurJeton()==JetonCourant.couleur)&&(Cellules[j+1][Colonne+1].lireCouleurJeton()==JetonCourant.couleur)&&(Cellules[j+2][Colonne+2].lireCouleurJeton()==JetonCourant.couleur)&&(Cellules[j+3][Colonne+3].lireCouleurJeton()==JetonCourant.couleur)){
                    return true;
                }
            }   
        } 
        return false;
    }    
    
    public boolean placerTrouNoir(int Colonne, int j){
        if (Cellules[j][Colonne].placerTrouNoir()==true){
            return true;//l'ajout s'est bien passe
        }
        else{
            return false;
        }
    
    } 
     public boolean placerDesintegrateur(int Colonne, int j){
        if (Cellules[j][Colonne].placerDesintegrateur()==true){
            return true;//l'ajout s'est bien passe
        }
        else{
            return false;
        }
    
    } 
     public boolean supprimerJeton(int Colonne, int j){
        if (Cellules[j][Colonne].supprimerJeton()==true){
            return true;//la suppression s'est bien passe
        }
        else{
            return false;
        }
    
    }
     public Jeton recupererJeton(int Colonne, int j){
        return Cellules[j][Colonne].recupererJeton();
        }
    
     public void afficherGrilleSurConsole(){
     //pour chaque cellule afficher s'il y a un jeton sa couleur ou un T ou un D
     for (int Colonne=0; Colonne<7; Colonne++){
            for (int j=0; j<6; j++){
                if (Cellules[j][Colonne].placerTrouNoir()==true){
                    System.out.println("T");
                }
                if (Cellules[j][Colonne].placerDesintegrateur()==true){
                    System.out.println("D");
                }
                if (Cellules[j][Colonne].recupererJeton()==null){
                    System.out.println("N");
                }
                if (Cellules[j][Colonne].recupererJeton()!=null){
                    Jeton JetonCourant=Cellules[j][Colonne].recupererJeton();
                    if (JetonCourant.lireCouleur()=="rouge"){
                    System.out.println("R");
                    }
                    else{
                    System.out.println("J");        
                    }
                }
                }
            }
    }
     public void tasserGrille(int Colonne){
         for (int j=5 ; j>=0; j--){//on met i-- car on part du bas de la grille: la ligne 5
             if (Cellules[j][Colonne]==null){
                 if(j!=0){
                    Cellules[j][Colonne]=Cellules[j-1][Colonne];
                 }
                 }
             }
         }
     }
    






