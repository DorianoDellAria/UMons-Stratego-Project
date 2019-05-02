package pieces;

import javafx.scene.image.ImageView;

public class Bomb extends Piece {

	protected final int VALUE = 11;
	ImageView ImgFlag=new ImageView(getClass().getResource("../images/bomb.jpg").toExternalForm());

	public Bomb(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
	public ImageView getIMG(){return this.ImgFlag;}
}
