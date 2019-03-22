package board;

import pieces.*;

public class Board {
    public Case [][] caseBoard =new Case[10][10];

    public Board(){
        for(int i =0;i<caseBoard.length;i++){
            for(int j=0;j<caseBoard[0].length;j++){
                caseBoard[i][j]=new Case(null,i,j);
            }
        }
    }


    public void display() {                 //Fonction d'affichage console pour debug
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("|");
                if(caseBoard[i][j].getContent()!=null)
                    System.out.print(caseBoard[i][j].getContent().getVALUE());
                else
                    System.out.print("null");
            }
            System.out.print("|");
            System.out.println(" ");
        }
    }
}
