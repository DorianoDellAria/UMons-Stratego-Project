package pieces;


public class Flag extends Piece{
	private String img = "./images/0.png";

	public Flag(Team team){
		super(team,0);
	}


	@Override
	public String getIMGPath(){return this.img;}

}

