import pieces.*;
import board.*;

public class Tester {

	public static void main(String[] args){
		Board t=new Board();
		t.caseBoard[1][0].setContent(new Major(Team.Red));
		t.display();

	}

}

/*https://www.freepng.fr/png-u5kfj5/ image rank
* https://www.freepng.fr/png-nj6nu8/ image bomb
* https://www.freepng.fr/png-oups5b/ image spy
* https://www.freepng.fr/png-yqh38c/ image spy 2
* https://www.freepng.fr/png-b68os7/ image spy 3
* https://www.freepng.fr/png-g5v37u/ image flag
* https://www.freepng.fr/png-7bhy7f/ image obstacle
* */

