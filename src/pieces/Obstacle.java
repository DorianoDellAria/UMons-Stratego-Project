package pieces;


public class Obstacle extends Piece{
	private String img = "./images/obstacle.png";

	public Obstacle() {
		super(null,-1);
	}


	@Override
	public String getIMGPath() {
		return img;
	}
}
