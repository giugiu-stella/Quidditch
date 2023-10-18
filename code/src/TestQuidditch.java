import java.util.ArrayList;

import Exceptions.JoueurBlesseException;
import Exceptions.MagieInterditeException;

public class TestQuidditch {
    public static void main(String[]args) throws JoueurBlesseException, MagieInterditeException {
        Terrain t = Terrain.getInstance();
        
        ArrayList<Joueur> grif = new ArrayList<Joueur>();
        Joueur harry = new Attrapeur("Harry Potter");
        Joueur ron = new Gardien("Ron Weasley");
        grif.add(harry);      
        grif.add(new Poursuiveur("Angelina Johnson"));
        grif.add(new Poursuiveur("Alicia Spinnet"));  
        grif.add(new Poursuiveur("Katie Bell"));
        grif.add(ron);

        ArrayList<Joueur> serp = new ArrayList<Joueur>();
        Joueur drago = new Attrapeur("Drago Malefoy");
        serp.add(drago);     
        serp.add(new Poursuiveur("Graham Montague"));
        serp.add(new Poursuiveur("Adrian Pucey"));    
        serp.add(new Poursuiveur("Cassius Warrington"));
        serp.add(new Gardien("Miles Bletchley"));

        Equipe griffondor = new Equipe("Griffondor",grif);
        Equipe serpentard = new Equipe("Serpentard",serp);
        Souafle s = new Souafle(t);     VifDOr vo = new VifDOr(t);
        Public spectateurs = new Public();

        Match match = new Match(griffondor,serpentard,s,vo,t.getLargMax(),t.getLongMax());
        match.annonceMatch();
        t.initTerrain();
        t.placerSurTerrain(grif, serp, vo, s);
        System.out.println(grif);
        System.out.println(serp);
        System.out.println(vo);
        System.out.println(s);
        t.afficheTerrain();
        
        int i=0;
        while (!vo.attrape && i<10){
            try {
                match.bougerTousElements(vo, s, t);
                t.suppTerrain();
                t.initTerrain();
                System.out.println(grif);
                System.out.println(serp);
                t.placerSurTerrain(grif, serp, vo, s);
                match.but(t);
                double alea = Math.random()*50;
                if (alea <= 25){
                    drago.ensorceleJoueur(harry, 3);    //il n'y a que malefoy qui soit assez mesquin pour tricher !
                }
                if (alea <= 15){
                    spectateurs.ensorceleJoueur(ron,2);
                }
            } catch (MagieInterditeException e1) {
                System.out.println(e1.getMessage());
                griffondor.comptePoints(10);
            } catch (JoueurBlesseException e2) {
                System.out.println(e2.getMessage());
            }
            spectateurs.encourager(griffondor);
            spectateurs.encourager(serpentard);
            
            t.afficheTerrain();
            i++;
        }
        match.score();
    }
}
