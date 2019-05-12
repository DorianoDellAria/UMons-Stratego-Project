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

    }

    public static void main(String[] arg){
        testfight();
    }
}

