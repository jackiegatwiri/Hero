import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void Squad_instantiateCorrectly_true(){
        Squad testSquad = new Squad("Epic", 6, "mission");
        assertTrue(testSquad instanceof Squad);
    }
    @Test
    public void Squad_instantiateWithName_Epic(){
        Squad testSquad = new Squad("Epic", 9, "miss");
        assertEquals("Epic", testSquad.getName());
    }

    @Test
    public void all_returnsAllInstanceOfSquad_true(){
        Squad firstSquad = new Squad("Epic", 7, "miss");
        Squad secondSquad = new Squad("AntiHero", 7, "miss");
        Squad thirdSquad = new Squad("Classical",8, "nixx");

        assertEquals(true, Squad.all().contains(firstSquad));
        assertEquals(true, Squad.all().contains(secondSquad));
        assertEquals(true, Squad.all().contains(thirdSquad));
    }


    @Test
    public void Squad_clearSquadFromList_0(){ //see if clear works
        Squad testSquad = new Squad("Epic",6,"mission");
        Squad.clear();
        assertEquals(Squad.all().size(), 0);
    }


    @Test
    public void getId_instantiateWithName_1(){
        Squad.clear();
        Squad testSquad = new Squad("Epic", 7, "mission"); //clear all tests then test if Epic will have an id of 1
        assertEquals(1, testSquad.getId());
    }
    @Test
    public void find_returnsSquadWithTheSameId_SecondSquad(){
        Squad firstSquad = new Squad("Epic", 8, "mission"); //find the squad using id
        Squad secondSquad = new Squad("AntiHero", 7, "miss");
        assertEquals(Squad.find(secondSquad.getId()), secondSquad);
    }
    @Test
    public void getHeroes_initiallyReturnsAnEmptyList_ArrayList(){
        Squad.clear();
        Squad testSquad = new Squad("Epic", 8, "mission");
        assertEquals(0, testSquad.getHeroes().size());
    }
    @Test
    public void addHero_addsHeroToList_true(){
        Squad testSquad = new Squad("Epic", 6, "miss"); //find the squad using id
        Hero testHero = new Hero("Superman", 45, "fly", "cryptonite");
        testSquad.addHero(testHero);
        assertTrue(testSquad.getHeroes().contains(testHero));
    }
}
