package pieces;


public class Major extends AbstractMovable implements Movable {

	private final int VALUE = 7;
	private String img = "./images/7.png";

	public Major(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}

	@Override
	public String getIMGPath(){return this.img;}
}
