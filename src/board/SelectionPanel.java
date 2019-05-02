package board;


import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

public class SelectionPanel extends ScrollPane {

	public static int rankBuffer=-1;

	public SelectionPanel(){
		HBox container = new HBox();
		SelectionButton test = new SelectionButton(5,5);
		this.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		this.setVbarPolicy(ScrollBarPolicy.NEVER);
		container.getChildren().addAll(test);
		this.setContent(container);
		this.setPrefHeight(60);
		this.setPrefWidth(700);
	}

}