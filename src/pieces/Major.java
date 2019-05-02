package pieces;

import javafx.scene.image.ImageView;

public class Major extends AbstractMovable implements Movable {

	private final int VALUE = 7;
	private ImageView ImgFlag=new ImageView(getClass().getResource("../images/major.png").toExternalForm());

	public Major(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
	public ImageView getIMG(){return this.ImgFlag;}
}
