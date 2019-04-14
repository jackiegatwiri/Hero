import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void Squad_instantiateCorrectly_true(){
        Squad testSquad = new Squad("Epic");
        assertTrue(testSquad instanceof Squad);
    }
    @Test
    public void Squad_instantiateWithName_Epic(){
        Squad testSquad = new Squad("Epic");
        assertEquals("Epic", testSquad.getName());
    }

    @Test
    public void all_returnsAllInstanceOfSquad_true(){
        Squad firstSquad = new Squad("Epic");
        Squad secondSquad = new Squad("AntiHero");
        Squad thirdSquad = new Squad("Classical");

        assertEquals(true, Squad.all().contains(firstSquad));
        assertEquals(true, Squad.all().contains(secondSquad));
        assertEquals(true, Squad.all().contains(thirdSquad));
    }
}
