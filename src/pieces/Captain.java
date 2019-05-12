package pieces;


public class Captain extends AbstractMovable implements Movable {

	private final int VALUE = 6;
	private String img = "./images/6.png";

	public Captain(Team team){
		super(team);

	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}

	@Override
	public String getIMGPath(){return this.img;}
}
