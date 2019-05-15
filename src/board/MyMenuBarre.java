package board;


import ai.AI;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pieces.*;

import java.io.*;
import java.util.ArrayList;


public class MyMenuBarre extends MenuBar {

    public MyMenuBarre(ControlPanel c) {
        Menu fichier =new Menu("Jeu");
        Menu option = new Menu ("Options");
        Menu aide = new Menu ("Aide");
        Menu game = new Menu("Sauvegarde");

        MenuItem regles =new MenuItem("Règles");
        MenuItem exit =new MenuItem("Quitter");
        MenuItem start = new MenuItem("Start");
        MenuItem stop = new MenuItem("Nouvelle partie");
        MenuItem save = new MenuItem("Sauver");
        MenuItem load = new MenuItem("Charger");

        start.setOnAction(e->Main.isGameStarted=true);
        stop.setOnAction(e->{
            Main.isGameStarted=false;
            Board.cleanBoard();
            SelectionPanel.reset();
            Main.nbCoup=0;
            c.setVisible(true);
        });
        load.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            fc.setTitle("Load game");
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("data file","*.dat"));
            fc.setInitialDirectory(new File("./saves"));
            File file = fc.showOpenDialog(new Stage());
            try{
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                try{
                    Main.playerTeam = (Team)ois.readObject();
                    ArrayList<Integer> tmp = (ArrayList<Integer>)ois.readObject();
                    ArrayList<Team> team = (ArrayList<Team>)ois.readObject();
                    int count=0;
                    for(int i =0;i<10;i++){
                        for(int j=0;j<10;j++){
                            switch (tmp.get(count) ){
                                case 0:
                                    Board.caseBoard[i][j].setContent(new Flag(team.get(count)));
                                    break;

                                case 1:
                                    Board.caseBoard[i][j].setContent(new Spy(team.get(count)));
                                    break;

                                case 2:
                                    Board.caseBoard[i][j].setContent(new Scout(team.get(count)));
                                    break;

                                case 3:
                                    Board.caseBoard[i][j].setContent(new Miner(team.get(count)));
                                    break;

                                case 4:
                                    Board.caseBoard[i][j].setContent(new Sergeant(team.get(count)));
                                    break;

                                case 5:
                                    Board.caseBoard[i][j].setContent(new Lieutenant(team.get(count)));
                                    break;

                                case 6:
                                    Board.caseBoard[i][j].setContent(new Captain(team.get(count)));
                                    break;

                                case 7:
                                    Board.caseBoard[i][j].setContent(new Major(team.get(count)));
                                    break;

                                case 8:
                                    Board.caseBoard[i][j].setContent(new Colonel(team.get(count)));
                                    break;

                                case 9:
                                    Board.caseBoard[i][j].setContent(new General(team.get(count)));
                                    break;

                                case 10:
                                    Board.caseBoard[i][j].setContent(new Marshal(team.get(count)));
                                    break;

                                case 11:
                                    Board.caseBoard[i][j].setContent(new Bomb(team.get(count)));
                                    break;

                                default:
                                    System.out.println("erreur");
                                    break;
                            }
                            count++;
                        }
                    }
                    Main.player2 = (AI)ois.readObject();
                    Main.nbCoup = (Integer)ois.readObject();
                    Main.isGameStarted = (Boolean)ois.readObject();
                }finally {
                    fis.close();
                    ois.close();
                }
            }catch(IOException | ClassNotFoundException i){
                i.printStackTrace();
            }
        });


        save.setOnAction(e -> {
            FileChooser fc= new FileChooser();
            fc.setTitle("Save game");
			fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("data file","*.dat"));
			fc.setInitialDirectory(new File("./saves"));
            File file = fc.showSaveDialog(new Stage());
            try{
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                try{
                    ArrayList<Integer> tmp = new ArrayList<>();
                    ArrayList<Team> team = new ArrayList<>();
                    oos.writeObject(Main.playerTeam);
                    for(int i =0 ; i<10 ;i++){
                        for(int j =0;j<10;j++){
                            if(Board.caseBoard[i][j].getContent()!=null) {
                                tmp.add(Board.caseBoard[i][j].getContent().getVALUE());
                                team.add(Board.caseBoard[i][j].getContent().team);
                            }
                            else {
                                tmp.add(-1);
                                team.add(null);
                            }
                        }
                    }
                    oos.writeObject(tmp);
                    oos.writeObject(team);
                    oos.writeObject(Main.player2);
                    oos.writeObject(Main.nbCoup);
                    oos.writeObject(Main.isGameStarted);
                }finally {
                    fos.close();
                    oos.close();
                }
            }catch(IOException i){
                i.printStackTrace();
            }
        });



        exit.setOnAction(event -> System.exit(0));
        regles.setOnAction(event -> {

            Label text = new Label("Le Stratego se joue à 2 joueurs (un joueur avec les pièces rouges, l'autre avec les pièces bleues) sur un plateau carré de 92 cases (10 cases de côté moins 2 lacs carrés de 4 cases chacun). Chaque joueur possède 40 pièces.\n" +
                    "\n" +
                    "Les pièces représentent des unités militaires et ont deux faces. Une face ne peut être vue que par un seul joueur à la fois, l'autre ne voyant que la couleur de la pièce. Les pièces sont placées de telle façon que le joueur ne voit que le rang de ses propres pièces.\n" +
                    "\n" +
                    "Au début de la partie chaque joueur dispose ses pièces comme il l'entend sur ses quatre premières rangées. Cette pré-phase du jeu est stratégique et déterminante pour la suite de la partie.\n" +
                    "\n" +
                    "Chaque joueur déplace une pièce d'une case par tour : à gauche, à droite, en avant ou en arrière (pas en diagonale). Une attaque se produit quand le joueur déplace sa pièce sur une case déjà occupée par l'adversaire. Chaque joueur montre alors sa pièce à l'adversaire. La pièce la plus forte reste en jeu, l'autre est éliminée ; en cas d'égalité, les deux sont éliminées.\n" +
                    "Stratego\n" +
                    "\n" +
                    "Voici les pièces classées de la plus forte à la plus faible (la force entre parenthèses) :\n" +
                    "\n" +
                    "    le Maréchal (10), 1 par joueur\n" +
                    "    le Général (9), 1 par joueur\n" +
                    "    les Colonels (8), 2 par joueur\n" +
                    "    les Commandants (7), 3 par joueur\n" +
                    "    les Capitaines (6), 4 par joueur\n" +
                    "    les Lieutenants (5), 4 par joueur\n" +
                    "    les Sergents (4), 4 par joueur\n" +
                    "    les Démineurs (3), 5 par joueur\n" +
                    "    les Éclaireurs (2), 8 par joueur\n" +
                    "    l'Espion (1), 1 par joueur\n" +
                    "    le Drapeau (0), 1 par joueur\n" +
                    "\n" +
                    "À ces pièces s'ajoutent les Bombes (6 par joueur). Ni les Bombes ni le Drapeau ne se déplacent.\n" +
                    "\n" +
                    "Le but du jeu est de capturer le Drapeau de l'adversaire ou d'éliminer assez de pièces adverses afin que l'adversaire ne puisse plus faire de déplacements.\n" +
                    "\n" +
                    "Certaines pièces obéissent à des règles spéciales :\n" +
                    "\n" +
                    "    Si l'Espion, grade le plus faible, attaque le Maréchal, grade le plus élevé, l'Espion gagne (si le Maréchal attaque en premier, le Maréchal gagne);\n" +
                    "    Toute pièce attaquant une Bombe est éliminée, sauf le Démineur qui prend alors la place de la Bombe (si une pièce autre qu'un Démineur attaque une Bombe, cette pièce est éliminée, et la Bombe reste en place jusqu'à l'éventuelle attaque d'un Démineur);\n" +
                    "    L'Éclaireur peut se déplacer d'autant de cases libres qu'il le souhaite, en ligne droite.\n"+"\n"+"(source: https://fr.wikipedia.org/wiki/Stratego#R%C3%A8gles_du_jeu_de_Stratego) ");

            StackPane secondaryLayout = new StackPane();
            secondaryLayout.getChildren().add(text);

            Scene secondScene = new Scene(secondaryLayout, 1000, 300);


            ScrollPane sp =new ScrollPane();
            VBox v =new VBox();
            v.getChildren().add(text);
            sp.setContent(v);
            sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            sp.setPrefSize(1000,300);


            Stage secondaryWindow = new Stage();
            secondaryWindow.setTitle("Règles");
            secondaryWindow.setScene(secondScene);

            secondaryLayout.getChildren().add(sp);
            secondaryWindow.show();
        });
        game.getItems().addAll(save,load);
        option.getItems().add(exit);
        fichier.getItems().addAll(start, stop, game);
        aide.getItems().addAll(regles);


        this.getMenus().addAll(fichier,option,aide);
    }
}