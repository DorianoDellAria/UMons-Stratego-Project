package pieces;

import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Piece implements Serializable {
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
	public abstract String getIMGPath();

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeObject(team);
	}





}
