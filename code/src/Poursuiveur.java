/** Joueurs qui se passent le souafle pour tenter de marquer des buts dans l'un des trois cercles d'or. 3 par équipe. */
public class Poursuiveur extends Joueur {
    private boolean tientSouafle;

   /**
    * constructeur de Poursuiveur
    * @param nom
    */
    public Poursuiveur(String nom){
        super(nom);
        tientSouafle = false;
    }

    /** 
     * 
     * le joueur courant realise une passe, ce qui signifie que le souafle peut etre
     * de nouveau attrape par n'importe qui.
     */
    public void passe(Souafle s, Terrain t){
        tientSouafle = false;
        System.out.println(nom+" a passe le souafle !");
        s.seDeplace(t);
    }

    /**
     * appelee quand un poursuiveur attrape un souafle
     * @param s
     */
    public void attrapeSouafle(Souafle s){
        tientSouafle = true;
        s.seDeplace(x, y);
    }

    /**
     * @return true si le poursuiveur a le souafle entre les mains,
     * false sinon.
     */
    public boolean possedeSouafle(){
        return tientSouafle;
    }

    /**
     * affiche le but marque si le gardien adverse n'a pas reussi a l'arreter.
     * @param arrete,e
     */
    public boolean tirAuBut(boolean arrete, Equipe e){
        tientSouafle = false;
        if(!arrete){
            System.out.println("BUT du joueur "+getNom()+" !!!");
            e.comptePoints(10);
            return true;
        }
        else {
            System.out.println("Dommage ! Le poursuiveur "+nom+" a echoue en tentant de marquer !");
            return false;
        }
    }
}
