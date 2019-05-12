package pieces;


public class Bomb extends Piece {

	protected final int VALUE = 11;
	private String img = "./images/11.png";

	public Bomb(Team team){
		super(team);

	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}

	@Override
	public String getIMGPath(){return this.img;}
}
