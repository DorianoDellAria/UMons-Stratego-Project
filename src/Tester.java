import pieces.*;

public class Tester {

	public static void main(String[] args){
		Piece p1 =new Major(Team.Red);
		Piece p2 =new Bomb(Team.Blue);
		System.out.println(p1.getVALUE());
		System.out.println(p2.getVALUE());
		System.out.println(p2.fight(p1));
	}

}
