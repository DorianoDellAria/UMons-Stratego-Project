package pieces;


public class Miner extends AbstractMovable implements Movable{

	private final int VALUE= 3;
	private String img = "./images/3.png";

	public Miner(Team team){
		super(team);
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

	@Override
	public String getIMGPath(){return this.img;}
}
