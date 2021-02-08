import model.AwardsBag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit tests for FoodServiceCard class
public class AwardsBagTest {
    private AwardsBag emptyBag;

    @BeforeEach
    public void runBefore() {
        emptyBag = new AwardsBag();
    }

    @Test
    public void testAwardsBag() {
        assertEquals(0, emptyBag.numMedalsInBag());
    }

    @Test
    public void testAddRandMedalOnce() {
        emptyBag.addRandMedal();
        assertEquals(1, emptyBag.numMedalsInBag());
    }

    @Test
    public void testAddRandMedalMultiple() {
        emptyBag.addRandMedal();
        emptyBag.addRandMedal();
        emptyBag.addRandMedal();
        assertEquals(3, emptyBag.numMedalsInBag());
    }

    @Test
    public void testNumMedalsInBag() {
        //!!!
    }
}
