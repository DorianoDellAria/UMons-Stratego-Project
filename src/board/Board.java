package board;

import javafx.scene.layout.GridPane;
import pieces.Obstacle;

public class Board extends GridPane {

    public static Case [][] caseBoard =new Case[10][10];
    public static Boolean isClicked = false;
    public static int xBuffer;
    public static int yBuffer;

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


    public void display() {                 //Fonction d'affichage console pour debug
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("|");
                if(caseBoard[i][j].getContent()!=null)
                    System.out.print(caseBoard[i][j].getContent().getIMG());
                else
                    System.out.print("null");
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
