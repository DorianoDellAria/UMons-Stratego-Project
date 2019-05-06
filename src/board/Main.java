package board;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pieces.Flag;
import pieces.Team;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Main extends Application {

	public static int nbCoup=0;
	public static boolean isGameStarted = false;



	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage){
		BorderPane root = new BorderPane();
		primaryStage.setScene(new Scene(root,900,610));
		primaryStage.setTitle("Stratego");

		Board board = new Board();


		MyMenuBarre menu=new MyMenuBarre();

		SelectionPanel select = new SelectionPanel();


		root.setCenter(board);
		root.setBottom(select);
		root.setTop(menu);
		try{
			FileInputStream fis  = new FileInputStream("./images/stratego.png");
			Image img =new Image(fis);
			primaryStage.getIcons().add(img);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
