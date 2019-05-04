package pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Colonel extends AbstractMovable implements Movable {

	private final int VALUE = 8;
	private ImageView img;

	public Colonel(Team team){
		super(team);
		try {
			FileInputStream fis = new FileInputStream("./images/colonel.png");
			Image tmp = new Image(fis);
			this.img = new ImageView(tmp);
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
