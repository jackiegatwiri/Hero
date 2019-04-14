import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void Squad_instantiateCorrectly_true(){
        Squad testSquad = new Squad("Epic");
        assertTrue(testSquad instanceof Squad);
    }
}
