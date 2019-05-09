import pieces.Miner;
import pieces.Team;
import junit.framework.TestCase;
import org.junit.*;

public class Test extends TestCase{

    private final Miner miner=new Miner(Team.Red);
    @org.junit.Test
    public void testgetVALUE() {
        assertEquals(miner.getVALUE(),3);
    }
}

