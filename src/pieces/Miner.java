package pieces;

public class Miner extends Piece implements Movable{

	protected final int VALUE= 3;

	public Miner(Team team){
		super(team);
	}

	@Override
	public void move(Direction direction) {

	}

	@Override
	public Piece fight(Piece defense) {
		if(defense.getVALUE()==11){
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
