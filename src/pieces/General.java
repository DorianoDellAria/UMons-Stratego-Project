package pieces;


public class General extends AbstractMovable implements Movable {

	private final int VALUE = 9;
	private String img = "./images/9.png";

	public General(Team team){
		super(team);
	}


	@Override
	public int getVALUE(){
		return this.VALUE;
	}

	@Override
	public String getIMGPath(){return this.img;}
}
