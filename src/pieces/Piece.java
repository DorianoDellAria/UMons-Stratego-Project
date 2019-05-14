package pieces;


/**
 * classe parent de toute pièces du jeu
 */
public abstract class Piece  {
	public final Team team;

	/**
	 * constructeur
	 * @param team est l'équipe à laquelle appartient la pièce
	 */
	public Piece(Team team){
		this.team=team;
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
	 *
	 * @return le rang de la pièce
	 */
	public abstract int getVALUE();

	/**
	 *
	 * @return le chemin de l'image de la pièce
	 */
	public abstract String getIMGPath();

}
