/** Joueur qui a pour rôle de rechercher et attraper le vif d’or tout en empêchant l’attrapeur adverse de faire de même. 1 seul par équipe. */
public class Attrapeur extends Joueur{
    /**
     * constructeur d'attrapeur
     */
    public Attrapeur(String nom){
        super(nom);
    }
    
    /**
     * méthode qui permet de tester si l'attrapeur arrive à attraper le vif d'or
     * @param a equipe dont fait partie l'attrapeur 
     */
    public boolean attrape(Equipe a){
        int proba = (int)(Math.random()*100 + 1);
        System.out.println(nom+" est tres proche du vif d'or ! Il semble tenter de l'attraper..!");
        if(proba <= 20){
            a.comptePoints(150);
            System.out.println(nom+" a attrape le vif d'or !");
            return true;
        }
        else{
            System.out.println("Le vif d'or est trop vif, dommage, il va retenter sa chance !");
            return false;
        }
    }
}
