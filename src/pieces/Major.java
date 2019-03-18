package pieces;

public class Major extends Piece implements Movable {

	protected final int VALUE = 7;

	public Major(Team team){
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
