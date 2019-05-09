package pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Miner extends AbstractMovable implements Movable{

	private final int VALUE= 3;
	private ImageView img;

	public Miner(Team team){
		super(team);
		try {
			FileInputStream fis = new FileInputStream("./images/3.png");
			Image tmp = new Image(fis);
			this.img = new ImageView(tmp);
			this.img.setFitHeight(45);
			this.img.setPreserveRatio(true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Piece fight(Piece defense) {
		if(defense.getVALUE()==11){
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
