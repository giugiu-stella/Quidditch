public class Public extends Personne {
    
    private double puissance;

    /**
     * constructeur d'un public
     */
    public Public() {
        puissance = 75;
    }

    /**
     * méthode qui permet au spectateur d'encourager son équipe passée en argument
     * un encouragement assez fort remonte le moral (et donc l'energie) de son
     * equipe !
     * 
     * @param a
     */
    public void encourager(Equipe a) {
        int proba = (int)(Math.random() * 100);
        if (proba > puissance) {
            System.out.println("Le public est endiable ! Youhou ! Allez "+a.nom+ " !!!!");
            for (Joueur j : a.compo){
                j.ajoutEnergie(1);
            }
        }
    }
}
