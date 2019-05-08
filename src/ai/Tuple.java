package ai;

public class Tuple {

	public int x;
	public int y;

	public Tuple(int x, int y){
		this.x=x;
		this.y=y;
	}

	@Override
	public String toString(){
		return String.format("( %d , %d )", this.x, this.y);
	}

}
