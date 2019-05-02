package pieces;

import javafx.scene.image.ImageView;

public class Marshal extends AbstractMovable implements Movable {

	private final int VALUE = 10;
	private ImageView ImgMarshal=new ImageView(getClass().getResource("../images/marshal.png").toExternalForm());

	public Marshal(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
	public ImageView getIMG(){return this.ImgMarshal;}

}
