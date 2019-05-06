package ai;

import board.Board;
import pieces.*;
import pieces.Team;

import java.util.Random;

public class RandomAI {

	private Random rnd = new Random();
	private Team team;
	private boolean isPiecePlaced = true;

	public RandomAI(Team team){
		this.team = team;
	}

	public void init(){
		int [] nbPieces= {1,1,8,5,4,4,4,3,2,1,1,6};
		for(int i = 0 ; i<10;i++){
			for (int j = 0 ; j<5; j++){
				int tmp =rnd.nextInt(12);
				if (nbPieces[tmp]>0) {
					switch (tmp) {
						case 0:
					}
				}
			}
		}
	}


}
