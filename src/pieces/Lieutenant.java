package pieces;

public class Lieutenant extends AbstractMovable implements Movable  {

	private final int VALUE = 5;

	public Lieutenant(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
}
