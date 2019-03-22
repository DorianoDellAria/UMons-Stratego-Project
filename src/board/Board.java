package board;

public class Board {
    public Case [][] caseBoard = new Case [10][10];

    public void display() {                 //Fonction d'affichage console pour debug
        for (int i = 0; i < 10; i++) {
            System.out.print("|");
            for (int j = 0; j < 10; j++) {
                System.out.print(caseBoard[i][j] + "|");
            }
            System.out.println(" ");
        }
    }
}
