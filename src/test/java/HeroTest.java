import org.junit.Test;

import java.time.LocalDateTime;

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
    @Test
    public void getWeakness_getWeaknessForHeroes_String(){
        Hero myHero = new Hero("Superman", 45, "fly", "cryptonite");
        String expected = "cryptonite";
        assertEquals(expected,myHero.getWeakness());
    }
    @Test
    public void getCreatedAt_getTimeWhenAHeroIsCreated_today(){
        Hero myHero = new Hero("Superman", 45, "fly", "cryptonite");
        assertEquals(LocalDateTime.now().getDayOfWeek(), myHero.getCreatedAt().getDayOfWeek());
    }
    @Test
    public void all_getAllInstancesOfTheClass_true(){
        Hero myHero = new Hero("Superman", 45, "fly", "cryptonite");
        Hero myHero2 = new Hero("Super", 55, "run", "cryptonite");
        assertEquals(true,Hero.all().contains(myHero));
        assertEquals(true, Hero.all().contains(myHero2));
    }
    @Test
    public void clear_emptyTheArrayListToZero_0() {
        Hero myHero = new Hero("Superman", 45, "fly", "cryptonite");
        Hero.clear();
        assertEquals(Hero.all().size(), 0);
    }



}
