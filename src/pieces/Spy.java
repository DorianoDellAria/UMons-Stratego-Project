package pieces;

public class Spy extends Piece implements Movable {
	private int value=1;

	public Spy(Team team){
		super(team);
	}


	@Override
	public void move(Direction direction) {

	}

	@Override
	public Piece fight(Piece defense) {
		return null;
	}
}
