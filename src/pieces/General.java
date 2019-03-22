package pieces;

public class General extends AbstractMovable implements Movable {

	private final int VALUE = 9;

	public General(Team team){
		super(team);
	}


	@Override
	public int getVALUE(){
		return this.VALUE;
	}
}
