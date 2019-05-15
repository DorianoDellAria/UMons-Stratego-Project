package pieces;

import board.*;

public class Scout extends AbstractMovable implements Movable{
	private String img = "./images/2.png";

	public Scout(Team team){
		super(team,2);
	}


	/**
	 * méthode de déplacement spécifique au éclaireur, elle permet de se déplacer de plusieurs cases horizontalement ou verticalement
	 * à condition qu'il n'y ai pas d'obstacle
	 * @param x1 x initial
	 * @param y1 y initial
	 * @param x2 x final
	 * @param y2 y final
	 * @return vrai si le déplacement s'est éffectué correctement, faux sinon
	 */
	@Override
	public boolean move(int x1, int y1, int x2, int y2) {
		if(Board.caseBoard[x2][y2].getContent()==null || Board.caseBoard[x1][y1].getContent().team!=Board.caseBoard[x2][y2].getContent().team && Board.caseBoard[x2][y2].getContent().team!=null ) {
			if ((x1 == x2 || y1 == y2) && checkObstacle(x1,y1,x2,y2)) {
				if (Board.caseBoard[x2][y2].getContent() == null ) {
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

	/**
	 * cette méthode sert a vérifier s'il n'y a pas d'obstacle entre le point de départ et d'arrivée de la pièce
	 * @param x1 x initial
	 * @param y1 y initial
	 * @param x2 x final
	 * @param y2 y final
	 * @return vrai s'il n'y a pas d'obstacle, faux sinon
	 */
	private boolean checkObstacle(int x1, int y1, int x2, int y2){
		if (x1==x2){
			if(y1<y2) {
				for (int i = y1+1; i < y2; i++) {
					if(Board.caseBoard[x1][i].getContent()!=null)
						return false;
				}
			}
			else{
				for (int i = y1-1; i > y2; i--) {
					if(Board.caseBoard[x1][i].getContent()!=null)
						return false;
				}
			}
		}
		else {
			if (x1 < x2) {
				for (int i = x1+1; i < x2; i++) {
					if (Board.caseBoard[i][y1].getContent() != null)
						return false;
				}
			}
			else {
				for (int i = x1-1; i > x2; i--) {
					if (Board.caseBoard[i][y1].getContent() != null)
						return false;
				}
			}
		}
		return true;
	}



	@Override
	public String getIMGPath(){return this.img;}
}
