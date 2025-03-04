package ai;

import board.Board;
import board.Case;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import pieces.Movable;
import pieces.Team;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Classe abstraite parent de toutes intelligences artificielles fournissant la méthode fightAnimation.
 */
public abstract class AbstractAI implements AI {

	/**
	 * Méthode forçant l'intelligence artificielle à faire un déplacement.
	 */
	@Override
	public abstract void makeAMove() ;

	/**
	 * Méthode de placement des pièces de l'intelligence artifficielle
	 */
	@Override
	public abstract void init() ;

	/**
	 * Méthode d'affichage de la pièce qui attaque une des pièces appartenant à l'utilisateur.
	 * @param x1 x initial
	 * @param y1 y initial
	 * @param x2 x final
	 * @param y2 y final
	 */
	protected void fightAnimation(int x1, int y1, int x2, int y2){
		Case.isOnAnimation=true;
		Board.caseBoard[x1][y1].getChildren().clear();
		try {
			FileInputStream fis = new FileInputStream(Board.caseBoard[x1][y1].getContent().getIMGPath());
			try{
				Rectangle rec = new Rectangle(90,60);
				if (Board.caseBoard[x1][y1].getContent()!=null && Board.caseBoard[x1][y1].getContent().team== Team.Red) {
					rec.setFill(Color.RED);
				}
				else if(Board.caseBoard[x1][y1].getContent()!=null && Board.caseBoard[x1][y1].getContent().team==Team.Blue){
					rec.setFill(Color.LIGHTBLUE);
				}
				else{
					rec.setFill(null);
				}
				rec.setStroke(Color.BLACK);
				Image img =new Image(fis);
				ImageView iv = new ImageView(img);
				iv.setFitHeight(45);
				iv.setPreserveRatio(true);
				Board.caseBoard[x1][y1].getChildren().addAll(rec,iv);
			}finally {
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Timeline tl =new Timeline(new KeyFrame(Duration.millis(2000),e->{
			((Movable)Board.caseBoard[x1][y1].getContent()).move(x1,y1,x2,y2);
			Case.isOnAnimation=false;
		}));
		tl.setCycleCount(1);
		tl.play();

	}

}
