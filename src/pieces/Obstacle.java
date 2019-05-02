package pieces;

import javafx.scene.image.ImageView;

public class Obstacle extends Piece{
	private ImageView ImgFlag=new ImageView(getClass().getResource("../images/obstacle.jpg").toExternalForm());

	public Obstacle() {
		super(null);
	}

	@Override
	public int getVALUE() {
		return -1;
	}

	@Override
	public ImageView getIMG() {
		return ImgFlag;
	}
}
