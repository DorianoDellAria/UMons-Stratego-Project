package pieces;

public class Sergeant extends Piece implements Movable {

	protected final int VALUE = 4;

	public Sergeant(Team team){
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
