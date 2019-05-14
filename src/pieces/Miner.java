package pieces;


public class Miner extends AbstractMovable implements Movable{

	private final int VALUE= 3;
	private String img = "./images/3.png";

	public Miner(Team team){
		super(team);
	}

	/**
	 * la méthode fight du démineur est spécialisée afin que le démineurs puisse battre la mine
	 * @param defense est la pièce attaquée
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

	@Override
	public int getVALUE(){
		return this.VALUE;
	}

	@Override
	public String getIMGPath(){return this.img;}
}
