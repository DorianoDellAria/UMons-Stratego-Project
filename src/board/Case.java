package board;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import pieces.*;

public class Case extends StackPane {
    private Piece content;
    public final int x;
    public final int y;


    public Case (Piece content, int x, int y){
        Rectangle rectangle = new Rectangle(60,40);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(null);
        this.getChildren().add(rectangle);
        this.content=content;
        this.x=x;
        this.y=y;
        this.setOnMouseClicked(event->{
            if(!Board.isClicked && this.content!=null && this.content instanceof Movable){
                Board.xBuffer=this.x;
                Board.yBuffer=this.y;
                Board.isClicked=true;
            }
            else if(Board.isClicked && (Board.xBuffer != this.x || Board.yBuffer != this.y)){
                ((Movable)Board.caseBoard[Board.xBuffer][Board.yBuffer].getContent()).move(Board.xBuffer, Board.yBuffer, this.x, this.y);
                Board.isClicked=false;
            }
        });

    }

    public Piece getContent (){
        return this.content;
    }

    public void setContent (Piece p){
        this.content=p;
        if(p!=null) {
            int tmp = this.content.getVALUE();
            Text txt = new Text(Integer.toString(tmp));
            this.getChildren().add(txt);
        }
        else{
            this.getChildren().clear();
            Rectangle rec = new Rectangle(60,40);
            rec.setFill(null);
            rec.setStroke(Color.BLACK);
            this.getChildren().add(rec);
        }


    }


}
