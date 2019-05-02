package pieces;

import javafx.scene.image.ImageView;

public class Lieutenant extends AbstractMovable implements Movable  {

	private final int VALUE = 5;
	ImageView ImgFlag=new ImageView(getClass().getResource("../images/lieutenant .png").toExternalForm());

	public Lieutenant(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
	public ImageView getIMG(){return this.ImgFlag;}
}
