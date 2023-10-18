/**Balle ensorcelée qui une fois attrapée, fait gagner cent cinquante points d'un coup à l’équipe, lui assurant généralement la victoire. */
public class VifDOr extends Balle {
    public boolean attrape = false;
    /**
     * constructeur de VifDOr 
     * @param t
     */
    public VifDOr(Terrain t){
        super(t);
    }

    public void estAttrape(){
        attrape = true;
    }

    /**
     * méthode qui permet de déplacer le vif d'or. Cette balle 
     * est tellement rapide qu'on considere que chaque deplacement 
     * la mene vers une case aleatoire du terrain.
     */
    public void seDeplace(Terrain t){
        x=(int)(Math.random()*t.getLargMax());
        y=(int)(Math.random()*t.getLongMax());
    }

    public String toString(){
        return "Vif d'or : ("+getX()+","+getY()+")";
    }
}
