package pieces;


public class Captain extends AbstractMovable implements Movable {

	private String img = "./images/6.png";

	public Captain(Team team){
		super(team,6);

	}

	@Override
	public String getIMGPath(){return this.img;}
}
