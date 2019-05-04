package board;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlPanel extends HBox {

	public ControlPanel(){
		this.setPrefHeight(80);
		this.setPrefWidth(500);
		Button btn = new Button("hello");
		this.getChildren().add(btn);
	}

}