package pieces;


public class Major extends AbstractMovable implements Movable {

	private String img = "./images/7.png";

	public Major(Team team){
		super(team,7);
	}


	@Override
	public String getIMGPath(){return this.img;}
}
