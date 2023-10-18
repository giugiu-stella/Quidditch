import java.util.ArrayList;

public class Match {
    private static int nbParties = 0;
    private Equipe team1, team2;
    private Souafle s;
    private VifDOr vo;
    private int lignesTerrain, colonnesTerrain;

    /**
     * constructeur de Match, initialise les positions des joueurs et des balles
     * @param team1
     * @param team2
     * @param s
     * @param vo
     * @param lignesTerrain
     * @param colonnesTerrain
     */
    public Match(Equipe team1, Equipe team2, Souafle s, VifDOr vo, int lignesTerrain, int colonnesTerrain){
        nbParties++;
        this.team1 = team1;
        this.team2 = team2;
        this.s = s;
        this.vo = vo;
        this.lignesTerrain = lignesTerrain;
        this.colonnesTerrain = colonnesTerrain;

        //initialisation des positions des joueurs:
        for (Joueur j : team1.compo){
            if (j instanceof Gardien){
                j.seDeplace((int)(lignesTerrain/2),3);
            }
            else {
                j.seDeplace((int)(Math.random()*lignesTerrain), (int)(Math.random()*(colonnesTerrain/2-5)+5));
            }
        }
        for (Joueur j : team2.compo){
            if (j instanceof Gardien){
                j.seDeplace((int)(lignesTerrain/2),colonnesTerrain-4);
            }
            else {
                j.seDeplace((int)(Math.random()*lignesTerrain), (int)(Math.random()*(colonnesTerrain/2-5)+colonnesTerrain/2));
            }
        }
        //au signal, les balles sont lancees au niveau de la ligne mediane du terrain.
        s.seDeplace((int)(lignesTerrain/2),(int)(colonnesTerrain/2));
        vo.seDeplace((int)(lignesTerrain/2),(int)(colonnesTerrain/2));
    }

    /**
     * constructeur de clone d'un match, pour ne pas avoir a reconstituer les equipes
     */
    public Match clone(){
        return new Match(team1,team2,s,vo,lignesTerrain,colonnesTerrain);
    }

    /**
     * affichage du debut d'un match
     */
    public void annonceMatch(){
        System.out.println("Match no "+nbParties+" :");
        System.out.println(team1.nom+" vs "+team2.nom+"\n");
        System.out.println(team1.toString()+"\n"+team2.toString()+"\n");
        System.out.println("A vos marques... Prets... BROOMS UP !");
    }

    /**
     * deplace chaque element deplacable (qui implements surTerrain)
     * @param vo
     * @param s
     * @param t
     */
    public void bougerTousElements(VifDOr vo, Souafle s, Terrain t){
        ArrayList<SurTerrain> elements = new ArrayList<SurTerrain>();
        elements.addAll(team1.compo);   elements.addAll(team2.compo);  
        elements.add(vo);   elements.add(s);
        for (Object o : elements){
            if (o instanceof VifDOr){
                ((VifDOr) o).seDeplace(t);
            }
            if (o instanceof Attrapeur){
                Equipe eqGagnante;
                if (team1.compo.contains(o)){
                    eqGagnante = team1;
                }
                else {
                    eqGagnante = team2;
                }
                if (((Attrapeur) o).distanceTo(vo.getX(), vo.getY()) <= 5){
                    if (((Attrapeur) o).attrape(eqGagnante)){
                        vo.estAttrape();
                        break;
                    }
                }
            }
            if (o instanceof Poursuiveur){
                if (((Poursuiveur) o).possedeSouafle()){
                    int alea = (int)(Math.random()*2);
                    if (alea == 0){ //le joueur choisit une fois sur 2 de garder le souafle
                        ((Poursuiveur) o).passe(s,t);
                    }
                }
                else {
                    ((Poursuiveur) o).seDeplace(s.getX(),s.getY());
                    ((Poursuiveur) o).attrapeSouafle(s);
                }
            }
        }
    }

    /** pour les poursuiveurs de chaque equipe, on regarde lequel
     * possede le souafle et si il est assez proche d'un but ennemi 
     * pour tirer 
     */
    public void but(Terrain t){
        ArrayList<Poursuiveur> listChaser1 = new ArrayList<Poursuiveur>();
        Gardien gard1 = (Gardien) team1.compo.get(4);
        for (Joueur j1 : team1.compo){
            if (j1 instanceof Poursuiveur){
                listChaser1.add((Poursuiveur) j1);
            }
        }
        ArrayList<Poursuiveur> listChaser2 = new ArrayList<Poursuiveur>();
        Gardien gard2 = (Gardien) team2.compo.get(4);
        for (Joueur j2 : team2.compo){
            if (j2 instanceof Poursuiveur){
                listChaser2.add((Poursuiveur) j2);
            }
        }
        for (Poursuiveur p : listChaser1){
            if (p.distanceTo(lignesTerrain/2, colonnesTerrain-1) <= 10 && p.possedeSouafle()){
                p.tirAuBut(gard2.defense(), team1);
                break;
            }
        }
        for (Poursuiveur p : listChaser2){
            if (p.distanceTo(lignesTerrain/2, 0) <= 10 && p.possedeSouafle()){
                p.tirAuBut(gard1.defense(), team2);
                break;
            }
        }
    }

    /**
     * affiche les scores des deux equipes et determine le gagnant
     */
    public void score(){
        System.out.println("Resultat du match :\n");
        System.out.println("Equipe "+team1.nom+" : "+team1.getPoints()+" points\n");
        System.out.println("Equipe "+team2.nom+" : "+team2.getPoints()+" points\n");
        if (team1.getPoints()>team2.getPoints()){
            System.out.println(team1.nom+" l'emporte !");
        }
        else {
            System.out.println(team2.nom+" l'emporte !");
        }
    }
}
