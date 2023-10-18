public abstract class Balle implements SurTerrain {
    protected int x; 
    protected int y;

    /**
     * Constructeur de Balle
     */
    protected Balle(Terrain t) {
        x = (int)(Math.random()*t.getLargMax());
        y = (int)(Math.random()*t.getLongMax());
    }

    /**
     * place la balle sur le terrain en fonction de son type
     */
    public void seDeplace(int x, int y){
        this.x=x;
        this.y=y;
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
    
    public abstract String toString();
}
