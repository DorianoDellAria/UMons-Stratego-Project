package ai;

import board.Board;
import board.Main;
import pieces.*;
import pieces.Team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


public class SmarterAI implements AI, Serializable {

	private Team team;
	private ArrayList<Coordinates> piecesPosition = new ArrayList<>(40);
	private Random rnd = new Random();
	private boolean isPieceMoved =true;
	private int[][] memory = new int[10][10];

	public SmarterAI(Team team){
		this.team = team;
	}

	@Override
	public void makeAMove() {
		Coordinates destination;
		int tmp;
		int x;
		int y;
		do{
			tmp = rnd.nextInt(piecesPosition.size());
			x=piecesPosition.get(tmp).x;
			y=piecesPosition.get(tmp).y;
			if (Board.caseBoard[x][y].getContent()==null || Board.caseBoard[x][y].getContent().team!=this.team){
				piecesPosition.remove(tmp);
				continue;
			}
			if(!(Board.caseBoard[x][y].getContent() instanceof Movable)){
				continue;
			}
			destination = isPieceNear(x,y);
			if(destination != null){
				((Movable)Board.caseBoard[x][y].getContent()).move(x,y,destination.x,destination.y);
				piecesPosition.set(tmp , new Coordinates(destination.x,destination.y));
				isPieceMoved =false;
			}
			else{
				ArrayList<Coordinates> authorisedMove = getAuthorisedMove(x,y);
				if(authorisedMove.size()==0){
					continue;
				}
				else{
					destination= authorisedMove.get(rnd.nextInt(authorisedMove.size()));
					((Movable) Board.caseBoard[x][y].getContent()).move(x,y,destination.x,destination.y);
					piecesPosition.set(tmp , new Coordinates(destination.x,destination.y));
					isPieceMoved =false;
				}
			}

		}while(isPieceMoved);
		isPieceMoved=true;
		Main.nbCoup++;
	}

	@Override
	public void init() {
		ArrayList<Integer> pieces= new ArrayList<>(12);
		ArrayList<Integer> nbP = new ArrayList<>(12);
		Piece p;
		pieces.add(0,1);
		pieces.add(1,2);
		pieces.add(2,3);
		pieces.add(3,4);
		pieces.add(4,5);
		pieces.add(5,6);
		pieces.add(6,7);
		pieces.add(7,8);
		pieces.add(8,9);
		pieces.add(9,11);
		nbP.add(0,1);
		nbP.add(1,8);
		nbP.add(2,5);
		nbP.add(3,4);
		nbP.add(4,4);
		nbP.add(5,4);
		nbP.add(6,3);
		nbP.add(7,2);
		nbP.add(8,1);
		nbP.add(9,3);
		int tmp = rnd.nextInt(8)+1;
		Board.caseBoard[tmp][0].setContent(new Flag(this.team));
		Board.caseBoard[tmp-1][0].setContent(new Bomb(this.team));
		Board.caseBoard[tmp+1][0].setContent(new Bomb(this.team));
		Board.caseBoard[tmp][1].setContent(new Bomb(this.team));
		Board.caseBoard[tmp+1][1].setContent(new Marshal(this.team));
		for(int i = 0 ; i<10;i++) {
			for (int j = 0; j < 4; j++) {
				int tmp2 = rnd.nextInt(pieces.size());

				if ((i == tmp - 1 || i == tmp || i == tmp + 1) && j == 0) {  //pour pas ecraser le flag et bomb
					piecesPosition.add(new Coordinates(i, j));
					continue;
				}

				if ((i == tmp || i == tmp + 1) && j == 1) {
					piecesPosition.add(new Coordinates(i, j));
					continue;
				}

				switch (pieces.get(tmp2)) {
					case 0:
						p = new Flag(this.team);
						break;
					case 1:
						p = new Spy(this.team);
						break;
					case 2:
						p = new Scout(this.team);
						break;
					case 3:
						p = new Miner(this.team);
						break;
					case 4:
						p = new Sergeant(this.team);
						break;
					case 5:
						p = new Lieutenant(this.team);
						break;
					case 6:
						p = new Captain(this.team);
						break;
					case 7:
						p = new Major(this.team);
						break;
					case 8:
						p = new Colonel(this.team);
						break;
					case 9:
						p = new General(this.team);
						break;
					case 10:
						p = new Marshal(this.team);
						break;
					case 11:
						p = new Bomb(this.team);
						break;
					default:
						p = null;
						break;
				}
				Board.caseBoard[i][j].setContent(p);
				nbP.set(tmp2, (nbP.get(tmp2)) - 1);
				if (nbP.get(tmp2) == 0) {
					nbP.remove(tmp2);
					pieces.remove(tmp2);
				}
				piecesPosition.add(new Coordinates(i, j));
			}
		}
	}

	private Coordinates isPieceNear(int x, int y){
		if(x!=0 && Board.caseBoard[x-1][y].getContent()!=null && Board.caseBoard[x-1][y].getContent().team!=this.team && Board.caseBoard[x-1][y].getContent().team!=null){
			return new Coordinates(x-1,y);
		}
		else if (x != 9 && Board.caseBoard[x+1][y].getContent()!=null && Board.caseBoard[x+1][y].getContent().team != this.team && Board.caseBoard[x+1][y].getContent().team != null){
			return new Coordinates(x+1,y);
		}
		else if(y!=0 && Board.caseBoard[x][y-1].getContent()!=null && Board.caseBoard[x][y-1].getContent().team != this.team && Board.caseBoard[x][y-1].getContent().team != null){
			return new Coordinates(x,y-1);
		}
		else if(y!=9 && Board.caseBoard[x][y+1].getContent()!=null && Board.caseBoard[x][y+1].getContent().team != this.team && Board.caseBoard[x][y+1].getContent().team != null){
			return new Coordinates(x,y+1);
		}

		return null;
	}

	private ArrayList<Coordinates> getAuthorisedMove(int x, int y){
		ArrayList<Coordinates> authorisedMove =new ArrayList<>(4);
		if(x!=0 && Board.caseBoard[x-1][y].getContent()==null){
			authorisedMove.add( new Coordinates(x-1,y));
		}
		if(x!=9 && Board.caseBoard[x+1][y].getContent()==null){
			authorisedMove.add(new Coordinates(x+1,y));
		}
		if(y!=0 && Board.caseBoard[x][y-1].getContent()==null){
			authorisedMove.add( new Coordinates(x,y-1));
		}
		if(y!=9 && Board.caseBoard[x][y+1].getContent()==null){
			authorisedMove.add(new Coordinates(x,y+1));
		}
		return authorisedMove;
	}

}

