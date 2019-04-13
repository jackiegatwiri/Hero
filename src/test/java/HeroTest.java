import org.junit.Test;
import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void Hero_instantiateCorrectly_true(){
    Hero myHero = new Hero("Superman", 45, "fly", "cryptonite");
    assertTrue(myHero instanceof Hero); //to instantiate an object for the class
    }
}
