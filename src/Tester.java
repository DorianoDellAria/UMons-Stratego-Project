import pieces.*;
import board.*;

public class Tester {

	public static void main(String[] args){
		Board t=new Board();
		t.caseBoard[1][0].setContent(new Major(Team.Red));
		t.caseBoard[1][1].setContent(new Flag(Team.Red));
		t.display();
		t.caseBoard[1][0].getContent().move(t,1,0,Direction.Forward);
		System.out.println();
		t.display();

	}

}

