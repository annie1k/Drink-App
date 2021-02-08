import model.DrinkDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit tests for DrinkDate class
public class DrinkDateTest {
    private DrinkDate date;

    @BeforeEach
    public void runBefore() {
        date = new DrinkDate(1, 1, 2021);
    }

    @Test
    public void testGetData() {
        String actual = date.getDate();
        assertEquals("01-01-2021",actual);
    }

    @Test
    public void testCleanFormatSingle() {
        int i = 1;
        assertEquals("" + "0" + 1, date.cleanFormat(i));
    }

    @Test
    public void testCleanFormatDualWithZero() {
        int i = 01;
        assertEquals("" + "0" + i, date.cleanFormat(i));
    }

    @Test
    public void testCleanFormatDualWithoutZero() {
        int i = 10;
        assertEquals("" + i, date.cleanFormat(i));
    }
}
