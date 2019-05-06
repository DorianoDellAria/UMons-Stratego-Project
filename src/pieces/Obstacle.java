package pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Obstacle extends Piece{
	private ImageView img;

	public Obstacle() {
		super(null);
		try {
			FileInputStream fis = new FileInputStream("./images/obstacle.png");
			Image tmp = new Image(fis);
			this.img = new ImageView(tmp);
			this.img.setFitWidth(65);
			this.img.setPreserveRatio(true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getVALUE() {
		return -1;
	}

	@Override
	public ImageView getIMG() {
		return img;
	}
}
