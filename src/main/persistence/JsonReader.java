package persistence;

import model.AwardsBag;
import model.DrinkHistory;
import model.DrinkingBalance;
import model.TodayDrinkingGoal;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.json.*;

//refer to JsonSerializationDemo
// Represents a reader that reads drink history and awards bag from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads drink history from file and returns it;
    // throws IOException if an error occurs reading data from file
    public DrinkHistory readHistory() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseDrinkHistory(jsonObject);
    }



    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses drink history from JSON object and returns it
    private DrinkHistory parseDrinkHistory(JSONObject jsonObject) {
        DrinkHistory dh = new DrinkHistory();

        addBalances(dh, jsonObject);

        addMedals(dh, jsonObject);

        return dh;
    }

    //
    private void addMedals(DrinkHistory dh, JSONObject jsonObject) {
        JSONObject awardBag = jsonObject.getJSONObject("bag");
        JSONArray medals = awardBag.getJSONArray("medals");

        AwardsBag ab = new AwardsBag();

        for (int i = 0; i < medals.length(); i++) {
            String medal = (String) medals.get(i);
            ab.addMedal(medal);
        }
        dh.setAwardsBag(ab);
    }


    // MODIFIES: dh
    // EFFECTS: parses balances from JSON object and adds them to history
    private void addBalances(DrinkHistory dh, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("balances");
        for (Object json : jsonArray) {
            JSONObject nextBalance = (JSONObject) json;
            addBalance(dh, nextBalance);
        }
    }

    // MODIFIES: dh
    // EFFECTS: parses balance from JSON object and adds it to drink history
    private void addBalance(DrinkHistory dh, JSONObject jsonObject) {

        int balance = jsonObject.getInt("balance");
        JSONObject jsonDate = jsonObject.getJSONObject("date");
        int day = jsonDate.getInt("day");
        int month = jsonDate.getInt("month");
        int year = jsonDate.getInt("year");

        JSONObject jsonGoal = jsonObject.getJSONObject("goal");
        int goal = jsonGoal.getInt("goal");



        DrinkingBalance drinkingBalance = new DrinkingBalance(day, month, year);
        drinkingBalance.addBalance(balance);
        drinkingBalance.addGoal(goal);

        dh.addDate(drinkingBalance);
    }




//    // EFFECTS: reads awards bag from file and returns it;
//    // throws IOException if an error occurs reading data from file
//    public AwardsBag readAwards() throws IOException {
//        String jsonData = readFile(source);
//        JSONObject jsonObject = new JSONObject(jsonData);
//        return parseAwardsBag(jsonObject);
//    }
//
//
//    // EFFECTS: parses medal bag from JSON object and returns it
//    private AwardsBag parseAwardsBag(JSONObject jsonObject) {
//        AwardsBag ab = new AwardsBag();
//        addMedals(ab, jsonObject);
//        return ab;
//    }
//
//    // MODIFIES: ab
//    // EFFECTS: parses medals from JSON object and adds them to award bag
//    private void addMedals(AwardsBag ab, JSONObject jsonObject) {
//        JSONArray jsonArray = jsonObject.getJSONArray("Awards");
//        for (Object json : jsonArray) {
//            JSONObject nextMedal = (JSONObject) json;
//            addMedal(ab, nextMedal);
//        }
//    }
//
//    // MODIFIES: ab
//    // EFFECTS: parses medal from JSON object and adds it to award bag
//    private void addMedal(AwardsBag ab, JSONObject jsonObject) {
//        ab.addRandMedal();
//    }

}
