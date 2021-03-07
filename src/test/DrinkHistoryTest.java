import model.AwardsBag;
import model.DrinkingBalance;
import model.DrinkHistory;
import model.DrinkingBalance;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for DrinkHistory class
public class DrinkHistoryTest {
    private DrinkHistory emptyHistory;
    private AwardsBag bag;
    private DrinkingBalance balance = new DrinkingBalance(1,1,2021);
    private DrinkingBalance balance1 = new DrinkingBalance(1,2,2001);
    private DrinkingBalance balance2 = new DrinkingBalance(3,4,2002);
    private DrinkingBalance balance3 = new DrinkingBalance(5,6,2003);

    @BeforeEach
    public void runBefore() {
        emptyHistory = new DrinkHistory();
    }

    @Test
    public void testDrinkHistory() {
        assertEquals(0, emptyHistory.numDatesRecorded());
    }

    @Test
    public void testAddDateOnce() {
        emptyHistory.addDate(balance);
        assertEquals(1, emptyHistory.numDatesRecorded());
    }

    @Test
    public void testAddDateMultiple() {
        emptyHistory.addDate(balance);
        emptyHistory.addDate(balance);
        emptyHistory.addDate(balance);
        assertEquals(3, emptyHistory.numDatesRecorded());
    }

    @Test
    public void testGetDrinkHistory() {
        DrinkHistory history = new DrinkHistory();
        history.addDate(balance);
        assertEquals(1,history.getDrinkHistory().size());
    }

    @Test
    public void testFindBalanceSingleSuccess() {
        DrinkHistory history = new DrinkHistory();
        history.addDate(balance1);
        assertEquals(balance1, history.findBalance("01-02-2001"));
    }

    @Test
    public void testFindBalanceSingleFail() {
        DrinkHistory history = new DrinkHistory();
        history.addDate(balance2);
        assertNotEquals(balance2, history.findBalance("01-02-2001"));
    }

    @Test
    public void testFindBalanceMultipleSuccess() {
        DrinkHistory history = new DrinkHistory();
        history.addDate(balance1);
        history.addDate(balance2);
        history.addDate(balance3);
        assertEquals(balance1, history.findBalance("01-02-2001"));
    }

    @Test
    public void testFindBalanceMultipleFail() {
        DrinkHistory history = new DrinkHistory();
        history.addDate(balance1);
        history.addDate(balance2);
        history.addDate(balance3);
        assertNotEquals(balance2, history.findBalance("01-02-2001"));
    }

    @Test
    public void testGetAwardsBag() {
        bag = new AwardsBag();
        assertEquals(bag.getBag().toString(),emptyHistory.getAwardsBag().toString());
    }

    @Test
    public void testSetAwardsBag() {
        bag = new AwardsBag();
        assertEquals(bag, emptyHistory.setAwardsBag(bag));
    }

    @Test
    public void testToStringEmpty() {
        assertEquals("", emptyHistory.toString());
    }

    @Test
    public void testToStringOne() {
        emptyHistory.addDate(balance1);
        assertEquals("[day: 1, month: 2, year: 2001, balance: 0]", emptyHistory.getDrinkHistory().toString());
    }

    @Test
    public void testToStringMelti() {
        emptyHistory.addDate(balance1);
        emptyHistory.addDate(balance2);
        assertEquals("[day: 1, month: 2, year: 2001, balance: 0, day: 3, month: 4, year: 2002, balance: 0]",
                emptyHistory.getDrinkHistory().toString());
    }

//    @Test
//    public void testToJson() {
//        JSONObject json = new JSONObject();
//        json.put("balances", emptyHistory.balancesToJson());
//        json.put("bag", emptyHistory.toJson());
//        assertEquals(json.toString(), emptyHistory.toJson().toString());
//    }


}
