/**Les poursuiveurs de chaque équipe l'utilisent pour 
 * marquer des buts. Il n'est pas ensorcelé et il ne 
 * se déplace que par le biais des passes entre poursuiveurs. */
public class Souafle extends Balle{
    /**
     * constructeur de souafle
     */
    public Souafle(Terrain t){
        super(t);
    }

    /**
     * gere le deplacement du souafle lorsqu'il est dans les mains de quelqu'un
     */
    public void seDeplace(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * gere le deplacement du souafle lorsqu'il est passe
     * @param t
     */
    public void seDeplace(Terrain t){
        x=(int)(Math.random()*t.getLargMax());
        y=(int)(Math.random()*t.getLongMax());
    }

    /**
     * affiche le type de la balle et sa position
     */
    public String toString(){
        return "Souafle : ("+getX()+","+getY()+")";
    }
}
