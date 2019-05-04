package pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Spy extends AbstractMovable implements Movable {
	private final int VALUE=1;
	private ImageView img;

	public Spy(Team team){
		super(team);
		try {
			FileInputStream fis = new FileInputStream("./images/spy.jpg");
			Image tmp = new Image(fis);
			this.img = new ImageView(tmp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Piece fight(Piece defense) {
		if(defense.getVALUE()==10){
			return this;
		}
		else{
			return super.fight(defense);
		}
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}

	@Override
	public ImageView getIMG(){return this.img;}
}
