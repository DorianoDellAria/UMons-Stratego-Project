package pieces;

public class Captain extends Piece implements Movable {

	private final int VALUE = 6;

	public Captain(Team team){
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
