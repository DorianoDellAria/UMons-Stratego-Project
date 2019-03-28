import pieces.*;
import board.*;

public class Tester {

	public static void main(String[] args){
		Board t=new Board();
		t.caseBoard[1][0].setContent(new Major(Team.Red));
		t.caseBoard[1][1].setContent(new Flag(Team.Red));
		t.display();
		t.caseBoard[1][0].moveContent(t,Direction.Forward);
		System.out.println();
		t.caseBoard[0][0].moveContent(t,Direction.Right);
		t.display();
		t.caseBoard[0][1].moveContent(t,Direction.Backward);
		t.display();

	}

}

