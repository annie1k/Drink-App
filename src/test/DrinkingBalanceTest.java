import model.DrinkingBalance;
import model.TodayDrinkingGoal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for TodayDrinkingBalanceTest class
public class DrinkingBalanceTest {
    private DrinkingBalance balance;
    private TodayDrinkingGoal goal;
    private int CHANGE_VALUE = 1;
    private int INITIAL_VALUE = 500;

    @BeforeEach
    public void runBefore(){
        balance = new DrinkingBalance(1,1,2021);
        goal = new TodayDrinkingGoal(INITIAL_VALUE);
    }

    @Test
    public void testTodayDrinkingBalance() {
        balance.addBalance(CHANGE_VALUE);
        String actual = balance.getDate();
        assertEquals(CHANGE_VALUE, balance.getBalance());
        assertEquals("01-01-2021", actual);
    }

    @Test
    public void testAddBalance() {
        balance.addBalance(CHANGE_VALUE);
        assertEquals( CHANGE_VALUE, balance.getBalance());
    }

    @Test
    public void testSubBalanceSmall() {
        balance.addBalance(INITIAL_VALUE);
        balance.subBalance(CHANGE_VALUE);
        assertEquals(INITIAL_VALUE - CHANGE_VALUE, balance.getBalance());
    }

    @Test
    public void testSubBalanceMiddle() {
        balance.addBalance(INITIAL_VALUE);
        balance.subBalance(CHANGE_VALUE / 2);
        assertEquals(INITIAL_VALUE - CHANGE_VALUE / 2, balance.getBalance());
    }

    @Test
    public void testSubBalanceMAX() {
        balance.addBalance(INITIAL_VALUE);
        balance.subBalance(INITIAL_VALUE);
        assertEquals(0, balance.getBalance());
    }

    @Test
    public void testIsAchievedFail() {
        balance.addBalance(INITIAL_VALUE - CHANGE_VALUE);
        assertFalse(balance.isAchieved());
    }

    @Test
    public void testIsAchievedEqualSuccess() {
        balance.addBalance(INITIAL_VALUE);
        assertTrue(balance.isAchieved());
    }

    @Test
    public void testIsAchievedOverSuccess() {
        balance.addBalance(INITIAL_VALUE + CHANGE_VALUE);
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
        balance.addBalance(CHANGE_VALUE);
        String date = balance.getDate();
        assertEquals(date +" corresponding balance: "+ balance.getBalance(),balance.combineDateBalance());

    }
    @Test
    public void testCombineDateBalanceChangeMultiple() {
        balance.addBalance(CHANGE_VALUE*5);
        String date = balance.getDate();
        assertEquals(date +" corresponding balance: "+ balance.getBalance(),balance.combineDateBalance());

    }
}

