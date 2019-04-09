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
		Major m =new Major(Team.Red);
		Scout s = new Scout(Team.Red);
		Board.caseBoard[5][5].setContent(m);
		Board.caseBoard[6][6].setContent(s);

		root.setCenter(board);

		primaryStage.show();
	}
}
