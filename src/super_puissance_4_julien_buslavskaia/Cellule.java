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
public class Cellule {
    Jeton JetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    
    public Cellule (){
        JetonCourant=null;
        trouNoir=false;
        desintegrateur=false;
    }
    public boolean affecterJeton(Jeton MonJeton){
        if (JetonCourant==null){
            JetonCourant=MonJeton;
            return true;
        }
        else{
            return false; 
        }
    }
    public Jeton recupererJeton(){
        Jeton jetonRetour = JetonCourant;
        JetonCourant = null;
        return jetonRetour;

    }
    
    
    public boolean supprimerJeton(){
        if (JetonCourant!=null){
            JetonCourant=null;
            return true;   
        }
        else{
            return false;
        }
    }
    public boolean placerTrouNoir(){
        if (trouNoir==false){
            trouNoir=true;
            return true;    
        }
        else{
            return false;
        }
    }
     public boolean placerDesintegrateur(){
        if (desintegrateur==false){
            desintegrateur=true;
            return true;    
        }
        else{
            return false;
        }
    }
     public boolean presenceTrouNoir(){
        if(trouNoir==true){
            return true;
        }
        else{
            return false;
        }
     }    
     public boolean presenceDesintegrateur(){
        if(desintegrateur==true){
            return true;
        }
        else{
            return false;
        }
     }    
     public String lireCouleurJeton(){
         
         // si jetonCourant est nul : probleme : null pointer exeption
         return JetonCourant.lireCouleur();
     }
     
     
     
     public boolean recupererDesintegrateur(){
         if(desintegrateur==true){
             desintegrateur=false;
             return true;
         }
         else {
             return false;
         }
     }
     public boolean activerTrouNoir(){
        if((JetonCourant!=null) && (trouNoir==true)) {
            JetonCourant=null;
            trouNoir=false;
            return true;
        }
        else {
            return false;
        }
     }
     
}
     
     
     
