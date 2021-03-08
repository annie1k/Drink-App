package persistence;

// refer to Json Serialization Demo

import model.DrinkHistory;
import model.DrinkingBalance;
import model.Medal;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            DrinkHistory dh = new DrinkHistory();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyHistory() {
        try {
            DrinkHistory dh = new DrinkHistory();
            JsonWriter writer = new JsonWriter("./data/drinkApp.json");
            writer.open();
            writer.write(dh);
            writer.close();

            JsonReader reader = new JsonReader("./data/drinkApp.json");
            dh = reader.readHistory();
            assertEquals("[]", dh.getDrinkHistory().toString());
            assertEquals(0, dh.numDatesRecorded());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralHistory() {
        try {
            DrinkHistory dh = new DrinkHistory();
            dh.addDate(new DrinkingBalance(1,1,2000,5000));
            JsonWriter writer = new JsonWriter("./data/drinkApp.json");
            writer.open();
            writer.write(dh);
            writer.close();

            JsonReader reader = new JsonReader("./data/drinkApp.json");
            dh = reader.readHistory();
            assertEquals("[day: 1, month: 1, year: 2000, balance: 5000]", dh.getDrinkHistory().toString());
            List<DrinkingBalance> balances = dh.getDrinkHistory();
            List<Medal> medals = dh.getAwardsBag().getBag();
            assertEquals(1, balances.size());
            assertEquals(0, medals.size());


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}