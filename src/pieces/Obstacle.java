package pieces;


public class Obstacle extends Piece{
	private String img = "./images/obstacle.png";

	public Obstacle() {
		super(null);
	}

	@Override
	public int getVALUE() {
		return -1;
	}

	@Override
	public String getIMGPath() {
		return img;
	}
}
