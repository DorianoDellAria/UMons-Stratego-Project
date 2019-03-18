package pieces;

public class Colonel extends Piece implements Movable {

	protected final int VALUE = 8;

	public Colonel(Team team){
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
