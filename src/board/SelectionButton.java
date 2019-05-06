package board;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class SelectionButton extends StackPane {

	private int maxPiece;
	private final int rank;

	public SelectionButton(int rank, int maxPiece){
		this.rank= rank;
		this.maxPiece = maxPiece;
		Rectangle rec = new Rectangle(60,40);
		Text txt = new Text(Integer.toString(this.rank));
		rec.setStroke(Color.BLACK);
		rec.setFill(null);
		this.setOnMouseClicked(e->{
			if(!SelectionPanel.isClicked && maxPiece>0) {
				SelectionPanel.rankBuffer = this.rank;
				this.maxPiece--;
				SelectionPanel.isClicked = true;
			}
			if(this.maxPiece==0){
				this.getChildren().clear();
				Rectangle rec2 = new Rectangle(60,40);
				rec2.setFill(Color.BLACK);
				rec2.setStroke(Color.BLACK);
				this.getChildren().add(rec2);
				this.setOnMouseClicked(null);
			}
		});
		this.getChildren().addAll(rec,txt);
	}

}