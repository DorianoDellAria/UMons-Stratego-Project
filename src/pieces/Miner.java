package pieces;


public class Miner extends AbstractMovable implements Movable{


	public Miner(Team team){
		super(team,3,"./images/3.png");
	}

	/**
	 * La méthode fight du démineur est spécialisée afin qu'il puisse battre la mine.
	 * @param defense la pièce attaquée
	 * @return la pièce vainqueur du combat
	 */
	@Override
	public Piece fight(Piece defense) {
		if(defense.getVALUE()==11){
			return this;
		}
		else{
			return super.fight(defense);
		}
	}


}
