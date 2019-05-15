package pieces;


public class General extends AbstractMovable implements Movable {

	private String img = "./images/9.png";

	public General(Team team){
		super(team,9);
	}



	@Override
	public String getIMGPath(){return this.img;}
}
