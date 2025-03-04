package board;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pieces.*;

import java.io.*;
import java.util.ArrayList;

/**
 * La classe SelectionPanel sert à placer manuellement les pièces sur le plateau, il y a tout de même un bouton permettant le placement
 * d'une configuration sauvegardée au format "*.position".
 * Le selectionPanel n'est affiché que lorsque l'utilisateur a choisi son équipe et son adversaire.
 */
public class SelectionPanel extends ScrollPane {

	public static int rankBuffer=-1;
	public static HBox container = new HBox();
	public static boolean isClicked= false;

	/**
	 * Le constructeur initialise une ScrollBox et fixe la taille du SelectionPanel.
	 */
	public SelectionPanel(){
		this.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		this.setVbarPolicy(ScrollBarPolicy.NEVER);
		setButton();
		this.setContent(container);
		this.setPrefHeight(65);
		this.setPrefWidth(700);
		container.setVisible(false);
	}

	/**
	 * Méthode initialisant tous les SelectionButton.
	 */
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


		Button save = new Button("Sauvegarder configuration");
		save.setFocusTraversable(false);
		container.setMargin(save, new Insets(10));
		save.setOnAction(e ->{
			FileChooser fc = new FileChooser();
			fc.setTitle("Save configuration");
			fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("position file","*.position"));
			fc.setInitialDirectory(new File("./saves"));
			File file = fc.showSaveDialog(new Stage());
			try{
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				try{
					ArrayList<Integer> config= new ArrayList<>(40);
					for(int i=0;i<10;i++){
						for(int j = 6 ;j<10;j++){
							if(Board.caseBoard[i][j].getContent()!=null)
								config.add(Board.caseBoard[i][j].getContent().getVALUE());
							else
								config.add(-1);
						}
					}
					oos.writeObject(config);
				}finally {
					fos.close();
					oos.close();
				}
			}catch(IOException i){
				i.printStackTrace();
			}
		});


		Button load = new Button("Charger configuration");
		load.setFocusTraversable(false);
		container.setMargin(load, new Insets(10));
		load.setOnAction(e ->{
			FileChooser fc = new FileChooser();
			fc.setTitle("Load configuration");
			fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("position file", "*.position"));
			fc.setInitialDirectory(new File("./saves"));
			File file = fc.showOpenDialog(new Stage());
			try{
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				try{
					ArrayList<Integer> config = (ArrayList<Integer>) ois.readObject();
					int count =0;
					for(int i = 0;i<10;i++){
						for(int j =6;j<10;j++){

							switch (config.get(count) ){
								case 0:
									Board.caseBoard[i][j].setContent(new Flag(Main.playerTeam));
									break;

								case 1:
									Board.caseBoard[i][j].setContent(new Spy(Main.playerTeam));
									break;

								case 2:
									Board.caseBoard[i][j].setContent(new Scout(Main.playerTeam));
									break;

								case 3:
									Board.caseBoard[i][j].setContent(new Miner(Main.playerTeam));
									break;

								case 4:
									Board.caseBoard[i][j].setContent(new Sergeant(Main.playerTeam));
									break;

								case 5:
									Board.caseBoard[i][j].setContent(new Lieutenant(Main.playerTeam));
									break;

								case 6:
									Board.caseBoard[i][j].setContent(new Captain(Main.playerTeam));
									break;

								case 7:
									Board.caseBoard[i][j].setContent(new Major(Main.playerTeam));
									break;

								case 8:
									Board.caseBoard[i][j].setContent(new Colonel(Main.playerTeam));
									break;

								case 9:
									Board.caseBoard[i][j].setContent(new General(Main.playerTeam));
									break;

								case 10:
									Board.caseBoard[i][j].setContent(new Marshal(Main.playerTeam));
									break;

								case 11:
									Board.caseBoard[i][j].setContent(new Bomb(Main.playerTeam));
									break;

								default:
									break;
							}
							count++;
						}
					}
				}finally{
					fis.close();
					ois.close();
				}
			}catch(IOException | ClassNotFoundException i){
				i.printStackTrace();
			}
		});

		Button start = new Button("Lancer la partie !");
		container.setMargin(start, new Insets(10));
		start.setFocusTraversable(false);
		start.setOnAction(e -> {
			if(isPlacementFinished()) {
				Main.isGameStarted = true;
				container.setVisible(false);
				if (Main.playerTeam == Team.Blue) {
					Main.nbCoup = 1;
					Main.player2.makeAMove();
				}
			}
		});


		container.getChildren().addAll(flag, spy, scout, miner, sergeant, lieutenant, captain, major, colonel, general, marshal, bomb, save, load, start);
	}

	/**
	 * Permet la réinitialisation du SelectionPanel lorsqu'on lance une nouvelle partie.
	 */
	public static void reset(){
		container.getChildren().clear();
		setButton();

	}

	/**
	 * Méthode de vérification de placement de pièce
	 * @return vrai si toutes les pièces sont placées, faux sinon
	 */
	private static boolean isPlacementFinished(){
		for(int i =0;i<10;i++){
			for(int j=6;j<10;j++){
				if (Board.caseBoard[i][j].getContent()==null) {
					return false;
				}
			}
		}
		return true;
	}

}