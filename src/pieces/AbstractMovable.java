package pieces;

import board.*;

public abstract class AbstractMovable extends Piece implements Movable {

	public AbstractMovable(Team team){
		super(team);
	}

	@Override
	public void move(Board b, int x, int y, Direction d){
		if (d==Direction.Forward){
			b.caseBoard[x-1][y].setContent(this);
		}
		else if(d==Direction.Backward){
			b.caseBoard[x+1][y].setContent(this);
		}
		else if(d==Direction.Left){
			b.caseBoard[x][y-1].setContent(this);
		}
		else {
			b.caseBoard[x][y+1].setContent(this);
		}
		b.caseBoard[x][y].setContent(null);
	}


}
