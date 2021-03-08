import model.DrinkingBalance;
import model.Medal;
import model.TodayDrinkingGoal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedalTest {
    private Medal medal;

    @BeforeEach
    public void runBefore(){
        medal = new Medal();
    }


    @Test
    public void testCleanFormatSingle() {
        int i = 1;
        assertEquals("" + "0" + 1, medal.cleanFormat(i));
    }

    @Test
    public void testCleanFormatDualWithZero() {
        int i = 01;
        assertEquals("" + "0" + i, medal.cleanFormat(i));
    }

    @Test
    public void testCleanFormatDualWithoutZero() {
        int i = 10;
        assertEquals("" + i, medal.cleanFormat(i));
    }
}
