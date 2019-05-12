package pieces;


public class Colonel extends AbstractMovable implements Movable {

	private final int VALUE = 8;
	private String img ="./images/8.png";

	public Colonel(Team team){
		super(team);
	}


	@Override
	public int getVALUE(){
		return this.VALUE;
	}

	@Override
	public String getIMGPath(){return this.img;}
}
