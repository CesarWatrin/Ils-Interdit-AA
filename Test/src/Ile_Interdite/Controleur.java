/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ile_Interdite;

/**
 *
 * @author peyrinfl
 */
import java.util.HashMap;

public class Controleur {

    private Grille grille;
    private HashMap<String, Aventurier> joueurs = new HashMap<String, Aventurier>();
    private VueAventurier vueAventurier;
    private PileInondation pileInondation;
    private PileTrésor pileTresor;

    public void traiterMessage(String m) {
    }

    public static void main(String[] args) {
        // TODO code application logic here 
        int l = 0;// ligne
        int c = 0;//colonne
        int niv = 1;//demander aux joueurs

        Grille grille = new Grille(niv);
        for (int i = 0; i < 36; i++) {// Creation de la Grille
            Coordonnees C = new Coordonnees(l, c);
            if (c==2 && l==0){LieuDeTresor tuile = new LieuDeTresor(C,"coup");}   //coup
            else if (c==3 && l==0){LieuDeTresor tuile = new LieuDeTresor(C,"coup");} // feu
            else if (c==0 && l==2){LieuDeTresor tuile = new LieuDeTresor(C,"coup");} //coup
            else if (c==0 && l==3){LieuDeTresor tuile = new LieuDeTresor(C,"coup");}
            else if (c==5 && l==2){LieuDeTresor tuile = new LieuDeTresor(C,"coup");} //feu
            else if (c==5 && l==3){LieuDeTresor tuile = new LieuDeTresor(C,"coup");} //
            else if (c==2 && l==5){LieuDeTresor tuile = new LieuDeTresor(C,"coup");}
            else if (c==3 && l==5){LieuDeTresor tuile = new LieuDeTresor(C,"coup");}
            else{
            
            Tuile tuile = new Tuile(C);
            grille.addTuile(tuile);
            }
            if (c == 6) {
                c = 0;
                l++;
            }

        }
        //demander combien de joueur veux jouer de 2 a 4
        // donner aleatoirement des roles
        Ingenieur Joueur1 = new Ingenieur("Joueur1", "");
        Explorateur Joueur2 = new Explorateur("Joueur2", "");
        Pilote Joueur3 = new Pilote("Joueur3", "");
        Plongeur Joueur4 = new Plongeur("Joueur4", "");

    }

}
