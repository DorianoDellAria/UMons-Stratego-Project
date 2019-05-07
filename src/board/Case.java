package board;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pieces.*;

public class Case extends StackPane {

    private Piece content;
    public final int x;
    public final int y;


    public Case (Piece content, int x, int y){
        Rectangle rectangle = new Rectangle(70,50);
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
                    ((Movable) Board.caseBoard[Board.xBuffer][Board.yBuffer].getContent()).move(Board.xBuffer, Board.yBuffer, this.x, this.y);
                    Board.isClicked = false;
                    Main.nbCoup++;
                    Main.checkGameOver();
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
            Rectangle rec = new Rectangle(70,50);
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
            ImageView tmp = this.content.getIMG();
            this.getChildren().addAll(rec,tmp);

        }
        else{
            this.getChildren().clear();
            Rectangle rec = new Rectangle(70,50);
            rec.setFill(null);
            rec.setStroke(Color.BLACK);
            this.getChildren().add(rec);
        }


    }


}
