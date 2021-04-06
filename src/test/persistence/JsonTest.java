package persistence;

// refer to Json Serialization Demo


import model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkHistory(DrinkingBalance balance, AwardsBag bag, DrinkHistory history, DrinkingGoal goal,
                                Medal medal, String dateb, String datem) {
        assertEquals(bag, history.getAwardsBag());
        assertEquals(balance, balance.getBalance());
        assertEquals(goal, balance.getGoal());
        //assertEquals(medal, medal.);
        assertEquals(dateb, balance.getDate());
        assertEquals(datem, medal.getDate());
        assertEquals(history, history.getDrinkHistory());
    }
}
