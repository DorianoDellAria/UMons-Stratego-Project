package board;


import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

public class SelectionPanel extends ScrollPane {

	public static int rankBuffer=-1;
	private static HBox container = new HBox();
	public static boolean isClicked= false;

	public SelectionPanel(){
		this.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		this.setVbarPolicy(ScrollBarPolicy.NEVER);
		setButton();
		this.setContent(container);
		this.setPrefHeight(65);
		this.setPrefWidth(700);
	}

	private static void setButton(){
		SelectionButton flag = new SelectionButton(0,1);
		SelectionButton spy = new SelectionButton(1,1);
		SelectionButton scout = new SelectionButton(2,8);
		SelectionButton miner = new SelectionButton(3,5);
		SelectionButton sergeant = new SelectionButton(4,4);
		SelectionButton lieutenant = new SelectionButton(5,4);
		SelectionButton captain	= new SelectionButton(6,4);
		SelectionButton major = new SelectionButton(7,3);
		SelectionButton colonel = new SelectionButton(8,2);
		SelectionButton general = new SelectionButton(9,1);
		SelectionButton marshal = new SelectionButton(10,1);
		SelectionButton bomb = new SelectionButton(11, 6);
		container.getChildren().addAll(flag, spy, scout, miner, sergeant, lieutenant, captain, major, colonel, general, marshal, bomb);
	}

	public static void reset(){
		container.getChildren().clear();
		setButton();

	}

}