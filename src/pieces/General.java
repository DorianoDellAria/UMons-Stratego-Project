package pieces;

public class General extends Piece implements Movable {

	protected final int VALUE = 9;

	public General(Team team){
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
