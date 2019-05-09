package ai;

import board.Board;
import board.Main;
import pieces.*;
import pieces.Team;

import java.util.ArrayList;
import java.util.Random;

public class RandomAI implements AI {

	private Random rnd = new Random();
	private Team team;
	private ArrayList<Tuple> piecesPosition = new ArrayList<>(40);
	private boolean isPieceMoved =true;

	public RandomAI(Team team){
		this.team = team;
	}


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
				piecesPosition.add(new Tuple(i,j));
			}
		}
		debug(piecesPosition);


	}

	@Override
	public void makeAMove(){
		do {
			int tmp = rnd.nextInt(piecesPosition.size());
			System.out.println(piecesPosition.get(tmp));
			int x = piecesPosition.get(tmp).x;
			int y = piecesPosition.get(tmp).y;
			if (Board.caseBoard[x][y].getContent()==null || Board.caseBoard[x][y].getContent().team!=this.team) {
				piecesPosition.remove(tmp);
				continue;
			}

			if (Board.caseBoard[x][y].getContent() instanceof Movable && this.isFree(x, y)) {
				boolean[] authorisedMove = this.getAuthorisedMove(x, y);
				if (authorisedMove[0]) {
					((Movable) (Board.caseBoard[x][y].getContent())).move(x, y, x - 1, y);
					isPieceMoved =false;
					piecesPosition.get(tmp).x=x-1;
				}
				else if (authorisedMove[1]) {
					((Movable) (Board.caseBoard[x][y].getContent())).move(x, y, x + 1, y);
					isPieceMoved =false;
					piecesPosition.get(tmp).x=x+1;
				}
				else if (authorisedMove[2]) {
					((Movable) (Board.caseBoard[x][y].getContent())).move(x, y, x, y - 1);
					isPieceMoved =false;
					piecesPosition.get(tmp).y=y-1;
				}
				else if (authorisedMove[3]) {
					((Movable) (Board.caseBoard[x][y].getContent())).move(x, y, x, y + 1);
					isPieceMoved =false;
					piecesPosition.get(tmp).y=y+1;
				}

			}
		}while(isPieceMoved);
		isPieceMoved =true;
		Main.nbCoup++;
	}

	private boolean isFree(int x, int y){
		if(x>0 && ((Board.caseBoard[x-1][y].getContent()==null) || (Board.caseBoard[x-1][y].getContent().team!=null && !(Board.caseBoard[x-1][y].getContent().team.equals(this.team))))){
			return true;
		}
		if(x<9 && ((Board.caseBoard[x+1][y].getContent()==null) || (Board.caseBoard[x+1][y].getContent().team!=null && !(Board.caseBoard[x+1][y].getContent().team.equals(this.team))))){
			return true;
		}
		if(y>0 && ((Board.caseBoard[x][y-1].getContent()==null) || (Board.caseBoard[x][y-1].getContent().team!=null && !(Board.caseBoard[x][y-1].getContent().team.equals(this.team))))){
			return true;
		}
		if(y<9 && ((Board.caseBoard[x][y+1].getContent()==null) || (Board.caseBoard[x][y+1].getContent().team!=null && !(Board.caseBoard[x][y+1].getContent().team.equals(this.team))))){
			return true;
		}
		return false;
	}

	private boolean[] getAuthorisedMove(int x, int y){
		boolean [] authorisedMove = {false,false,false,false};
		if(x>0 && ((Board.caseBoard[x-1][y].getContent()==null) || (Board.caseBoard[x-1][y].getContent().team!=null && !(Board.caseBoard[x-1][y].getContent().team.equals(this.team))))){
			authorisedMove[0]=true;
		}
		if(x<9 && ((Board.caseBoard[x+1][y].getContent()==null) || (Board.caseBoard[x+1][y].getContent().team!=null && !(Board.caseBoard[x+1][y].getContent().team.equals(this.team))))){
			authorisedMove[1]=true;
		}
		if(y>0 && ((Board.caseBoard[x][y-1].getContent()==null) || (Board.caseBoard[x][y-1].getContent().team!=null && !(Board.caseBoard[x][y-1].getContent().team.equals(this.team))))){
			authorisedMove[2]=true;
		}
		if(y<9 && ((Board.caseBoard[x][y+1].getContent()==null) || (Board.caseBoard[x][y+1].getContent().team!=null && !(Board.caseBoard[x][y+1].getContent().team.equals(this.team))))){
			authorisedMove[3]=true;
		}
		return authorisedMove;
	}

	public static void debug(ArrayList<Tuple> P){
		for(Tuple i : P)
			System.out.println(i);
	}



}
