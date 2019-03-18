package pieces;

public class Scout extends Piece implements Movable{
	protected final int VALUE=2;

	public Scout(Team team){
		super(team);
	}

	@Override
	public void move(Direction direction) {

	}

	public void move(Direction direction, int range){
		for(int i=0;i<range;i++){
			move(direction);
		}
	}

	@Override
	public int getVALUE(){
		return this.VALUE;
	}
}
