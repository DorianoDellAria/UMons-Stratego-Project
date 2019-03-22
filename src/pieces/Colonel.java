package pieces;

public class Colonel extends AbstractMovable implements Movable {

	private final int VALUE = 8;

	public Colonel(Team team){
		super(team);
	}


	@Override
	public int getVALUE(){
		return this.VALUE;
	}
}
