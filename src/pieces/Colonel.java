package pieces;

import javafx.scene.image.ImageView;

public class Colonel extends AbstractMovable implements Movable {

	private final int VALUE = 8;
	ImageView ImgFlag=new ImageView(getClass().getResource("../images/colonel.png").toExternalForm());

	public Colonel(Team team){
		super(team);
	}


	@Override
	public int getVALUE(){
		return this.VALUE;
	}
	public ImageView getIMG(){return this.ImgFlag;}
}
