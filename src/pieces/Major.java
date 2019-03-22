package pieces;

public class Major extends AbstractMovable implements Movable {

	private final int VALUE = 7;

	public Major(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
}
