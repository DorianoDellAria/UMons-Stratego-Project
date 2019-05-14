import board.Board;
import board.Main;
import pieces.*;
import junit.framework.TestCase;

import static board.Main.*;


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


        t.caseBoard[5][5].setContent(scoutR);
        t.caseBoard[5][6].setContent(scoutR);
        scoutR.move(5,5,5,7);                       //test move pour une pièce scout passant par dessus une pièce
        assertNull(t.caseBoard[5][7].getContent());
        assertSame(t.caseBoard[5][5].getContent(),scoutR);
    }

    @org.junit.Test
    public static void testCheckGameOver(){

        Board t2=new Board();
        final Bomb bombB=new Bomb(Team.Blue);
        final Bomb bombR=new Bomb(Team.Red);
        final Flag flagB=new Flag(Team.Blue);
        final Spy spyR =new Spy(Team.Red);
        final Spy spyB =new Spy(Team.Blue);
        final Flag flagR=new Flag(Team.Red);
        final Miner minerR=new Miner(Team.Red);
        final Miner minerB=new Miner(Team.Blue);
        final Obstacle obstacle=new Obstacle();


        //test cas de base

        t2.caseBoard[0][0].setContent(flagB);
        t2.caseBoard[2][2].setContent(spyB);
        t2.caseBoard[8][8].setContent(flagR);
        t2.caseBoard[7][8].setContent(spyR);
        Main.isGameStarted=true;
        checkGameOver();
        assertTrue(isGameStarted);
        t2.cleanBoard();

        //test flag de Team Blue entouré par des bombes et/ou obstacles et miner de Team Red en jeu

        t2.caseBoard[1][0].setContent(bombB);
        t2.caseBoard[0][0].setContent(flagB);
        t2.caseBoard[0][1].setContent(obstacle);
        t2.caseBoard[2][2].setContent(spyB);
        t2.caseBoard[8][8].setContent(flagR);
        t2.caseBoard[7][7].setContent(minerR);
        Main.isGameStarted=true;
        checkGameOver();
        assertTrue(isGameStarted);
        t2.cleanBoard();


        //test flag de Team Red entouré par des bombes et/ou obstacles et miner de Team Blue en jeu

        t2.caseBoard[1][0].setContent(bombR);
        t2.caseBoard[0][0].setContent(flagR);
        t2.caseBoard[0][1].setContent(obstacle);
        t2.caseBoard[2][2].setContent(spyR);
        t2.caseBoard[8][8].setContent(flagB);
        t2.caseBoard[7][7].setContent(minerB);
        Main.isGameStarted=true;
        checkGameOver();
        assertTrue(isGameStarted);
        t2.cleanBoard();


        //test flag de Team Blue bloqué et pas de miner de Team Red en jeu


        t2.caseBoard[1][0].setContent(bombB);
        t2.caseBoard[0][0].setContent(flagB);
        t2.caseBoard[0][1].setContent(obstacle);
        t2.caseBoard[2][2].setContent(spyB);
        t2.caseBoard[8][8].setContent(flagR);
        t2.caseBoard[7][8].setContent(spyR);
        Main.isGameStarted=true;
        checkGameOver();
        assertSame(displayTeam, Team.Blue);
        assertFalse(isGameStarted);
        t2.cleanBoard();

        //test flag de Team Red bloqué et pas de miner de Team Blue en jeu


        t2.caseBoard[1][0].setContent(bombR);
        t2.caseBoard[0][0].setContent(flagR);
        t2.caseBoard[0][1].setContent(obstacle);
        t2.caseBoard[2][2].setContent(spyR);
        t2.caseBoard[8][8].setContent(flagB);
        t2.caseBoard[7][8].setContent(spyB);
        Main.isGameStarted=true;
        checkGameOver();
        assertSame(displayTeam, Team.Red);
        assertFalse(isGameStarted);
        t2.cleanBoard();

        //test pas de piece de Team Blue qui peuvent bouger
        t2.caseBoard[1][0].setContent(flagB);
        t2.caseBoard[0][1].setContent(obstacle);
        t2.caseBoard[0][0].setContent(spyB);
        t2.caseBoard[8][8].setContent(flagR);
        t2.caseBoard[7][8].setContent(minerR);
        Main.isGameStarted=true;
        checkGameOver();
        assertSame(displayTeam, Team.Red);
        assertFalse(isGameStarted);
        t2.cleanBoard();

        //test pas de piece de Team Red qui peuvent bouger
        t2.caseBoard[1][0].setContent(flagR);
        t2.caseBoard[0][1].setContent(obstacle);
        t2.caseBoard[0][0].setContent(spyR);
        t2.caseBoard[8][8].setContent(flagB);
        t2.caseBoard[7][8].setContent(spyB);
        Main.isGameStarted=true;
        checkGameOver();
        assertSame(displayTeam, Team.Blue);
        assertFalse(isGameStarted);
        t2.cleanBoard();

        //test pas de flag de Team Red

        t2.caseBoard[2][2].setContent(flagB);
        t2.caseBoard[0][0].setContent(spyB);
        t2.caseBoard[7][8].setContent(spyR);
        Main.isGameStarted=true;
        checkGameOver();
        assertSame(displayTeam, Team.Blue);
        assertFalse(isGameStarted);
        t2.cleanBoard();

        //test pas de flag de Team Blue

        t2.caseBoard[2][2].setContent(flagR);
        t2.caseBoard[0][0].setContent(spyR);
        t2.caseBoard[7][8].setContent(spyB);
        Main.isGameStarted=true;
        checkGameOver();
        assertSame(displayTeam, Team.Red);
        assertFalse(isGameStarted);
        t2.cleanBoard();

    }

    public static void main(String[] arg){
        testfight();
        testMove();
        testCheckGameOver();
    }
}

