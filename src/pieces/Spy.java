package pieces;


public class Spy extends AbstractMovable implements Movable {
	private final int VALUE=1;
	private String img = "./images/1.png";

	public Spy(Team team){
		super(team);
	}

	/**
	 * méthode de combat spécifique à l'espion, il peut ainsi vainqure le maréchal
	 * @param defense est la pièce attaquée
	 * @return la pièce vinqueur du combat
	 */
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

	@Override
	public String getIMGPath(){return this.img;}
}
