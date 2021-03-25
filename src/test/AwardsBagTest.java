import model.AwardsBag;
import model.Medal;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.net.www.content.image.png;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void testFindMedal() {
        Medal result1 = emptyBag.findMedal("day: 1, month: 1, year: 1, img: 1.png");
        assertEquals(null, result1);
    }

//    @Test
//    public void testFindMedalFirst() {
//        emptyBag.addMedal(medal1);
//        emptyBag.addMedal(medal2);
//        Medal result1 = emptyBag.findMedal("day: 1, month: 1, year: 1, img: 1.png");
//        assertEquals(null, result1);
//    }
//
//    @Test
//    public void testFindMedalSecond() {
//        emptyBag.addMedal(medal2);
//        emptyBag.addMedal(medal1);
//        Medal result1 = emptyBag.findMedal("day: 1, month: 1, year: 1, img: 1.png");
//        assertEquals(null, result1);
//    }




    @Test
    public void testToStringList() {
        emptyBag.addMedal(medal1);
        emptyBag.addMedal(medal2);
        assertEquals("day: 2, month: 2, year: 2, img: 1.png", emptyBag.getBag().get(1).toString());
        assertEquals("day: 1, month: 1, year: 1, img: 1.png", emptyBag.getBag().get(0).toString());
    }

    @Test
    public void testToStringListEmpty() {
        assertEquals("[]",emptyBag.toString());
    }

    @Test
    public void testToString() {
        assertEquals("day: 1, month: 1, year: 1, img: 1.png",medal1.toString());
        assertEquals("day: 2, month: 2, year: 2, img: 1.png",medal2.toString());
        assertEquals("day: 3, month: 3, year: 3, img: 1.png",medal3.toString());
    }



    @Test
    public void testToJson() {
        JSONObject json = new JSONObject();
        json.put("total number", emptyBag.numMedalsInBag()); // is this okay???
        json.put("medals", emptyBag.medalsToJson());
        assertEquals(json.toString(), emptyBag.toJson().toString());

    }

    @Test
    public void testMedalToJson() {
        JSONArray jsonArray = new JSONArray();
        emptyBag.addMedal(medal1);
        emptyBag.addMedal(medal2);
        emptyBag.addMedal(medal3);
        JSONObject jo1 = new JSONObject();
        JSONObject jo2 = new JSONObject();
        JSONObject jo3 = new JSONObject();
        jo1.put("day",medal1.getDay());
        jo1.put("month",medal1.getMonth());
        jo1.put("year",medal1.getYear());
        jo1.put("img",medal1.getImg());

        jo2.put("day",medal2.getDay());
        jo2.put("month",medal2.getMonth());
        jo2.put("year",medal2.getYear());
        jo2.put("img",medal2.getImg());

        jo3.put("day",medal3.getDay());
        jo3.put("month",medal3.getMonth());
        jo3.put("year",medal3.getYear());
        jo3.put("img",medal3.getImg());

        jsonArray.put(jo1);
        jsonArray.put(jo2);
        jsonArray.put(jo3);

        assertEquals(jsonArray.toString(),emptyBag.medalsToJson().toString());

    }




}
