import model.DrinkingBalance;
import model.DrinkHistory;
import model.DrinkingBalance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit tests for DrinkHistory class
public class DrinkHistoryTest {
    private DrinkHistory emptyHistory;
    private DrinkingBalance balance = new DrinkingBalance(1,1,2021);

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
}
