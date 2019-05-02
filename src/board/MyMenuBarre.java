package board;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import static java.lang.System.exit;

public class MyMenuBarre extends MenuBar {

    public MyMenuBarre () {
        super();
        Menu fichier =new Menu("Jeu");
        Menu option = new Menu ("Options");
        MenuItem exit =new MenuItem("Quitter");
        exit.setOnAction(event -> exit(0));
        option.getItems().add(exit);


        super.getMenus().addAll(fichier,option);
    }
}