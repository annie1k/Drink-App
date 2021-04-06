import model.DrinkingBalance;
import model.DrinkingGoal;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for TodayDrinkingBalanceTest class
public class DrinkingBalanceTest {
    private DrinkingBalance balance;
    private DrinkingBalance balance2;
    private DrinkingGoal goal;
    private int year;
    private int month;
    private int day;
    private int CHANGE_VALUE = 1;
    private int INITIAL_VALUE = 500;

    @BeforeEach
    public void runBefore(){
        balance = new DrinkingBalance(1,1,2021);
        goal = new DrinkingGoal(INITIAL_VALUE);
        year = 2021;
        day = 1;
        month = 1;
    }

    @Test
    public void testTodayDrinkingBalance() {
        balance.addValue(CHANGE_VALUE);
        String actual = balance.getDate();
        assertEquals(CHANGE_VALUE, balance.getBalance());
        assertEquals("01-01-2021", actual);
    }

    @Test
    public void testDrinkingBalance() {
        balance2 = new DrinkingBalance(1,1,2021,500);
        balance2.addValue(CHANGE_VALUE);
        String actual = balance2.getDate();
        assertEquals(CHANGE_VALUE + 500, balance2.getBalance());
        assertEquals("01-01-2021", actual);
    }

    @Test
    public void testAddBalance() {
        balance.addValue(CHANGE_VALUE);
        assertEquals( CHANGE_VALUE, balance.getBalance());
    }

    @Test
    //this is actually a constructor
    public void testAddGoal() {
        balance.addGoal(INITIAL_VALUE);
        assertEquals(INITIAL_VALUE, this.goal.getGoal());
    }

    @Test
    public void testSubBalanceSmall() {
        balance.addValue(INITIAL_VALUE);
        balance.subValue(CHANGE_VALUE);
        assertEquals(INITIAL_VALUE - CHANGE_VALUE, balance.getBalance());
    }

    @Test
    public void testSubBalanceMiddle() {
        balance.addValue(INITIAL_VALUE);
        balance.subValue(CHANGE_VALUE / 2);
        assertEquals(INITIAL_VALUE - CHANGE_VALUE / 2, balance.getBalance());
    }


    @Test
    public void testSubBalanceMAX() {
        balance.addValue(INITIAL_VALUE);
        balance.subValue(INITIAL_VALUE);
        assertEquals(0, balance.getBalance());
    }

    @Test
    public void testIsAchievedFail() {
        balance.addValue(INITIAL_VALUE - CHANGE_VALUE);
        assertFalse(balance.isAchieved());
    }

    @Test
    public void testIsAchievedEqualSuccess() {
        balance.addValue(INITIAL_VALUE);
        assertTrue(balance.isAchieved());
    }

    @Test
    public void testIsAchievedOverSuccess() {
        balance.addValue(INITIAL_VALUE + CHANGE_VALUE);
        assertTrue(balance.isAchieved());
    }

    @Test
    public void testGetData() {
        String actual = balance.getDate();
        assertEquals("01-01-2021",actual);
    }

    @Test
    public void testCleanFormatSingle() {
        int i = 1;
        assertEquals("" + "0" + 1, balance.cleanFormat(i));
    }

    @Test
    public void testCleanFormatDualWithZero() {
        int i = 01;
        assertEquals("" + "0" + i, balance.cleanFormat(i));
    }

    @Test
    public void testCleanFormatDualWithoutZero() {
        int i = 10;
        assertEquals("" + i, balance.cleanFormat(i));
    }

    @Test
    public void testCombineDateBalanceZero() {
        String date = balance.getDate();
        assertEquals(date +" corresponding balance: "+ balance.getBalance(),balance.combineDateBalance());

    }

    @Test
    public void testCombineDateBalanceChange() {
        balance.addValue(CHANGE_VALUE);
        String date = balance.getDate();
        assertEquals(date +" corresponding balance: "+ balance.getBalance(),balance.combineDateBalance());

    }
    @Test
    public void testCombineDateBalanceChangeMultiple() {
        balance.addValue(CHANGE_VALUE*5);
        String date = balance.getDate();
        assertEquals(date +" corresponding balance: "+ balance.getBalance(),balance.combineDateBalance());

    }

    @Test
    public void testToJson() {
        JSONObject json = new JSONObject();
        JSONObject jsonDate = new JSONObject();
        jsonDate.put("day", day);
        jsonDate.put("month", month);
        jsonDate.put("year", year);
        json.put("date", jsonDate);
        json.put("balance", balance.getBalance());
        json.put("goal", goal.toJson());
        assertEquals(json.toString(), balance.toJson().toString());

    }

    @Test
    public void testToString() {
        assertEquals("day: 1, month: 1, year: 2021, balance: 0",balance.toString());
    }

    @Test
    public void testGetGoal() {
        assertEquals(500,balance.getGoal().getGoal());
    }



}

