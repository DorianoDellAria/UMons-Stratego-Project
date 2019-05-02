package pieces;

import javafx.scene.image.ImageView;

public class General extends AbstractMovable implements Movable {

	private final int VALUE = 9;
	ImageView ImgFlag=new ImageView(getClass().getResource("../images/general.png").toExternalForm());

	public General(Team team){
		super(team);
	}


	@Override
	public int getVALUE(){
		return this.VALUE;
	}

	public ImageView getIMG(){return this.ImgFlag;}
}
