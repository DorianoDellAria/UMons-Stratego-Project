import pieces.Miner;
import pieces.Team;
import junit.framework.TestCase;
import org.junit.*;

public class Test extends TestCase{

    private final Miner miner=new Miner(Team.Red);
    @org.junit.Test
    public static void testgetVALUE() {
        assertEquals(new Miner(Team.Red).getVALUE(),3);
    }

    public static void main(String[] arg){
        testgetVALUE();
    }
}

