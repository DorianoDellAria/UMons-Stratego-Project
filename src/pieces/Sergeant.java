package pieces;


public class Sergeant extends AbstractMovable implements Movable {

	private String img = "./images/4.png";

	public Sergeant(Team team){
		super(team,4);
	}


	@Override
	public String getIMGPath(){return this.img;}
}
