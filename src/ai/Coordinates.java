package ai;

import java.io.Serializable;

public class Coordinates implements Serializable {

	public int x;
	public int y;

	public Coordinates(int x, int y){
		this.x=x;
		this.y=y;
	}

	@Override
	public String toString(){
		return String.format("( %d , %d )", this.x, this.y);
	}

}
