package pieces;

import javafx.scene.image.ImageView;

public class Obstacle extends Piece{


	public Obstacle() {
		super(null);
	}

	@Override
	public int getVALUE() {
		return -1;
	}

	@Override
	public ImageView getIMG() {
		 final ImageView ImgFlag=new ImageView(getClass().getResource("../images/obstacle.jpg").toExternalForm());
		return ImgFlag;
	}
}
