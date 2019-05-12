import board.Board;
import pieces.*;
import junit.framework.TestCase;


public class Test extends TestCase{


    @org.junit.Test
    public static void testfight (){

        final Marshal marshalB=new Marshal(Team.Blue);
        final Marshal marshalR=new Marshal(Team.Red);
        final Spy spyR =new Spy(Team.Red);
        final Miner minerR=new Miner(Team.Red);
        final Miner minerB=new Miner(Team.Blue);
        final Bomb bombB=new Bomb(Team.Blue);

        assertSame(minerB.fight(marshalB),marshalB);        //test fight pour cas de base
        assertSame(spyR.fight(minerB),minerB);

        assertSame(spyR.fight(marshalB),spyR);              //test fight pour cas spy/marshal
        assertSame(marshalB.fight(spyR),marshalB);

        assertSame(minerR.fight(bombB),minerR);             //test fight pour cas bomb/miner
        assertSame(marshalR.fight(bombB),bombB);

        assertNull(marshalB.fight(marshalR));               //test fight pour cas de rangs égaux

    }

    @org.junit.Test
    public static void testMove(){
        Board t=new Board();
        final Marshal marshalB=new Marshal(Team.Blue);
        final Scout scoutR=new Scout(Team.Blue);
        final Bomb bombB =new Bomb(Team.Red);
        final Miner minerB=new Miner(Team.Blue);
        final Miner minerR=new Miner(Team.Red);


        t.caseBoard[1][1].setContent(marshalB);
        marshalB.move(1,1,2,1);                     //test move pour une pièce de base et déplacement d'une case
        assertNull(t.caseBoard[1][1].getContent());
        assertSame(t.caseBoard[2][1].getContent(),marshalB);


        t.caseBoard[3][1].setContent(marshalB);
        marshalB.move(3,1,3,3 );                    //test move pour une pièce de base et déplacement de plusieurs cases
        assertSame(t.caseBoard[3][1].getContent(),marshalB);
        assertNull(t.caseBoard[3][3].getContent());


        t.caseBoard[2][2].setContent(scoutR);
        scoutR.move(2,2,5,2);                       //test move pour une pièce scout et déplacement de plusieurs cases
        assertNull(t.caseBoard[2][2].getContent());
        assertSame(t.caseBoard[5][2].getContent(),scoutR);


        t.caseBoard[5][1].setContent(marshalB);
        t.caseBoard[6][1].setContent(minerB);
        marshalB.move(5,1,6,1 );                    //test move pour une pièce sur une case occupée par une piece de même Team
        assertSame(t.caseBoard[5][1].getContent(),marshalB);
        assertSame(t.caseBoard[6][1].getContent(),minerB);


        t.caseBoard[7][1].setContent(marshalB);
        t.caseBoard[8][1].setContent(minerR);
        marshalB.move(7,1,8,1 );                    //test move pour une pièce sur une case occupée par une piece de Team adverse
        assertNull(t.caseBoard[7][1].getContent());                 //voir testfight() pour plus de cas
        assertSame(t.caseBoard[8][1].getContent(),marshalB);
    }

    public static void main(String[] arg){
        testfight();
        testMove();
    }
}

