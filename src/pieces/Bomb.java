package pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Bomb extends Piece {

	protected final int VALUE = 11;
	private ImageView img;

	public Bomb(Team team){
		super(team);
		try{
			FileInputStream fis = new FileInputStream("./images/bomb.jpg");
			Image tmp = new Image(fis);
			this.img = new ImageView(tmp);
			this.img.setFitHeight(45);
			this.img.setPreserveRatio(true);
		}catch(FileNotFoundException e){
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
