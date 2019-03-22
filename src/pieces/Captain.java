package pieces;

public class Captain extends AbstractMovable implements Movable {

	private final int VALUE = 6;

	public Captain(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
}
