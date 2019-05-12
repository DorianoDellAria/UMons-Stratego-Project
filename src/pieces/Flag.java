package pieces;


public class Flag extends Piece{
	private final int VALUE=0;
	private String img = "./images/0.png";

	public Flag(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}

	@Override
	public String getIMGPath(){return this.img;}

}

