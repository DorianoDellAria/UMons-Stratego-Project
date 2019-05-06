package pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Marshal extends AbstractMovable implements Movable {

	private final int VALUE = 10;
	private ImageView img;

	public Marshal(Team team){
		super(team);
		try {
			FileInputStream fis = new FileInputStream("./images/marshal.png");
			Image tmp = new Image(fis);
			this.img = new ImageView(tmp);
			this.img.setFitHeight(45);
			this.img.setPreserveRatio(true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}

	@Override
	public ImageView getIMG(){return this.img;}

}
