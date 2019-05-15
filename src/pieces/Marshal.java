package pieces;


public class Marshal extends AbstractMovable implements Movable {

	private String img = "./images/10.png";

	public Marshal(Team team){
		super(team,10);
	}


	@Override
	public String getIMGPath(){return this.img;}

}
