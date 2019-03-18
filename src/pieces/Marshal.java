package pieces;

public class Marshal extends Piece implements Movable {

	protected final int VALUE = 10;

	public Marshal(Team team){
		super(team);
	}

	@Override
	public void move(Direction direction) {

	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
}
