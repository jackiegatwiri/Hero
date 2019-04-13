import org.junit.Test;
import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void Hero_instantiateCorrectly_true(){
    Hero myHero = new Hero("Superman", 45, "fly", "cryptonite");
    assertTrue(myHero instanceof Hero); //to instantiate an object for the class
    }
    @Test
    public void getName_getNameForHeroes_String(){
        Hero myHero = new Hero("Superman", 45, "fly", "cryptonite");
        String expected = "Superman";
        assertEquals(expected,myHero.getName());
    }
    @Test
    public void getAge_getAgeForHeroes_int(){
        Hero myHero = new Hero("Superman", 45, "fly", "cryptonite");
        int expected = 45;
        assertEquals(expected,myHero.getAge());
    }
    @Test
    public void getPower_getPowerForHeroes_String(){
        Hero myHero = new Hero("Superman", 45, "fly", "cryptonite");
        String expected = "fly";
        assertEquals(expected,myHero.getPower());
    }


}
