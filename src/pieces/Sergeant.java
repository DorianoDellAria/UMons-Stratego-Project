package pieces;

public class Sergeant extends AbstractMovable implements Movable {

	private final int VALUE = 4;

	public Sergeant(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
}
