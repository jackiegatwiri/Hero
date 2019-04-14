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


    @Test
    public void Squad_clearSquadFromList_0(){
        Squad testSquad = new Squad("Epic");
        Squad.clear();
        assertEquals(Squad.all().size(), 0);
    }


    @Test
    public void getId_instantiateWithName_1(){
        Squad.clear();
        Squad testSquad = new Squad("Epic");
        assertEquals(1, testSquad.getId());
    }
}
