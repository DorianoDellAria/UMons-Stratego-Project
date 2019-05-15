package pieces;


public class Colonel extends AbstractMovable implements Movable {

	private String img ="./images/8.png";

	public Colonel(Team team){
		super(team,8);
	}



	@Override
	public String getIMGPath(){return this.img;}
}
