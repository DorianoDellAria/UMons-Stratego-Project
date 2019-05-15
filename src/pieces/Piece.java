package pieces;


/**
 * classe parent de toute pièces du jeu
 */
public abstract class Piece  {

	private final String img;
	private final int VALUE;
	public final Team team;

	/**
	 * constructeur
	 * @param team est l'équipe à laquelle appartient la pièce
	 */
	public Piece(Team team, int VALUE, String img){
		this.team=team;
		this.VALUE= VALUE;
		this.img = img;
	}

	/**
	 * méthode de combat entre les pièces
	 * @param defense est la pièce attaquée
	 * @return la pièce vainqueur du combat
	 */
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

	/**
	 * chaque pièce a une certaine valeur
	 * @return le rang de la pièce
	 */
	public int getVALUE(){
		return VALUE;
	}

	/**
	 *
	 * @return le chemin de l'image de la pièce
	 */
	public String getIMGPath(){
		return img;
	}

}
