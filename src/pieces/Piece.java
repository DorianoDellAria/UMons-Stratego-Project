package pieces;


/**
 * classe parent de toutes pièces du jeu
 * chaque pièce possède un chemin d'image, un rang et une équipe
 */
public abstract class Piece  {

	private final String img;
	private final int VALUE;
	public final Team team;

	/**
	 * constructeur
	 * @param team est l'équipe à laquelle appartient la pièce
	 * @param VALUE est le rang de la pièce
	 * @param img est le chemin de l'image
	 */
	public Piece(Team team, int VALUE, String img){
		this.team=team;
		this.VALUE= VALUE;
		this.img = img;
	}

	/**
	 * méthode de combat entre les pièces
	 * @param defense est la pièce attaquée
	 * @return la pièce victorieuse du combat
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
	 * chaque pièce à une certaine valeur
	 * @return le rang de la pièce
	 */
	public int getVALUE(){
		return VALUE;
	}

	/**
	 *
	 * @return le chemin de l'image d'une pièce
	 */
	public String getIMGPath(){
		return img;
	}

}
