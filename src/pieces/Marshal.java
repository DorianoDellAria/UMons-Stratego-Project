package pieces;

public class Marshal extends AbstractMovable implements Movable {

	private final int VALUE = 10;

	public Marshal(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
}
