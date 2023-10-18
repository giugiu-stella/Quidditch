import java.util.ArrayList;

/**
 * classe representant une equipe. Les equipes correspondent
 * aux maisons de Poudlard auxquelles appartiennent les joueurs.
 * Chaque equipe est composee de sept joueurs.
 */
public class Equipe {
    private int nbJoueursMax = 5;
    public String nom;
    public ArrayList<Joueur> compo;
    private int nbPoints;

    /**
     * constructeur d'equipe
     * @param nom
     * @param compo
     */
    public Equipe(String nom, ArrayList<Joueur> compo){
        this.nom = nom;
        this.compo = compo;
        nbPoints = 0;
    }

    /**
     * ajoute les points gagnes a l'equipe
     * @param newPoints
     */
    public void comptePoints(int newPoints){ //ex: but d'un souafle donne 10pts, vif d'or rapporte 150pts
        nbPoints += newPoints;
    }

    /**
     * accesseur du nombre de points
     * @return
     */
    public int getPoints(){
        return nbPoints;
    }

    /**
     * decrit la composition de l'equipe
     */
    public String toString(){
        String nomsJoueurs = "";
        for (int i=0;i<nbJoueursMax-1;i++){
            nomsJoueurs += compo.get(i).nom + ",";
        }
        nomsJoueurs += compo.get(nbJoueursMax-1).nom;
        return "Equipe "+nom+" : "+nomsJoueurs;
    }
}
