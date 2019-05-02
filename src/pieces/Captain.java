package pieces;

import javafx.scene.image.ImageView;

public class Captain extends AbstractMovable implements Movable {

	private final int VALUE = 6;
	ImageView ImgFlag=new ImageView(getClass().getResource("../images/captain.png").toExternalForm());

	public Captain(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
	public ImageView getIMG(){return this.ImgFlag;}
}
