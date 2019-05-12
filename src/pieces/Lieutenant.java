package pieces;


public class Lieutenant extends AbstractMovable implements Movable  {

	private final int VALUE = 5;
	private String img = "./images/5.png";

	public Lieutenant(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}

	@Override
	public String getIMGPath(){return this.img;}
}
