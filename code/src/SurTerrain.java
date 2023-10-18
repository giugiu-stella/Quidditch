/**
 * 
 * Interface pour gerer la position des elements
 * qui se deplacent sur le terrain, c'est a dire les
 * joueurs, les cognards et le vif d'or.
 * 
 */
public interface SurTerrain {
    public void seDeplace(int xnew,int ynew);

    public String toString();
}
