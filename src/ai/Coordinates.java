package ai;

import java.io.Serializable;

/**
 * La classe Coordinates est un objet stockant les coordonnées d'une pièce sur le plateau
 */
public class Coordinates implements Serializable {

	public int x;
	public int y;

	/**
	 * Constructeur
	 * @param x coordonnée en x
	 * @param y coordonnée en y
	 */
	public Coordinates(int x, int y){
		this.x=x;
		this.y=y;
	}

	/**
	 * permet un affichage lisible en console.
	 * @return une chaine de caractère représentant les coordonnées en x et y
	 */
	@Override
	public String toString(){
		return String.format("( %d , %d )", this.x, this.y);
	}

}
