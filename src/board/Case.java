package board;
import pieces.*;

public class Case {
    private Piece content;
    public final int x;
    public final int y;

    public Case (Piece content, int x, int y){
        this.content=content;
        this.x=x;
        this.y=y;
    }

    public Piece getContent (){
        return this.content;
    }

    public void setContent (Piece p){
        this.content=p;
    }

    public void moveContent(Board b,Direction d){
        if(content!=null && content instanceof AbstractMovable){
            ((AbstractMovable)this.content).move(b,this.x,this.y,d);
        }
    }
}
