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
public class Joueur {
    String nom;
    String couleur;
    Jeton[] ListeJetons= new Jeton [21];
    int  nombreDesintegrateurs;
    int nombreJetonsRestant ;
    
    public Joueur(String unNom){
        nom =unNom;
    }
    public void affecterCouleur(String CouleurPion){
        couleur=CouleurPion;
    }
    public boolean ajouterJeton(Jeton MonJeton){
        while (nombreJetonsRestant<=21){
           for (int i = 0; i<21; i++ ) {
               ListeJetons[i] = MonJeton;
               return true;
           }
        }  
        return false;
    }         
    public void obtenirDesintegrateur(){
        nombreDesintegrateurs=nombreDesintegrateurs +1;
    }
    public boolean utiliserDesintegrateur(){
        if (nombreDesintegrateurs!=0){
            nombreDesintegrateurs=nombreDesintegrateurs-1;
            return true;
        }
        else{
            return false;
        }
    }
}