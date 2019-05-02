package board;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pieces.*;


public class Main extends Application {

	public static int nbCoup=0;
	public static boolean isGameStarted = false;



	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage){
		BorderPane root = new BorderPane();
		primaryStage.setScene(new Scene(root,700,500));
		primaryStage.setTitle("Stratego");

		Board board = new Board();
		Major m =new Major(Team.Blue);
		Scout s = new Scout(Team.Red);
		Bomb b =new Bomb(Team.Red);
		Board.caseBoard[5][5].setContent(m);
		Board.caseBoard[6][6].setContent(s);
		Board.caseBoard[1][6].setContent(b);
		Board.caseBoard[0][0].setContent(new Miner(Team.Red));
		Board.caseBoard[0][1].setContent(new Miner(Team.Blue));
		Board.caseBoard[0][6].setContent(new Obstacle());
		Board.caseBoard[0][9].setContent(new Flag(Team.Blue));
		Board.caseBoard[0][8].setContent(new Flag(Team.Red));
		Board.caseBoard[9][8].setContent(new Lieutenant(Team.Red));

		MyMenuBarre menu=new MyMenuBarre();

		SelectionPanel select = new SelectionPanel();


		root.setCenter(board);
		root.setBottom(select);
		root.setTop(menu);
		primaryStage.getIcons().add(new Image(getClass().getResource("../images/stratego.png").toExternalForm()));
		primaryStage.show();
	}

	public static void checkGameOver(){   //à optimiser ex: retenir la place des flags pour eviter de faire un double for
		Boolean redFlag=false;
		Boolean blueFlag=false;
		for(int i=0 ;i<10 ; i++){
			for(int j = 0 ; j<10 ; j++){
				if(Board.caseBoard[i][j].getContent() instanceof Flag && Board.caseBoard[i][j].getContent().team==Team.Blue)
					blueFlag=true;
				if(Board.caseBoard[i][j].getContent() instanceof Flag && Board.caseBoard[i][j].getContent().team==Team.Red)
					redFlag=true;
			}

		}
		if (blueFlag && redFlag)
			System.out.println("ok");
		else
			System.out.println("gameOver");
	}
}
