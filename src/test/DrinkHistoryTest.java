import model.DrinkingBalance;
import model.DrinkHistory;
import model.DrinkingBalance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for DrinkHistory class
public class DrinkHistoryTest {
    private DrinkHistory emptyHistory;
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


}
