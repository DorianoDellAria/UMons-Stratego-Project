package pieces;

import board.*;

/**
 * classe abstraite intermédiaire parent de toutes pièces bougeables
 */
public abstract class AbstractMovable extends Piece implements Movable {

	/**
	 * @param team l'équipe de la pièce
	 */
	public AbstractMovable(Team team,int VALUE, String img){
		super(team,VALUE, img);
	}

	/**
	 * Méthode de déplacement d'une pièce sur le plateau
	 * @param x1 x initial
	 * @param y1 y initial
	 * @param x2 x final
	 * @param y2 y final
	 * @return vrai si le déplacement a été éffectué correctement, faux sinon.
	 */
	@Override
	public boolean move( int x1, int y1, int x2, int y2){
		if( Board.caseBoard[x2][y2].getContent()==null || (Board.caseBoard[x1][y1].getContent().team!=Board.caseBoard[x2][y2].getContent().team && Board.caseBoard[x2][y2].getContent().team!=null )) {
			if ((x1 == x2 && Math.abs(y1 - y2) == 1) || (y1 == y2 && Math.abs(x1 - x2) == 1)) {
				if (Board.caseBoard[x2][y2].getContent() == null) {
					Board.caseBoard[x2][y2].setContent(this);
				} else {
					Board.caseBoard[x2][y2].setContent(this.fight(Board.caseBoard[x2][y2].getContent()));
				}
				Board.caseBoard[x1][y1].setContent(null);
				return true;
			}
			return false;
		}
		return false;
	}

}
