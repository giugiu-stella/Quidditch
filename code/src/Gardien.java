/**Joueur protégeant les trois cercles d'or pour empêcher les poursuiveurs adverses de marquer des buts. 1 seul par équipe. */

public class Gardien extends Joueur{
    /**
     * Constructeur de Gardien
     */
    public Gardien(String nom){
        super(nom);
    }

    /**
     * @param a,b
     * @return la distance entre le joueur et l'element de coordonnees a et b
     */
    public double distanceTo(int a, int b){
        return Math.sqrt((a - x)*(a - x) + (b - y)*(b - y));
    }

    /**
     * méthode qui decrit la reussite du gardien lors d'un
     * tir au but. Si il reussit a arreter le souafle, on return
     * true, sinon false.
    */ 
    public boolean defense(){
        int alea = (int)(Math.random()*100);
        if (alea < 50){
            return true;
        }
        else {
            return false;
        }
    }
}
