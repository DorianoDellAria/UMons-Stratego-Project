package pieces;


public class Marshal extends AbstractMovable implements Movable {

	private final int VALUE = 10;
	private String img = "./images/10.png";

	public Marshal(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}

	@Override
	public String getIMGPath(){return this.img;}

}
