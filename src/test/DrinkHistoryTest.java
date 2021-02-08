import model.DrinkDate;
import model.DrinkHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit tests for DrinkHistory class
public class DrinkHistoryTest {
    private DrinkHistory emptyHistory;
    private DrinkDate date = new DrinkDate(1,1,2021);

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
        emptyHistory.addDate(date);
        assertEquals(1, emptyHistory.numDatesRecorded());
    }

    @Test
    public void testAddDateMultiple() {
        emptyHistory.addDate(date);
        emptyHistory.addDate(date);
        emptyHistory.addDate(date);
        assertEquals(3, emptyHistory.numDatesRecorded());
    }
}
