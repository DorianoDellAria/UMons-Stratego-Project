package pieces;

import javafx.scene.image.ImageView;

public class Miner extends AbstractMovable implements Movable{

	private final int VALUE= 3;
	ImageView ImgMiner=new ImageView(getClass().getResource("../images/miner.png").toExternalForm());

	public Miner(Team team){
		super(team);
	}

	@Override
	public Piece fight(Piece defense) {
		if(defense.getVALUE()==11){
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
	public ImageView getIMG(){return this.ImgMiner;}
}
