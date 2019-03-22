package pieces;


public class Scout extends AbstractMovable implements Movable{
	private final int VALUE=2;

	public Scout(Team team){
		super(team);
	}



	public void move(Direction direction, int distance) {
		for(int i=0;i< distance;i++){
			super.move(direction);
		}
	}


	@Override
	public int getVALUE(){
		return this.VALUE;
	}
}
