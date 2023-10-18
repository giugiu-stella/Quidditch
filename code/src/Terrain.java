import java.util.ArrayList;

public class Terrain {
    private final int longMax;
    private final int largMax;
    private String[][] terr;
    private static final Terrain instance = new Terrain();

    /**
     * pour simplifier l'affichage et etre sur que le terrain
     * rentre dans la console, on fixe les dimensions a 
     * 75x25 (Le saviez-vous ? a l'origine, un terrain de quidditch est de 
     * dimensions environ 152x55)
     */
    private Terrain() {
        largMax = 15;
        longMax = 70;
        terr = new String[largMax][longMax];
    }

    /**
     * @return longMax
     */
    public int getLongMax(){
        return longMax;
    }

    /**
     * 
     * @return largMax
     */
    public int getLargMax(){
        return largMax;
    }
    
    /**
     * 
     * @return l'instance de terrain, qui est notre singleton
     */
    public static Terrain getInstance(){
        return instance;
    }

    /**
     * initialisation des cases du terrain a " " : le terrain est
     * vide.
     */
    public void initTerrain(){
        for (int j=0;j<largMax;j++){
            for (int i=0;i<longMax;i++){
                terr[j][i] = " ";
            }
        }
        //on place les buts :
        terr[largMax/3][0] = "O";       terr[largMax/3][longMax-1] = "O"; 
        terr[(int)largMax/2][0] = "O";  terr[(int)largMax/2][longMax-1] = "O";
        terr[2*largMax/3-1][0] = "O";   terr[2*largMax/3-1][longMax-1] = "O";
    }

    /**
     * place les joueurs, et les balles sur le terrain. 
     * @param equipe1
     * @param equipe2
     * @param vo
     * @param s
     */
    public void placerSurTerrain(ArrayList<Joueur> equipe1, ArrayList<Joueur> equipe2, VifDOr vo, Souafle s){
        for (Joueur j1 : equipe1){
           if(terr[j1.getX()][j1.getY()] != " "){
            terr[j1.getX()][j1.getY()] = "P";
           }
           else{
                terr[j1.getX()][j1.getY()] = "1";
           }
        }
        for (Joueur j2 : equipe2){
            if (terr[j2.getX()][j2.getY()] == "1"){
                terr[j2.getX()][j2.getY()] = "3";
            }
            else {
                if(terr[j2.getX()][j2.getY()] == "P"){
                    terr[j2.getX()][j2.getY()] = "4";
                    System.out.print("yes");
                }
                else{
                    terr[j2.getX()][j2.getY()] = "2";
                }
            }
        }
        terr[vo.getX()][vo.getY()] = "*";
        if(terr[s.getX()][s.getY()]=="P"||terr[s.getX()][s.getY()]=="3"|| terr[s.getX()][s.getY()]=="4"){
            terr[s.getX()][s.getY()] = "A";
            System.out.print("no");
        }
        else{
            terr[s.getX()][s.getY()] = "S"; //si un joueur l'a dans les mains, sa position est indiquee par S aussi.
        }
    }
    public void suppTerrain(){
        for (int j=0;j<largMax;j++){
            for (int i=0;i<longMax;i++){
              
                terr[j][i]=" ";
                
            }
            
        }
    }
   
    /**
     * 
     * affiche le terrain et la position des joueurs et des buts
     */
    public void afficheTerrain(){
        System.out.print("+");
        System.out.print("-".repeat(longMax));
        System.out.println("+");
        for (int j=0;j<largMax;j++){
            System.out.print("|");
            for (int i=0;i<longMax;i++){
                System.out.print(terr[j][i]);
            }
            System.out.println("|");
        }
        System.out.print("+");
        System.out.print("-".repeat(longMax));
        System.out.println("+");
    }
}
