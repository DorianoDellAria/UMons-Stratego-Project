package pieces;

import board.*;
import javafx.scene.image.ImageView;

public class Scout extends AbstractMovable implements Movable{
	private final int VALUE=2;
	private final ImageView ImgFlag=new ImageView(getClass().getResource("../images/scout.png").toExternalForm());

	public Scout(Team team){
		super(team);
	}


	@Override
	public void move(int x1, int y1, int x2, int y2) {
		if(Board.caseBoard[x2][y2].getContent()==null || Board.caseBoard[x1][y1].getContent().team!=Board.caseBoard[x2][y2].getContent().team && Board.caseBoard[x2][y2].getContent().team!=null ) {
			if ((x1 == x2 || y1 == y2) && checkObstacle(x1,y1,x2,y2)) {
				if (Board.caseBoard[x2][y2].getContent() == null ) {
					Board.caseBoard[x2][y2].setContent(this);
				} else {
					Board.caseBoard[x2][y2].setContent(this.fight(Board.caseBoard[x2][y2].getContent()));
				}
				Board.caseBoard[x1][y1].setContent(null);
			}
		}
	}

	public boolean checkObstacle(int x1, int y1, int x2, int y2){
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
	public int getVALUE(){
		return this.VALUE;
	}
	@Override
	public ImageView getIMG(){return this.ImgFlag;}
}
