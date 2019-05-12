package pieces;


public class Spy extends AbstractMovable implements Movable {
	private final int VALUE=1;
	private String img = "./images/1.png";

	public Spy(Team team){
		super(team);
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

	@Override
	public String getIMGPath(){return this.img;}
}
