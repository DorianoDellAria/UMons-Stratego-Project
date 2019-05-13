package board;

import ai.AI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pieces.*;

import java.io.FileInputStream;
import java.io.IOException;



public class Main extends Application {

    public static int nbCoup=0;
    public static boolean isGameStarted = false;
    public static Team playerTeam;
    public static AI player2;



    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        BorderPane root = new BorderPane();
        primaryStage.setScene(new Scene(root,1100,800));
        primaryStage.setTitle("Stratego");

        Board board = new Board();



        SelectionPanel select = new SelectionPanel();

        ControlPanel control = new ControlPanel(select);
        MyMenuBarre menu=new MyMenuBarre(control);
        VBox top = new VBox();
        top.getChildren().addAll(menu,control);

        root.setCenter(board);
        root.setBottom(select);
        root.setTop(top);

        try{
            FileInputStream fis  = new FileInputStream("./images/stratego.png");
            try {
                Image img = new Image(fis);
                primaryStage.getIcons().add(img);
            }finally {
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.show();

    }


    public static void checkGameOver() {   //à optimiser ex: retenir la place des flags pour eviter de faire un double for
        boolean redFlag = false;
        boolean blueFlag = false;
        boolean redMiner = false;
        boolean blueMiner = false;
        boolean trappedBlueFlag = false;
        boolean trappedRedFlag = false;
        boolean unblockedBluePiece=false;
        boolean unblockedRedPiece=false;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {


                //drapeau bleu piégé


                if (Board.caseBoard[i][j].getContent() instanceof Flag && Board.caseBoard[i][j].getContent().team == Team.Blue) {
                    blueFlag = true;
                    if (i >= 1 && j >= 1 && i <= 8 && j <= 8) {
                        if (Board.caseBoard[i + 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i - 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j + 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j - 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle) {
                            trappedBlueFlag = true;
                        }
                    }

                    if (i == 0 && j == 0) {
                        if (Board.caseBoard[i + 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j + 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle) {
                            trappedBlueFlag = true;
                        }
                    }

                    if (i >= 1 && j == 0 && i <= 8) {
                        if (Board.caseBoard[i + 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i - 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j + 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle) {
                            trappedBlueFlag = true;
                        }
                    }

                    if (i == 0 && j >= 1 && j <= 8) {
                        if (Board.caseBoard[i + 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j + 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j - 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle) {
                            trappedBlueFlag = true;
                        }
                    }

                    if (i == 9 && j == 9) {
                        if (Board.caseBoard[i - 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j - 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle) {
                            trappedBlueFlag = true;
                        }
                    }

                    if (i == 9 && j <= 8 && j >= 1) {
                        if (Board.caseBoard[i - 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j + 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j - 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle) {
                            trappedBlueFlag = true;
                        }
                    }

                    if (i <= 8 && j == 9 && i >= 1) {
                        if (Board.caseBoard[i + 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i - 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j - 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle) {
                            trappedBlueFlag = true;
                        }
                    }
                }


                //drapeau rouge piégé



                if (Board.caseBoard[i][j].getContent() instanceof Flag && Board.caseBoard[i][j].getContent().team == Team.Red) {
                    redFlag = true;
                    if (i >= 1 && j >= 1 && i <= 8 && j <= 8) {
                        if (Board.caseBoard[i + 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i - 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j + 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j - 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle) {
                            trappedRedFlag = true;
                        }
                    }

                    if (i == 0 && j == 0) {
                        if (Board.caseBoard[i + 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j + 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle) {
                            trappedRedFlag = true;
                        }
                    }

                    if (i >= 1 && j == 0 && i <= 8) {
                        if (Board.caseBoard[i + 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i - 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j + 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle) {
                            trappedRedFlag = true;
                        }
                    }

                    if (i == 0 && j >= 1 && j <= 8) {
                        if (Board.caseBoard[i + 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j + 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j - 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle) {
                            trappedRedFlag = true;
                        }
                    }

                    if (i == 9 && j == 9) {
                        if (Board.caseBoard[i - 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j - 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle) {
                            trappedRedFlag = true;
                        }
                    }

                    if (i == 9 && j <= 8 && j >= 1) {
                        if (Board.caseBoard[i - 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j + 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j - 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle) {
                            trappedRedFlag = true;
                        }
                    }

                    if (i <= 8 && j == 9 && i >= 1) {
                        if (Board.caseBoard[i + 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i - 1][j].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle
                                && Board.caseBoard[i][j - 1].getContent() instanceof Bomb||Board.caseBoard[i + 1][j].getContent()instanceof Obstacle) {
                            trappedRedFlag = true;
                        }
                    }
                }


                //démineur rouge


                if (Board.caseBoard[i][j].getContent() instanceof Miner && Board.caseBoard[i][j].getContent().team == Team.Red)
                    redMiner = true;


                //démineur bleu


                if (Board.caseBoard[i][j].getContent() instanceof Miner && Board.caseBoard[i][j].getContent().team == Team.Blue)
                    blueMiner = true;


                //pieces bleues qui peuvent bouger?


                if (Board.caseBoard[i][j].getContent() instanceof Movable && Board.caseBoard[i][j].getContent().team == Team.Blue)

                    if (i >= 1 && j >= 1 && i <= 8 && j <= 8) {
                        if (!(Board.caseBoard[i + 1][j].getContent() !=null&&(Board.caseBoard[i + 1][j].getContent() instanceof Obstacle||Board.caseBoard[i + 1][j].getContent().team== Team.Blue)
                                && Board.caseBoard[i - 1][j].getContent() !=null&&(Board.caseBoard[i - 1][j].getContent() instanceof Obstacle||Board.caseBoard[i - 1][j].getContent().team== Team.Blue)
                                && Board.caseBoard[i][j + 1].getContent() !=null&&(Board.caseBoard[i][j+1].getContent() instanceof Obstacle||Board.caseBoard[i][j+1].getContent().team== Team.Blue)
                                && Board.caseBoard[i][j - 1].getContent() !=null&&(Board.caseBoard[i][j-1].getContent() instanceof Obstacle||Board.caseBoard[i][j-1].getContent().team==Team.Blue))) {
                            unblockedBluePiece = true;
                        }
                    }

                if (i == 0 && j == 0) {
                    if (!(Board.caseBoard[i + 1][j].getContent() !=null&&(Board.caseBoard[i + 1][j].getContent() instanceof Obstacle||Board.caseBoard[i + 1][j].getContent().team==Team.Blue)
                            && Board.caseBoard[i][j + 1].getContent() !=null&&(Board.caseBoard[i][j+1].getContent() instanceof Obstacle||Board.caseBoard[i  ][j+1].getContent().team==Team.Blue))) {
                        unblockedBluePiece = true;
                    }
                }
                if (i >= 1 && j == 0 && i <= 8) {
                    if (!(Board.caseBoard[i + 1][j].getContent() !=null&&(Board.caseBoard[i + 1][j].getContent() instanceof Obstacle||Board.caseBoard[i + 1][j].getContent().team==Team.Blue)
                            && Board.caseBoard[i - 1][j].getContent() !=null&&(Board.caseBoard[i - 1][j].getContent() instanceof Obstacle||Board.caseBoard[i - 1][j].getContent().team==Team.Blue)
                            && Board.caseBoard[i][j + 1].getContent() !=null&&(Board.caseBoard[i][j+1].getContent() instanceof Obstacle||Board.caseBoard[i][j+1].getContent().team==Team.Blue))) {
                        unblockedBluePiece = true;
                    }
                }

                if (i == 0 && j >= 1 && j <= 8) {
                    if (!(Board.caseBoard[i + 1][j].getContent() !=null&&(Board.caseBoard[i + 1][j].getContent() instanceof Obstacle||Board.caseBoard[i + 1][j].getContent().team==Team.Blue)
                            && Board.caseBoard[i][j + 1].getContent() !=null&&(Board.caseBoard[i][j+1].getContent() instanceof Obstacle||Board.caseBoard[i][j+1].getContent().team==Team.Blue)
                            && Board.caseBoard[i][j - 1].getContent() !=null&&(Board.caseBoard[i][j-1].getContent() instanceof Obstacle||Board.caseBoard[i][j-1].getContent().team==Team.Blue))) {
                        unblockedBluePiece = true;
                    }
                }

                if (i == 9 && j == 9) {
                    if (!(Board.caseBoard[i - 1][j].getContent() !=null&&(Board.caseBoard[i - 1][j].getContent() instanceof Obstacle||Board.caseBoard[i - 1][j].getContent().team==Team.Blue)
                            && Board.caseBoard[i][j - 1].getContent() !=null&&(Board.caseBoard[i][j-1].getContent() instanceof Obstacle||Board.caseBoard[i][j-1].getContent().team==Team.Blue))) {
                        unblockedBluePiece = true;
                    }
                }

                if (i == 9 && j <= 8 && j >= 1) {
                    if (!(Board.caseBoard[i - 1][j].getContent() !=null&&(Board.caseBoard[i - 1][j].getContent() instanceof Obstacle||Board.caseBoard[i - 1][j].getContent().team==Team.Blue)
                            && Board.caseBoard[i][j + 1].getContent() !=null&&(Board.caseBoard[i][j+1].getContent() instanceof Obstacle||Board.caseBoard[i][j+1].getContent().team==Team.Blue)
                            && Board.caseBoard[i][j - 1].getContent() !=null&&(Board.caseBoard[i][j-1].getContent() instanceof Obstacle||Board.caseBoard[i][j-1].getContent().team==Team.Blue))) {
                        unblockedBluePiece = true;
                    }
                }

                if (i <= 8 && j == 9 && i >= 1) {
                    if (!(Board.caseBoard[i + 1][j].getContent() !=null&&(Board.caseBoard[i + 1][j].getContent() instanceof Obstacle||Board.caseBoard[i + 1][j].getContent().team==Team.Blue)
                            && Board.caseBoard[i - 1][j].getContent() !=null&&(Board.caseBoard[i - 1][j].getContent() instanceof Obstacle||Board.caseBoard[i - 1][j].getContent().team==Team.Blue)
                            && Board.caseBoard[i][j - 1].getContent() !=null&&(Board.caseBoard[i][j-1].getContent() instanceof Obstacle||Board.caseBoard[i][j-1].getContent().team==Team.Blue))) {
                        unblockedBluePiece = true;
                    }
                }


                //pièces rouges qui peuvent bouger?



                if (Board.caseBoard[i][j].getContent() instanceof Movable && Board.caseBoard[i][j].getContent().team == Team.Red){
                    if (i >= 1 && j >= 1 && i <= 8 && j <= 8) {
                        if (!(Board.caseBoard[i + 1][j].getContent() !=null&&(Board.caseBoard[i + 1][j].getContent() instanceof Obstacle||Board.caseBoard[i + 1][j].getContent().team==Team.Red)
                                && Board.caseBoard[i - 1][j].getContent() !=null&&(Board.caseBoard[i - 1][j].getContent() instanceof Obstacle||Board.caseBoard[i - 1][j].getContent().team==Team.Red)
                                && Board.caseBoard[i][j + 1].getContent() !=null&&(Board.caseBoard[i][j+1].getContent() instanceof Obstacle||Board.caseBoard[i][j+1].getContent().team==Team.Red)
                                && Board.caseBoard[i][j - 1].getContent() !=null&&(Board.caseBoard[i][j-1].getContent() instanceof Obstacle||Board.caseBoard[i][j-1].getContent().team==Team.Red))) {
                            unblockedRedPiece = true;
                        }
                    }

                    if (i == 0 && j == 0) {
                        if (!(Board.caseBoard[i + 1][j].getContent() !=null&&(Board.caseBoard[i + 1][j].getContent() instanceof Obstacle||Board.caseBoard[i + 1][j].getContent().team==Team.Red)
                                && Board.caseBoard[i][j + 1].getContent() !=null&&(Board.caseBoard[i][j+1].getContent() instanceof Obstacle||Board.caseBoard[i][j+1].getContent().team==Team.Red))) {
                            unblockedRedPiece = true;
                        }
                    }

                    if (i >= 1 && j == 0 && i <= 8) {
                        if (!(Board.caseBoard[i + 1][j].getContent() !=null&&(Board.caseBoard[i + 1][j].getContent() instanceof Obstacle||Board.caseBoard[i + 1][j].getContent().team==Team.Red)
                                && Board.caseBoard[i - 1][j].getContent() !=null&&(Board.caseBoard[i - 1][j].getContent() instanceof Obstacle||Board.caseBoard[i - 1][j].getContent().team==Team.Red)
                                && Board.caseBoard[i][j + 1].getContent() !=null&&(Board.caseBoard[i][j+1].getContent() instanceof Obstacle||Board.caseBoard[i][j+1].getContent().team==Team.Red))) {
                            unblockedRedPiece = true;
                        }
                    }

                    if (i == 0 && j >= 1 && j <= 8) {
                        if (!(Board.caseBoard[i + 1][j].getContent() !=null&&(Board.caseBoard[i + 1][j].getContent() instanceof Obstacle||Board.caseBoard[i + 1][j].getContent().team==Team.Red)
                                && Board.caseBoard[i][j + 1].getContent() !=null&&(Board.caseBoard[i][j+1].getContent() instanceof Obstacle||Board.caseBoard[i][j+1].getContent().team==Team.Red)
                                && Board.caseBoard[i][j - 1].getContent() !=null&&(Board.caseBoard[i][j-1].getContent() instanceof Obstacle||Board.caseBoard[i][j-1].getContent().team==Team.Red))) {
                            unblockedRedPiece = true;
                        }
                    }

                    if (i == 9 && j == 9) {
                        if (!(Board.caseBoard[i - 1][j].getContent() !=null&&(Board.caseBoard[i - 1][j].getContent() instanceof Obstacle||Board.caseBoard[i - 1][j].getContent().team==Team.Red)
                                && Board.caseBoard[i][j - 1].getContent() !=null&&(Board.caseBoard[i][j-1].getContent() instanceof Obstacle||Board.caseBoard[i][j-1].getContent().team==Team.Red))) {
                            unblockedRedPiece = true;
                        }
                    }

                    if (i == 9 && j <= 8 && j >= 1) {
                        if (!(Board.caseBoard[i - 1][j].getContent() !=null&&(Board.caseBoard[i - 1][j].getContent() instanceof Obstacle||Board.caseBoard[i - 1][j].getContent().team==Team.Red)
                                && Board.caseBoard[i][j + 1].getContent() !=null&&(Board.caseBoard[i][j+1].getContent() instanceof Obstacle||Board.caseBoard[i][j+1].getContent().team==Team.Red)
                                && Board.caseBoard[i][j - 1].getContent() !=null&&(Board.caseBoard[i][j-1].getContent() instanceof Obstacle||Board.caseBoard[i][j-1].getContent().team==Team.Red))) {
                            unblockedRedPiece = true;
                        }
                    }

                    if (i <= 8 && j == 9 && i >= 1) {
                        if (!(Board.caseBoard[i + 1][j].getContent() !=null&&(Board.caseBoard[i + 1][j].getContent() instanceof Obstacle||Board.caseBoard[i + 1][j].getContent().team==Team.Red)
                                && Board.caseBoard[i - 1][j].getContent() !=null&&(Board.caseBoard[i - 1][j].getContent() instanceof Obstacle||Board.caseBoard[i - 1][j].getContent().team==Team.Red)
                                && Board.caseBoard[i][j - 1].getContent() !=null&&(Board.caseBoard[i][j-1].getContent() instanceof Obstacle||Board.caseBoard[i][j-1].getContent().team==Team.Red))) {
                            unblockedRedPiece = true;
                        }
                    }
                }
            }
        }
        if (blueFlag && !redFlag){
            new DisplayVictory(Team.Blue);
            isGameStarted=false;}

        if (!blueFlag && redFlag){
            new DisplayVictory(Team.Red);
            isGameStarted=false;}

        if (!redMiner && trappedBlueFlag){
            new DisplayVictory(Team.Blue);
            isGameStarted=false;}

        if (!blueMiner && trappedRedFlag){
            new DisplayVictory(Team.Red);
            isGameStarted=false;}

        if(!unblockedBluePiece){
            new DisplayVictory(Team.Red);
            isGameStarted=false;}

        if(!unblockedRedPiece){
            new DisplayVictory(Team.Blue);
            isGameStarted=false;}

    }
}

