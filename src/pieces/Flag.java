package pieces;

import javafx.scene.image.ImageView;

public class Flag extends Piece{
	private final int VALUE=0;
	ImageView ImgFlag=new ImageView(getClass().getResource("../images/flag.jpg").toExternalForm());

	public Flag(Team team){
		super(team);
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
	public ImageView getIMG(){return this.ImgFlag;}

}

