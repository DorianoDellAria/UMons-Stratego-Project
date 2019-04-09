package pieces;

import board.*;

public class Scout extends AbstractMovable implements Movable{
	private final int VALUE=2;

	public Scout(Team team){
		super(team);
	}


	@Override
	public void move(int x1, int y1, int x2, int y2) {
		if(x1==x2  || y1==y2){
			Board.caseBoard[x2][y2].setContent(this);
			Board.caseBoard[x1][y1].setContent(null);
		}
	}


	@Override
	public int getVALUE(){
		return this.VALUE;
	}
}
