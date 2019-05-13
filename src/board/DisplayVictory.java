package board;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pieces.Team;

public class DisplayVictory {

    public DisplayVictory(Team team) {

        StackPane secondaryLayout = new StackPane();
        if (team==Team.Red){
            Label text = new Label("partie terminée, victoire de l'équipe rouge");
            secondaryLayout.getChildren().add(text);
        }
        else {
            Label text = new Label("partie terminée, victoire de l'équipe bleue");
            secondaryLayout.getChildren().add(text);
        }

        Scene secondScene = new Scene(secondaryLayout, 300, 100);

        Stage secondaryWindow = new Stage();
        secondaryWindow.setTitle("");
        secondaryWindow.setScene(secondScene);
        secondaryWindow.show();
    }
}