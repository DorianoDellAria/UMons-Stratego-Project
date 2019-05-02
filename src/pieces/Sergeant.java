package pieces;

import javafx.scene.image.ImageView;

public class Sergeant extends AbstractMovable implements Movable {

	private final int VALUE = 4;
	ImageView ImgFlag=new ImageView(getClass().getResource("../images/sergeant.png").toExternalForm());

	public Sergeant(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
	public ImageView getIMG(){return this.ImgFlag;}
}
