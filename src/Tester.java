import pieces.*;
import board.*;

public class Tester {

	public static void main(String[] args){
		Board t=new Board();
		t.caseBoard[1][0].setContent(new Major(Team.Red));
		t.display();

	}

}

