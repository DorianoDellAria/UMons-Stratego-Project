package board;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import pieces.*;

import java.io.*;

import static board.Main.boolDisplay;
import static board.Main.displayTeam;

/**
 * La classe Case est la classe qui compose le plateau.<br> Une case est remplie si la variable contient une pièce, elle est vide si content = null.
 * Chaque case possède une coordonée en x et en y. <br>La variable isPieceMoved est utile pour la détection de mouvement sur le plateau.
 * La variable isOnAnimation empêche le joueur de déplacer une pièce lorsque le jeu est en animation de combat.<br>
 * La classe hérite de StackPane de javafx
 */
public class Case extends StackPane {

    private Piece content;
    public final int x;
    public final int y;
    private static boolean isPieceMoved =false;
    public static boolean isOnAnimation = false;


	/**
	 * Constructeur de la classe Case. <br>Il place un rectangle avec la couleur de l'équipe dans une stackPane ainsi que l'image de la pièce que la case
	 * contient.<br>
	 * Chaque case possède un eventHandler défini avec une expression lambda.<br>
	 * La case n'est cliquable que lorsque le nombre de coup de la partie est paire.<br>
	 * Lorsque la case est cliqué, 2 possibilité, soit il n'y avait pas d'autre case cliquée avant, dans ce cas on rempli les variables xBuffer et yBuffer
	 * par les coordonnées de la case. Soit il y avait une case déjà cliquée, dans ce cas on applique la méthode move avec les coordonnées buffer et les coordonnées
	 * actuelles.<br>
	 * Si le jeu n'a pas commencé, l'eventHandler se charge de positioner les pièces sur le plateau après avoir sélectioné une pièce dans le selectionPanel
	 * @param content est la pièce qui est contenue dans la case
	 * @param x est la coordonnée horizontale sur le plateau
	 * @param y est la coordonnées verticale du plateau
	 */
    public Case (Piece content, int x, int y){
        Rectangle rectangle = new Rectangle(90,60);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(null);
        this.getChildren().add(rectangle);
        this.content=content;
        this.x=x;
        this.y=y;
        this.setOnMouseClicked(event->{
            if(Main.isGameStarted && Main.nbCoup%2==0 ) {
                boolDisplay=false;
                Main.checkGameOver();
                Main.displayVictory(displayTeam,boolDisplay);
                if (!Board.isClicked && this.content != null && this.content instanceof Movable && this.content.team==Main.playerTeam && !isOnAnimation) {
                    Board.xBuffer = this.x;
                    Board.yBuffer = this.y;
                    Board.isClicked = true;
                } else if (Board.isClicked && (Board.xBuffer != this.x || Board.yBuffer != this.y)) {
                            if(this.content!=null && this.content.team!=Main.playerTeam && isShowable(Board.xBuffer,Board.yBuffer,this.x,this.y)){
                                this.fightAnimation();
                                Board.isClicked = false;
                            }
                            else{
                                isPieceMoved = ((Movable) Board.caseBoard[Board.xBuffer][Board.yBuffer].getContent()).move(Board.xBuffer, Board.yBuffer, this.x, this.y);
                                Board.isClicked = false;
								if(isPieceMoved){
									Main.nbCoup++;
									Main.checkGameOver();
									Main.displayVictory(displayTeam, boolDisplay);
									Main.player2.makeAMove();
									isPieceMoved=false;
								}
                            }
                }

            }
            else{
                if(this.content ==null && this.y >=6 && SelectionPanel.isClicked) {
                    switch (SelectionPanel.rankBuffer) {
                        case 0:
                            this.setContent(new Flag(Main.playerTeam));
                            break;

                        case 1:
                            this.setContent(new Spy(Main.playerTeam));
                            break;

                        case 2:
                            this.setContent(new Scout(Main.playerTeam));
                            break;

                        case 3:
                            this.setContent(new Miner(Main.playerTeam));
                            break;

                        case 4:
                            this.setContent(new Sergeant(Main.playerTeam));
                            break;

                        case 5:
                            this.setContent(new Lieutenant(Main.playerTeam));
                            break;

                        case 6:
                            this.setContent(new Captain(Main.playerTeam));
                            break;

                        case 7:
                            this.setContent(new Major(Main.playerTeam));
                            break;

                        case 8:
                            this.setContent(new Colonel(Main.playerTeam));
                            break;

                        case 9:
                            this.setContent(new General(Main.playerTeam));
                            break;

                        case 10:
                            this.setContent(new Marshal(Main.playerTeam));
                            break;

                        case 11:
                            this.setContent(new Bomb(Main.playerTeam));
                            break;

                        default:
                            System.out.println("erreur");
                            break;
                    }
                    SelectionPanel.rankBuffer=-1;
                    SelectionPanel.isClicked = false;
                }
            }
        });

    }

	/**
	 * Méthode donnant accès au contenue d'une case
	 * @return le contenu de la case
	 */
	public Piece getContent (){
        return this.content;
    }

	/**
	 * méthode d'affichage de la pièce adverse lorsqu'on l'attaque
	 */
	private void fightAnimation(){
    	isOnAnimation =true;
		this.getChildren().clear();
		try {
			FileInputStream fis = new FileInputStream(this.content.getIMGPath());
			try{
				Rectangle rec = new Rectangle(90,60);
				if (this.content!=null && this.content.team==Team.Red) {
					rec.setFill(Color.RED);
				}
				else if(this.content!=null && this.content.team==Team.Blue){
					rec.setFill(Color.LIGHTBLUE);
				}
				else{
					rec.setFill(null);
				}
				rec.setStroke(Color.BLACK);
				Image img =new Image(fis);
				ImageView iv = new ImageView(img);
				iv.setFitHeight(45);
				iv.setPreserveRatio(true);
				this.getChildren().addAll(rec,iv);
			}finally {
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(2000),event1-> {
			isPieceMoved = ((Movable) Board.caseBoard[Board.xBuffer][Board.yBuffer].getContent()).move(Board.xBuffer, Board.yBuffer, this.x, this.y);
			Main.checkGameOver();
			Main.displayVictory(displayTeam, boolDisplay);
			if(isPieceMoved){
				Main.nbCoup++;
				Main.player2.makeAMove();
				isPieceMoved=false;
				isOnAnimation=false;
			}
		}));
		tl.setCycleCount(1);
		tl.play();
	}

	/**
	 * Méthode de placement de pièce
	 * @param p la pièce que l'on souhaite placer
	 */
    public void setContent (Piece p){
        this.content=p;
        if(p!=null) {
            this.getChildren().clear();
            Rectangle rec = new Rectangle(90,60);     //90,60
            if (p.team==Team.Red) {
                rec.setFill(Color.RED);
            }
            else if(p.team==Team.Blue){
                rec.setFill(Color.LIGHTBLUE);
            }
            else{
                rec.setFill(null);
            }
            rec.setStroke(Color.BLACK);
            try{
                FileInputStream fis;
                if(p.team==null || p.team== Main.playerTeam) {
                    fis = new FileInputStream(this.content.getIMGPath());
                }
                else{
                    fis = new FileInputStream("./images/stratego2.png");
                }
                try{
                    Image tmp = new Image(fis);
                    ImageView img = new ImageView(tmp);
                    img.setFitHeight(45);
                    img.setPreserveRatio(true);
                    this.getChildren().addAll(rec, img);
                }finally {
                    fis.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }


        }
        else{
            this.getChildren().clear();
            Rectangle rec = new Rectangle(90,60);
            rec.setFill(null);
            rec.setStroke(Color.BLACK);
            this.getChildren().add(rec);
        }


    }

	/**
	 * Méthode servant à vérifier si une pièce peut attaquer une autre et ainsi lancer la fightAnimation.
	 * @param x1 position initiale de la pièce
	 * @param y1 position initiale de la pièce
	 * @param x2 position finale de la pièce
	 * @param y2 position finale de la pièce
	 * @return vrai si on peut montrer la pièce de l'équipe adverse, faux sinon.
	 */
    private static boolean isShowable(int x1, int y1, int x2, int y2){
        if(Board.caseBoard[x1][y1].getContent() instanceof Scout){
            if(x1==x2){
            	if(y1>y2){
            		for(int i = y1-1;i>y2;i--){
						if(Board.caseBoard[x1][i].getContent()!=null){
							return false;
						}
					}
				}else{
					for(int i = y1+1;i<y2;i++){
						if(Board.caseBoard[x1][i].getContent()!=null){
							return false;
						}
					}
				}
            	return true;
			}
            else if(y1==y2){
				if(x1>x2){
					for(int i = x1-1;i>x2;i--){
						if(Board.caseBoard[i][y1].getContent()!=null){
							return false;
						}
					}
				}else{
					for(int i = x1+1;i<x2;i++){
						if(Board.caseBoard[i][y1].getContent()!=null){
							return false;
						}
					}
				}
				return true;
			}
            return false;
        }
        else{
            if((x1==x2 && Math.abs(y1-y2)==1) || (y1==y2 && Math.abs(x1-x2)==1)){
                return true;
            }
            else{
                return false;
            }
        }
    }

}
