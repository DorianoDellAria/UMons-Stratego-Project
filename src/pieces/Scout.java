package pieces;

import board.*;

public class Scout extends AbstractMovable implements Movable{
	private final int VALUE=2;

	public Scout(Team team){
		super(team);
	}


	@Override
	public void move(int x1, int y1, int x2, int y2) {
		if(Board.caseBoard[x2][y2].getContent()==null || Board.caseBoard[x1][y1].getContent().team!=Board.caseBoard[x2][y2].getContent().team) {
			if (x1 == x2 || y1 == y2) {
				if (Board.caseBoard[x2][y2].getContent() == null) {
					Board.caseBoard[x2][y2].setContent(this);
				} else {
					Board.caseBoard[x2][y2].setContent(this.fight(Board.caseBoard[x2][y2].getContent()));
				}
				Board.caseBoard[x1][y1].setContent(null);
			}
		}
	}


	@Override
	public int getVALUE(){
		return this.VALUE;
	}
}
