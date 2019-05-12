package pieces;


public class Sergeant extends AbstractMovable implements Movable {

	private final int VALUE = 4;
	private String img = "./images/4.png";

	public Sergeant(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}

	@Override
	public String getIMGPath(){return this.img;}
}
