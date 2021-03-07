import model.AwardsBag;
import model.Medal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit tests for FoodServiceCard class
public class AwardsBagTest {
    private AwardsBag emptyBag;
    private Medal medal1;
    private Medal medal2;
    private Medal medal3;
    int day1 = 1;
    int month1 = 1;
    int year1 = 1;
    int day2 = 2;
    int month2 = 2;
    int year2 = 2;
    int day3 = 3;
    int month3 = 3;
    int year3 = 3;
    String date1 = "1-1-1";
    String date2 = "2-2-2";
    String date3 = "3-3-3";
    String img = "1.png";

    @BeforeEach
    public void runBefore() {
        emptyBag = new AwardsBag();
        medal1 = new Medal();
        medal2 = new Medal();
        medal3 = new Medal();
        medal1.setImg(img);
        medal1.setDay(day1);
        medal1.setMonth(month1);
        medal1.setYear(year1);
        medal2.setImg(img);
        medal2.setDay(day2);
        medal2.setMonth(month2);
        medal2.setYear(year2);
        medal3.setImg(img);
        medal3.setDay(day3);
        medal3.setMonth(month3);
        medal3.setYear(year3);
    }

    @Test
    public void testAwardsBag() {
        assertEquals(0, emptyBag.numMedalsInBag());
    }

    @Test
    public void testGetDrinkHistory() {
        AwardsBag bag = new AwardsBag();
        bag.addRandMedal(day1, month1, year1);
        assertEquals(1,bag.getBag().size());
    }

    @Test
    public void testAddRandMedalOnce() {
        emptyBag.addRandMedal(day1, month1, year1);
        assertEquals(1, emptyBag.numMedalsInBag());
    }

    @Test
    public void testAddRandMedalMultiple() {
        emptyBag.addRandMedal(day1, month1, year1);
        emptyBag.addRandMedal(day2, month2, year2);
        emptyBag.addRandMedal(day3, month3, year3);
        assertEquals(3, emptyBag.numMedalsInBag());
    }

    @Test
    public void testNumMedalsInBagZero() {
       assertEquals(0,emptyBag.numMedalsInBag());
    }

    @Test
    public void testNumMedalsInBagOne() {
        emptyBag.addRandMedal(day1, month1, year1);
        assertEquals(1,emptyBag.numMedalsInBag());
    }

    @Test
    public void testNumMedalsInBagMultiple() {
        emptyBag.addRandMedal(day1, month1, year1);
        emptyBag.addRandMedal(day2, month2, year2);
        emptyBag.addRandMedal(day3, month3, year3);
        assertEquals(3,emptyBag.numMedalsInBag());
    }

    @Test
    public void testNumMedalsInBagMultipleRemoveOne() {
        emptyBag.addMedal(medal1);
        emptyBag.addMedal(medal2);
        emptyBag.addMedal(medal3);
        emptyBag.removeMedal(medal1);
        assertEquals(2,emptyBag.numMedalsInBag());
    }

    @Test
    public void testRemoveMedalOne() {
        emptyBag.addMedal(medal1);
        emptyBag.removeMedal(medal1);
        assertEquals(0,emptyBag.numMedalsInBag());
    }

    @Test
    public void testSubLastMedalMultiple() {
        emptyBag.addMedal(medal1);
        emptyBag.addMedal(medal2);
        emptyBag.addMedal(medal3);
        emptyBag.removeMedal(medal1);
        emptyBag.removeMedal(medal2);
        assertEquals(1,emptyBag.numMedalsInBag());
    }

//    @Test
//    public void testFindMedal() {
//        emptyBag.addMedal(medal1);
//        emptyBag.addMedal(medal2);
//        emptyBag.addMedal(medal3);
//        result1 = emptyBag.findMedal
//        assertEquals(medal1,);
//    }





}
