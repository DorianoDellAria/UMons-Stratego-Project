package board;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pieces.*;


public class Main extends Application {

	public static int nbCoup=0;



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


		Group groupe2=new Group();
		Group groupe=new Group();
		Button B1=new Button("1");
		Button B2=new Button("2");B2.setLayoutY(30);
		Button B3=new Button("3");B3.setLayoutY(60);
		Button B4=new Button("1");
		Button B5=new Button("2");B5.setLayoutX(30);
		Button B6=new Button("3");B6.setLayoutX(60);
		groupe.getChildren().addAll(B3,B2,B1);
		groupe2.getChildren().addAll(B6,B5,B4);



		ScrollPane sp =new ScrollPane();
		VBox v =new VBox();
		v.getChildren().add(groupe);
		sp.setContent(v);
		sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		sp.setPrefSize(100,200);
		sp.setMaxWidth(250);
		sp.setMaxHeight(550);


		ScrollPane sp2=new ScrollPane();
		HBox h =new HBox();
		h.getChildren().add(groupe2);
		sp2.setContent(h);
		sp2.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		sp2.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		sp2.setPrefSize(200,100);
		sp2.setMaxWidth(150);
		sp2.setMaxHeight(50);

		MyMenuBarre menu=new MyMenuBarre();



		root.setCenter(board);
		root.setRight(sp);
		root.setBottom(sp2);
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
