package pieces;

import javafx.scene.image.ImageView;

public abstract class Piece{
	public final Team team;

	public Piece(Team team){
		this.team=team;
	}

	public Piece fight(Piece defense){
		if (this.getVALUE()==defense.getVALUE()){
			return null;
		}
		else if(this.getVALUE()<defense.getVALUE()){
			return defense;
		}
		else{
			return this;
		}
	}

	public abstract int getVALUE();
	public abstract ImageView getIMG();
}
