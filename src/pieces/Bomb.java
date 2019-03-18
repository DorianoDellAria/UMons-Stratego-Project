package pieces;

public class Bomb extends Piece {

	protected final int VALUE = 11;

	public Bomb(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
}
