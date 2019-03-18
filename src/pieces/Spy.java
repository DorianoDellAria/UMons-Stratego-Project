package pieces;

public class Spy extends Piece implements Movable {
	protected final int VALUE=1;

	public Spy(Team team){
		super(team);
	}


	@Override
	public void move(Direction direction) {

	}

	@Override
	public Piece fight(Piece defense) {
		if(defense.getVALUE()==10){
			return this;
		}
		else{
			return super.fight(defense);
		}
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
}
