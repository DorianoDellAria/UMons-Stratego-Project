package board;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * La classe SelectionButton permet de sélectionner la pièce que l'on veut placer sur le plateau.
 * Elle contient le nombre maximum d'une certaine pièce que l'on peut placer sur le plateau.
 * Elle hérite de la classe StackPane de javafx
 */
public class SelectionButton extends StackPane {

	private int maxPiece;
	private final int rank;
	private ImageView img;


	/**
	 *
	 * @param rank le rang de la pièce que l'on sélectionne
	 * @param maxPiece le nombre de pièce maximum que l'on peut placer
	 */
	public SelectionButton(int rank, int maxPiece){
		this.rank= rank;
		this.maxPiece = maxPiece;
		Rectangle rec = new Rectangle(60,40);


		int i=this.rank;
			try{
				FileInputStream fis = new FileInputStream("./images/"+i+".png");
				try {
					Image tmp = new Image(fis);
					this.img = new ImageView(tmp);
					this.img.setFitHeight(35);
					this.img.setPreserveRatio(true);
				}finally {
					fis.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}


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
		this.getChildren().addAll(rec,this.img);
	}

}