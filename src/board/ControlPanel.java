package board;

import ai.RandomAI;
import ai.SmarterAI;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import pieces.Team;

public class ControlPanel extends HBox {

	public ControlPanel(SelectionPanel s){
		this.setPrefHeight(80);
		this.setPrefWidth(500);

		ComboBox<String> combo = new ComboBox<>();
		combo.getItems().addAll("Random AI","Smarter AI");
		this.setMargin(combo, new Insets(10));
		combo.setPromptText(" - select AI");

		ComboBox<String> team = new ComboBox<>();
		team.getItems().addAll("Red","Blue");
		this.setMargin(team, new Insets(10));
		team.setPromptText(" - select your Team");

		Button start = new Button("Start Game !");
		start.setVisible(false);
		this.setMargin(start, new Insets(10));
		start.setFocusTraversable(false);
		start.setOnAction(e -> {
			Main.isGameStarted=true;
			s.setVisible(false);
		});

		Button Placement = new Button("Start Placement");
		this.setMargin(Placement,new Insets(10));
		Placement.setFocusTraversable(false);
		Placement.setOnAction(e -> {
			if(combo.getValue().equals("Random AI")){
				if(team.getValue().equals("Blue")) {
					Main.player2 = new RandomAI(Team.Red);
					Main.player2.init();
					start.setVisible(true);
					Main.playerTeam=Team.Blue;

				} else if(team.getValue().equals("Red")) {
					Main.player2 = new RandomAI(Team.Blue);
					Main.player2.init();
					start.setVisible(true);
					Main.playerTeam=Team.Red;
				}

			}else if(combo.getValue().equals("Smarter AI")){
				if(team.getValue().equals("Blue")) {
					Main.player2 = new SmarterAI(Team.Red);
					Main.player2.init();
					start.setVisible(true);
					Main.playerTeam=Team.Blue;
				} else if(team.getValue().equals("Red")) {
					Main.player2 = new SmarterAI(Team.Blue);
					Main.player2.init();
					start.setVisible(true);
					Main.playerTeam=Team.Red;
				}
			}
			s.setVisible(true);
		});


		this.getChildren().addAll(Placement, combo, team, start);
	}


}