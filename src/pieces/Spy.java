package pieces;

import javafx.scene.image.ImageView;

public class Spy extends AbstractMovable implements Movable {
	private final int VALUE=1;
	private ImageView ImgFlag=new ImageView(getClass().getResource("../images/spy.jpg").toExternalForm());

	public Spy(Team team){
		super(team);
	}

	@Override
	public Piece fight(Piece defense) {
		if(defense.getVALUE()==10){
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
	public ImageView getIMG(){return this.ImgFlag;}
}
