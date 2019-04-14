package board;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pieces.*;


public class Main extends Application {

	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage){
		BorderPane root = new BorderPane();
		primaryStage.setScene(new Scene(root,600,400));
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



		root.setCenter(board);

		primaryStage.show();
	}
}
