package pieces;


/**
 * interface qui contient la signature de la méthode move qui permet à une pièce de se déplacer sur le plateau
 */
public interface Movable {
	boolean move(int x1, int y1,int x2, int y2);
}
