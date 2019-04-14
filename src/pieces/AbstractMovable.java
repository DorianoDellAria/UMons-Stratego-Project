package pieces;

import board.*;

public abstract class AbstractMovable extends Piece implements Movable {

	public AbstractMovable(Team team){
		super(team);
	}


	@Override
	public void move( int x1, int y1, int x2, int y2){
		if( Board.caseBoard[x2][y2].getContent()==null || (Board.caseBoard[x1][y1].getContent().team!=Board.caseBoard[x2][y2].getContent().team && Board.caseBoard[x2][y2].getContent().team!=null )) {
			if ((x1 == x2 && Math.abs(y1 - y2) == 1) || (y1 == y2 && Math.abs(x1 - x2) == 1)) {
				if (Board.caseBoard[x2][y2].getContent() == null) {
					Board.caseBoard[x2][y2].setContent(this);
				} else {
					Board.caseBoard[x2][y2].setContent(this.fight(Board.caseBoard[x2][y2].getContent()));
				}
				Board.caseBoard[x1][y1].setContent(null);
			}
		}
	}

}
