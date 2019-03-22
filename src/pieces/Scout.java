package pieces;

import board.*;

public class Scout extends AbstractMovable implements Movable{
	private final int VALUE=2;

	public Scout(Team team){
		super(team);
	}



	public void move(Board b,int x, int y,Direction direction, int distance) { //pas bon a refaire
		for(int i=0;i< distance;i++){
			super.move(b,x,y,direction);
		}
	}


	@Override
	public int getVALUE(){
		return this.VALUE;
	}
}
