package pieces;

public class Flag extends Piece{
	private final int VALUE=0;

	public Flag(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}

}

