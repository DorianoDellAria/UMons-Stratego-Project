package board;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import pieces.*;

import java.io.*;

public class Case extends StackPane {

    private Piece content;
    public final int x;
    public final int y;
    private boolean isPieceMoved =false;


    public Case (Piece content, int x, int y){
        Rectangle rectangle = new Rectangle(90,60);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(null);
        this.getChildren().add(rectangle);
        this.content=content;
        this.x=x;
        this.y=y;
        this.setOnMouseClicked(event->{
            if(Main.isGameStarted && Main.nbCoup%2==0) {
                if (!Board.isClicked && this.content != null && this.content instanceof Movable && this.content.team==Main.playerTeam) {
                    Board.xBuffer = this.x;
                    Board.yBuffer = this.y;
                    Board.isClicked = true;
                } else if (Board.isClicked && (Board.xBuffer != this.x || Board.yBuffer != this.y)) {
                            if(this.content!=null && this.content.team!=Main.playerTeam && isShowable(Board.xBuffer,Board.yBuffer,this.x,this.y)){
                                this.getChildren().clear();
                                try {
                                    FileInputStream fis = new FileInputStream(this.content.getIMGPath());
                                    try{
                                        Rectangle rec = new Rectangle(90,60);
                                        if (this.content!=null && this.content.team==Team.Red) {
                                            rec.setFill(Color.RED);
                                        }
                                        else if(this.content!=null && this.content.team==Team.Blue){
                                            rec.setFill(Color.LIGHTBLUE);
                                        }
                                        else{
                                            rec.setFill(null);
                                        }
                                        rec.setStroke(Color.BLACK);
                                        Image img =new Image(fis);
                                        ImageView iv = new ImageView(img);
                                        iv.setFitHeight(45);
                                        iv.setPreserveRatio(true);
                                        Board.caseBoard[x][y].getChildren().addAll(rec,iv);
                                    }finally {
                                        fis.close();
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Timeline tl = new Timeline(new KeyFrame(Duration.millis(2000),event1->{
                                    isPieceMoved = ((Movable) Board.caseBoard[Board.xBuffer][Board.yBuffer].getContent()).move(Board.xBuffer, Board.yBuffer, this.x, this.y);
                                }));
                                tl.setCycleCount(1);
                                tl.play();
                                Board.isClicked = false;
                            }
                            else{
                                isPieceMoved = ((Movable) Board.caseBoard[Board.xBuffer][Board.yBuffer].getContent()).move(Board.xBuffer, Board.yBuffer, this.x, this.y);
                                Board.isClicked = false;
                            }
                }
                if(isPieceMoved){
                    Main.nbCoup++;
                    Main.checkGameOver();
                    Main.player2.makeAMove();
                    isPieceMoved=false;
                }
            }
            else{
                if(this.content ==null && this.y >=6 && SelectionPanel.isClicked) {
                    switch (SelectionPanel.rankBuffer) {
                        case 0:
                            this.setContent(new Flag(Main.playerTeam));
                            break;

                        case 1:
                            this.setContent(new Spy(Main.playerTeam));
                            break;

                        case 2:
                            this.setContent(new Scout(Main.playerTeam));
                            break;

                        case 3:
                            this.setContent(new Miner(Main.playerTeam));
                            break;

                        case 4:
                            this.setContent(new Sergeant(Main.playerTeam));
                            break;

                        case 5:
                            this.setContent(new Lieutenant(Main.playerTeam));
                            break;

                        case 6:
                            this.setContent(new Captain(Main.playerTeam));
                            break;

                        case 7:
                            this.setContent(new Major(Main.playerTeam));
                            break;

                        case 8:
                            this.setContent(new Colonel(Main.playerTeam));
                            break;

                        case 9:
                            this.setContent(new General(Main.playerTeam));
                            break;

                        case 10:
                            this.setContent(new Marshal(Main.playerTeam));
                            break;

                        case 11:
                            this.setContent(new Bomb(Main.playerTeam));
                            break;

                        default:
                            System.out.println("erreur");
                            break;
                    }
                    SelectionPanel.rankBuffer=-1;
                    SelectionPanel.isClicked = false;
                }
            }
        });

    }

    public Piece getContent (){
        return this.content;
    }



    public void setContent (Piece p){
        this.content=p;
        if(p!=null) {
            this.getChildren().clear();
            Rectangle rec = new Rectangle(90,60);     //90,60
            if (p.team==Team.Red) {
                rec.setFill(Color.RED);
            }
            else if(p.team==Team.Blue){
                rec.setFill(Color.LIGHTBLUE);
            }
            else{
                rec.setFill(null);
            }
            rec.setStroke(Color.BLACK);
            try{
                FileInputStream fis;
                if(p.team==null || p.team== Main.playerTeam) {
                    fis = new FileInputStream(this.content.getIMGPath());
                }
                else{
                    fis = new FileInputStream("./images/stratego2.png");
                }
                try{
                    Image tmp = new Image(fis);
                    ImageView img = new ImageView(tmp);
                    img.setFitHeight(45);
                    img.setPreserveRatio(true);
                    this.getChildren().addAll(rec, img);
                }finally {
                    fis.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }


        }
        else{
            this.getChildren().clear();
            Rectangle rec = new Rectangle(90,60);
            rec.setFill(null);
            rec.setStroke(Color.BLACK);
            this.getChildren().add(rec);
        }


    }

    private static boolean isShowable(int x1, int y1, int x2, int y2){
        if(Board.caseBoard[x1][y1].getContent() instanceof Scout){
            return ((Scout) Board.caseBoard[x1][y1].getContent()).checkObstacle(x1,y1,x2,y2);
        }
        else{
            if((x1==x2 && Math.abs(y1-y2)==1) || (y1==y2 && Math.abs(x1-x2)==1)){
                return true;
            }
            else{
                return false;
            }
        }
    }

}
