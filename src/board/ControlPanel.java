package board;

import ai.RandomAI;
import ai.SmarterAI;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import pieces.Team;

/**
 * ControlPanel est la classe qui donne le choix entre les intelligences artificielles et le choix entre les deux équipes.
 * La classe hérite de la classe HBox de javafx
 */
public class ControlPanel extends HBox {

	/**
	 * Le constructeur positionne les 2 ComboBox de choix et un bouton de validation
	 */
	public ControlPanel(){
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



		Button placement = new Button("Start Placement");
		this.setMargin(placement,new Insets(10));
		placement.setFocusTraversable(false);
		placement.setOnAction(e -> {
			if(combo.getValue().equals("Random AI")){
				if(team.getValue().equals("Blue")) {
					Main.player2 = new RandomAI(Team.Red);
					Main.player2.init();
					Main.playerTeam=Team.Blue;

				} else if(team.getValue().equals("Red")) {
					Main.player2 = new RandomAI(Team.Blue);
					Main.player2.init();
					Main.playerTeam=Team.Red;
				}

			}else if(combo.getValue().equals("Smarter AI")){
				if(team.getValue().equals("Blue")) {
					Main.player2 = new SmarterAI(Team.Red);
					Main.player2.init();
					Main.playerTeam=Team.Blue;
				} else if(team.getValue().equals("Red")) {
					Main.player2 = new SmarterAI(Team.Blue);
					Main.player2.init();
					Main.playerTeam=Team.Red;
				}
			}
			SelectionPanel.container.setVisible(true);
			this.setVisible(false);
		});


		this.getChildren().addAll(placement, combo, team);
	}




}