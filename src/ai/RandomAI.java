package ai;

import board.Board;
import board.Main;
import pieces.*;
import pieces.Team;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * RandomAI est une intelligence artificielle complètement aléatoire, elle retient la position de ses pièces dans une ArrayList.
 */
public class RandomAI extends AbstractAI implements Serializable {

	private Random rnd = new Random();
	private Team team;
	private ArrayList<Coordinates> piecesPosition = new ArrayList<>(40);
	private boolean isPieceMoved =true;

	/**
	 * Constructeur.
	 * @param team l'équipe de l'intelligence artificielle
	 */
	public RandomAI(Team team){
		this.team = team;
	}


	/**
	 * La méthode init initialise 2 ArrayList. Une contenant la valeur des pièces à positioner, l'autre contient le nombre maximum de ce type de pièces.
	 * Une valeur aléatoire est calculée et renvoie à un indice dans l'ArrayList pieces. En fonction de la valeur en indice, la pièce est positionnée sur le plateau.
	 */
	@Override
	public void init(){
		ArrayList<Integer> pieces= new ArrayList<>(12);
		ArrayList<Integer> nbP = new ArrayList<>(12);
		Piece p;
		pieces.add(0,0);
		pieces.add(1,1);
		pieces.add(2,2);
		pieces.add(3,3);
		pieces.add(4,4);
		pieces.add(5,5);
		pieces.add(6,6);
		pieces.add(7,7);
		pieces.add(8,8);
		pieces.add(9,9);
		pieces.add(10,10);
		pieces.add(11,11);
		nbP.add(0,1);
		nbP.add(1,1);
		nbP.add(2,8);
		nbP.add(3,5);
		nbP.add(4,4);
		nbP.add(5,4);
		nbP.add(6,4);
		nbP.add(7,3);
		nbP.add(8,2);
		nbP.add(9,1);
		nbP.add(10,1);
		nbP.add(11,6);
		for(int i = 0 ; i<10;i++){
			for (int j =0;j<4;j++){
				int tmp= rnd.nextInt(pieces.size());

				switch (pieces.get(tmp)) {
					case 0:
						p=new Flag(this.team);
						break;
					case 1:
						p=new Spy(this.team);
						break;
					case 2:
						p=new Scout(this.team);
						break;
					case 3:
						p=new Miner(this.team);
						break;
					case 4:
						p=new Sergeant(this.team);
						break;
					case 5:
						p=new Lieutenant(this.team);
						break;
					case 6:
						p=new Captain(this.team);
						break;
					case 7:
						p=new Major(this.team);
						break;
					case 8:
						p=new Colonel(this.team);
						break;
					case 9:
						p=new General(this.team);
						break;
					case 10:
						p= new Marshal(this.team);
						break;
					case 11:
						p=new Bomb(this.team);
						break;
					default:
						p=null;
						break;
				}
				Board.caseBoard[i][j].setContent(p);
				nbP.set(tmp, (nbP.get(tmp))-1);
				if(nbP.get(tmp)==0){
					nbP.remove(tmp);
					pieces.remove(tmp);
				}
				piecesPosition.add(new Coordinates(i,j));
			}
		}


	}

	/**
	 * Méthode de déplacement des pièces de l'intelligence artificielle. Les pièces sont sauvegardées dans une ArrayList.
	 * Un indice aléatoire est calculé, après avoir vérifié que la pièce puisse se déplacer, la méthode déplace la pièce.
	 */
	@Override
	public void makeAMove(){
		do {
			int tmp = rnd.nextInt(piecesPosition.size());
			int x = piecesPosition.get(tmp).x;
			int y = piecesPosition.get(tmp).y;
			if (Board.caseBoard[x][y].getContent()==null || Board.caseBoard[x][y].getContent().team!=this.team) {
				piecesPosition.remove(tmp);
				continue;
			}
			if(!(Board.caseBoard[x][y].getContent() instanceof Movable)){
				continue;
			}
			ArrayList<Coordinates> authorisedMove = this.getAuthorisedMove(x,y);
			if ( authorisedMove.size()!=0) {
				Coordinates destination = authorisedMove.get(rnd.nextInt(authorisedMove.size()));
				if(Board.caseBoard[destination.x][destination.y].getContent() != null && Board.caseBoard[destination.x][destination.y].getContent().team == Main.playerTeam){
					this.fightAnimation(x,y,destination.x,destination.y);
					isPieceMoved = false;
					piecesPosition.set(tmp, destination);
				}else {
					((Movable) (Board.caseBoard[x][y].getContent())).move(x, y, destination.x, destination.y);
					isPieceMoved = false;
					piecesPosition.set(tmp, destination);
				}


			}
		}while(isPieceMoved);
		isPieceMoved =true;
		Main.nbCoup++;
	}

	/**
	 * Renvoie pour une pièce à une position donnée une ArrayList contenant les déplacements autorisés.
	 * @param x la coordonnée en x de la pièce
	 * @param y la coordonnée en y de la pièce
	 * @return une ArrayList contenant les déplacements autorisés
	 */
	private ArrayList<Coordinates> getAuthorisedMove(int x, int y){
		ArrayList<Coordinates> authorisedMove = new ArrayList<>(4);
		if(x>0 && ((Board.caseBoard[x-1][y].getContent()==null) || (Board.caseBoard[x-1][y].getContent().team!=null && !(Board.caseBoard[x-1][y].getContent().team.equals(this.team))))){
			authorisedMove.add(new Coordinates(x-1,y));
		}
		if(x<9 && ((Board.caseBoard[x+1][y].getContent()==null) || (Board.caseBoard[x+1][y].getContent().team!=null && !(Board.caseBoard[x+1][y].getContent().team.equals(this.team))))){
			authorisedMove.add(new Coordinates(x+1,y));
		}
		if(y>0 && ((Board.caseBoard[x][y-1].getContent()==null) || (Board.caseBoard[x][y-1].getContent().team!=null && !(Board.caseBoard[x][y-1].getContent().team.equals(this.team))))){
			authorisedMove.add(new Coordinates(x,y-1));
		}
		if(y<9 && ((Board.caseBoard[x][y+1].getContent()==null) || (Board.caseBoard[x][y+1].getContent().team!=null && !(Board.caseBoard[x][y+1].getContent().team.equals(this.team))))){
			authorisedMove.add(new Coordinates(x,y+1));
		}
		return authorisedMove;
	}


	/**
	 * Méthode de debug, affiche une ArrayList de coordonnées.
	 * @param P une ArrayList de Coordinates
	 */
	public static void debug(ArrayList<Coordinates> P){
		for(Coordinates i : P)
			System.out.println(i);
	}

	/**
	 * Méthode servant à la sérialisation de l'intelligence artificielle.
	 * @param out un flux de d'objet en écriture
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeObject(this.team);
		out.writeObject(this.piecesPosition);
		out.writeObject(this.isPieceMoved);
	}

	/**
	 * Méthode servant à la sérialisation de l'intelligence artificielle.
	 * @param in un flux d'objet en lecture
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		this.rnd = new Random();
		this.team = (Team)in.readObject();
		this.piecesPosition = (ArrayList<Coordinates>)in.readObject();
		this.isPieceMoved = (boolean)in.readObject();

	}

}
