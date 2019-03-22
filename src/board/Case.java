package board;
import pieces.*;

public class Case {
    private Piece content;

    public Case (Piece content){
        this.content=content;
    }

    public Piece getContent (){
        return this.content;
    }

    public void setContent (Piece p){
        this.content=p;
    }
}
