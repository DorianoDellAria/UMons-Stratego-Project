package pieces;

import board.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Scout extends AbstractMovable implements Movable{
	private final int VALUE=2;
	private ImageView img;

	public Scout(Team team){
		super(team);
		try {
			FileInputStream fis = new FileInputStream("./images/2.png");
			Image tmp = new Image(fis);
			this.img = new ImageView(tmp);
			this.img.setFitHeight(45);
			this.img.setPreserveRatio(true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
	public ImageView getIMG(){return this.img;}
}
