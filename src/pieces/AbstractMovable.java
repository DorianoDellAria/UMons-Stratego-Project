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
		b.caseBoard[x][y].setContent(null);
	}


}
