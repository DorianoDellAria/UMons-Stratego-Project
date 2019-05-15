package board;

import javafx.scene.layout.GridPane;
import pieces.Obstacle;

/**
 * La classe Board est la classe qui contient le plateau du jeu.<br>
 * La variable booléene isClicked est utile pour le déplacement, le déplacement d'une pièce est en 2 temps, elle permet de savoir
 * dans quelle phase de déplacement on se trouve.<br>
 * Les variables xBuffer et yBuffer servent également au déplacement, elles contiennent la position de départ d'une pièce qui sera utilisé
 * dans la méthode move.<br>
 * La classe hérite de GridPane de javafx
 */
public class Board extends GridPane {

    public static Case [][] caseBoard =new Case[10][10];
    public static boolean isClicked = false;
    public static int xBuffer;
    public static int yBuffer;

    /**
     * Constructeur du plateau. Le plateau est composé d'un tableau de Case à 2 dimension.
     * le constructeur positionne également les obstacles au milieu du plateau
     */
    public Board(){
        for(int i =0;i<caseBoard.length;i++){
            for(int j=0;j<caseBoard[0].length;j++){
                Case tmp=new Case(null,i,j);
                caseBoard[i][j]=tmp;
                this.add(tmp,i,j);
            }
        }
        this.caseBoard[2][4].setContent(new Obstacle());
        this.caseBoard[3][4].setContent(new Obstacle());
        this.caseBoard[6][4].setContent(new Obstacle());
        this.caseBoard[7][4].setContent(new Obstacle());
        this.caseBoard[2][5].setContent(new Obstacle());
        this.caseBoard[3][5].setContent(new Obstacle());
        this.caseBoard[6][5].setContent(new Obstacle());
        this.caseBoard[7][5].setContent(new Obstacle());
    }

    /**
     * La méthode cleanBoard vide les pièces du plateau
     */
    public static void cleanBoard(){
        for(int i = 0 ; i<caseBoard.length;i++){
            for(int j  = 0; j < caseBoard[0].length ; j++){
                caseBoard[i][j].setContent(null);
            }
        }
		caseBoard[2][4].setContent(new Obstacle());
		caseBoard[3][4].setContent(new Obstacle());
		caseBoard[6][4].setContent(new Obstacle());
		caseBoard[7][4].setContent(new Obstacle());
		caseBoard[2][5].setContent(new Obstacle());
		caseBoard[3][5].setContent(new Obstacle());
		caseBoard[6][5].setContent(new Obstacle());
		caseBoard[7][5].setContent(new Obstacle());
    }


    /**
     * méthode d'affichage du plateau en console.
     */
    public void display() {                 //Fonction d'affichage console pour debug
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("|");
                if(caseBoard[i][j].getContent()!=null)
                    System.out.print(caseBoard[i][j].getContent().getIMGPath());
                else
                    System.out.print("null");
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
