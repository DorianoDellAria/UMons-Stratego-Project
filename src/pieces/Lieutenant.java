package pieces;

public class Lieutenant extends Piece implements Movable {

	protected final int VALUE = 5;

	public Lieutenant(Team team){
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
