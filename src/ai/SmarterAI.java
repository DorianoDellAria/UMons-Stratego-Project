package ai;

import board.Board;
import board.Main;
import pieces.*;
import pieces.Team;

import java.util.ArrayList;
import java.util.Random;


public class SmarterAI implements AI{

	private Team team;
	private ArrayList<Tuple> piecesPosition = new ArrayList<>(40);
	private Random rnd = new Random();
	private boolean isPieceMoved =true;

	public SmarterAI(Team team){
		this.team = team;
	}

	@Override
	public void makeAMove() {

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
					piecesPosition.add(new Tuple(i, j));
					continue;
				}

				if ((i == tmp || i == tmp + 1) && j == 1) {
					piecesPosition.add(new Tuple(i, j));
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
				piecesPosition.add(new Tuple(i, j));
			}
		}
	}

	private boolean isPieceNear(int x, int y){
		if(x!=0 && Board.caseBoard[x-1][y].getContent().team!=this.team){
			return true;
		}
		else if (x != 9 && Board.caseBoard[x+1][y].getContent().team != this.team){
			return true;
		}
		else if(y!=0 && Board.caseBoard[x][y-1].getContent().team != this.team){
			return true;
		}
		else if(y!=9 && Board.caseBoard[x][y+1].getContent().team != this.team){
			return true;
		}

		return false;
	}

}

