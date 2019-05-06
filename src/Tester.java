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
* https://www.freepng.fr/png-b68os7/ image spy
* https://www.freepng.fr/png-g5v37u/ image flag
* https://www.freepng.fr/png-7bhy7f/ image obstacle
* https://unixtitan.net/explore/viking-svg-decal/#gal_post_9265_viking-svg-decal-4.png image logo
* */

