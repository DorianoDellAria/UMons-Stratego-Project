package pieces;


public class Lieutenant extends AbstractMovable implements Movable  {

	private String img = "./images/5.png";

	public Lieutenant(Team team){
		super(team,5);
	}


	@Override
	public String getIMGPath(){return this.img;}
}
