package pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Major extends AbstractMovable implements Movable {

	private final int VALUE = 7;
	private ImageView img ;

	public Major(Team team){
		super(team);
		try {
			FileInputStream fis = new FileInputStream("./images/major.png");
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
