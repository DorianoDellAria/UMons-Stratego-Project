package board;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


public class MyMenuBarre extends MenuBar {

    public MyMenuBarre () {
        Menu fichier =new Menu("Jeu");
        Menu option = new Menu ("Options");
        MenuItem exit =new MenuItem("Quitter");
        MenuItem start = new MenuItem("Start");
        MenuItem stop = new MenuItem("Stop");
        start.setOnAction(e->Main.isGameStarted=true);
        stop.setOnAction(e->{
            Main.isGameStarted=false;
            Board.cleanBoard();
            SelectionPanel.reset();

        });
        exit.setOnAction(event -> System.exit(0));
        option.getItems().add(exit);
        fichier.getItems().addAll(start, stop);


        this.getMenus().addAll(fichier,option);
    }
}