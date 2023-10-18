import Exceptions.JoueurBlesseException;
import Exceptions.MagieInterditeException;

/**
 * un joueur a une jauge d'energie qui se vide si il est ensorcelé ou si il se
 * blesse a cause d'un cognard. Si la jauge est vide alors le joueur sort du
 * terrain.
 */
public abstract class Joueur extends Personne implements SurTerrain {
    protected String nom;
    protected int energie;
    protected final int energieMax = 10; 
    protected int x;
    protected int y;

    protected Joueur(String nom){
        this.nom = nom;
        energie = energieMax;
    }

    /**
     *  
     * @param a
     * @param b
     * @return la distance entre le joueur et l'élèment en position (a,b)
     */
    public double distanceTo(int a, int b){
        return Math.sqrt((a - x)*(a - x) + (b - y)*(b - y));
    }

    /**
     * place le joueur sur le terrain en fonction de son
     * role dans l'equipe et de sa proximite avec une balle
     */
    public void seDeplace(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * @param adverse 
     * @return le joueur adverse le plus proche du joueur courant
     */
    public Joueur plusProche(Equipe adverse){
        Joueur j = adverse.compo.get(0);
        double distanceMin = distanceTo(j.getX(),j.getY()); 
        for(Joueur a: adverse.compo){
            if(distanceMin>distanceTo(a.getX(),a.getY())){
              distanceMin= distanceTo(a.getX(),a.getY());
              j=a;
            }
        }
        return j;
    }

    /**
     * @return x
     */
    public int getX(){
        return x;
    }

    /**
     * 
     * @return y
     */
    public int getY(){
        return y;
    }

    /**
     * nom du joueur et sa position
     */
    public String toString(){
        return nom+" : ("+getX()+","+getY()+")";
    }

    /**
     * enlève une quantite degats d'energie au joueurs blesse.
     */
    public void perteEnergie(int degats) throws JoueurBlesseException {
        if (degats>=energieMax-energie){
            throw new JoueurBlesseException("Le joueur n'a plus d'energie.");
        }
        else {
            energie -= degats;
        }
    }

    /**
     * ajoute un niveau d'énergie
     */
    public void ajoutEnergie(int soins){
       if(energie<energieMax){
            energie+=soins;
       }
    }

    /**
     * 
     * @return nom
     */
    public String getNom(){
        return nom;
    }

    /**
     * @param j
     * @param degats
     * @throws JoueurBlesseException
     */
    public void ensorceleJoueur(Joueur j, int degats) throws MagieInterditeException, JoueurBlesseException {
        super.ensorceleJoueur(j, degats);
        int proba = (int)(Math.random()*2+1);
        if (proba == 1){ //1 chance sur 2 de se faire prendre
            throw new MagieInterditeException("Le joueur "+nom+" a triche ! 10 points sont attribues a l'equipe du joueur "+j.getNom());
        }
    }
}
