package pieces;


public class Spy extends AbstractMovable implements Movable {

	public Spy(Team team){
		super(team,1,"./images/1.png");
	}

	/**
	 * Méthode de combat spécifique à l'espion, servant à vaincre le maréchal.
	 * @param defense est la pièce attaquée
	 * @return la pièce victorieuse du combat
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


}
