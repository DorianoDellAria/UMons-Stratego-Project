package board;

import javafx.scene.layout.GridPane;

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
            System.out.println("");
        }
    }
}
