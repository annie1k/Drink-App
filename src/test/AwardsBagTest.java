import model.AwardsBag;
import model.DrinkHistory;
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
    public void testGetDrinkHistory() {
        AwardsBag bag = new AwardsBag();
        bag.addRandMedal();
        assertEquals(1,bag.getBag().size());
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
    public void testNumMedalsInBagZero() {
       assertEquals(0,emptyBag.numMedalsInBag());
    }

    @Test
    public void testNumMedalsInBagOne() {
        emptyBag.addRandMedal();
        assertEquals(1,emptyBag.numMedalsInBag());
    }

    @Test
    public void testNumMedalsInBagMultiple() {
        emptyBag.addRandMedal();
        emptyBag.addRandMedal();
        emptyBag.addRandMedal();
        emptyBag.addRandMedal();
        assertEquals(4,emptyBag.numMedalsInBag());
    }

    @Test
    public void testNumMedalsInBagMultipleMinus() {
        emptyBag.addRandMedal();
        emptyBag.addRandMedal();
        emptyBag.addRandMedal();
        emptyBag.addRandMedal();
        emptyBag.subLastMedal();
        assertEquals(3,emptyBag.numMedalsInBag());
    }

    @Test
    public void subLastMedalOne() {
        emptyBag.addRandMedal();
        emptyBag.subLastMedal();
        assertEquals(0,emptyBag.numMedalsInBag());
    }

    @Test
    public void subLastMedalMultiple() {
        emptyBag.addRandMedal();
        emptyBag.addRandMedal();
        emptyBag.addRandMedal();
        emptyBag.subLastMedal();
        emptyBag.subLastMedal();
        assertEquals(1,emptyBag.numMedalsInBag());
    }
}
