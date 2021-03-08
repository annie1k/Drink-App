package persistence;

// refer to Json Serialization Demo


import model.DrinkHistory;
import model.DrinkingBalance;
import model.Medal;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            DrinkHistory dh = reader.readHistory();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyHistory() {
        JsonReader reader = new JsonReader("./data/drinkApp.json");
        try {
            DrinkHistory dh = reader.readHistory();
            assertEquals("[day: 1, month: 1, year: 2000, balance: 5000]", dh.getDrinkHistory().toString());
            assertEquals(1, dh.numDatesRecorded());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralHistory() {
        JsonReader reader = new JsonReader("./data/drinkApp.json");
        try {
            DrinkHistory dh = reader.readHistory();
            assertEquals("[day: 1, month: 1, year: 2000, balance: 5000]", dh.getDrinkHistory().toString());
            List<DrinkingBalance> balances = dh.getDrinkHistory();
            List<Medal> medals = dh.getAwardsBag().getBag();

            //checkHistory();

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}