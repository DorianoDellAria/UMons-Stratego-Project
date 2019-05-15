package pieces;


public class Bomb extends Piece {

	private String img = "./images/11.png";

	public Bomb(Team team){
		super(team,11);

	}


	@Override
	public String getIMGPath(){return this.img;}
}
