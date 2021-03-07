package model;

// This is the water drinking history which collects all the drink date with balance

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.List;

public class DrinkHistory implements Writable {
    // changing properties of DrinkingHistory
    // list of date that drinks with drinking amount
    private List<DrinkingBalance> drinkHistory;
    private AwardsBag awardsBag = new AwardsBag();

    //
    public AwardsBag getAwardsBag() {
        return this.awardsBag;
    }

    //
    public AwardsBag setAwardsBag(AwardsBag ab) {
        this.awardsBag = ab;
        return ab;
    }


    // EFFECTS: constructs an empty history, which is list of drinking dates
    public DrinkHistory() {
        this.drinkHistory = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a new drink balance date to the drinking history dates
    public void addDate(DrinkingBalance newDrinkBalance) {
        this.drinkHistory.add(newDrinkBalance);
    }

    // EFFECTS: returns number of dates in history recorded
    public int numDatesRecorded() {
        return this.drinkHistory.size();
    }

    // EFFECT: return the history
    public List<DrinkingBalance> getDrinkHistory() {
        return this.drinkHistory;
    }



    // EFFECT: add and return the drinking balance if it is not in the history, if exist, just return the original one
    public DrinkingBalance findBalance(String date) {
        for (DrinkingBalance balance: drinkHistory) {
            String historyDate = balance.getDate();

            if (date.equals(historyDate)) {
                return balance;
            }
        }
        return null;
    }



    //EFFECTS: return json
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("balances", balancesToJson());
        json.put("bag", awardsBag.toJson());
        return json;
    }

    // EFFECTS: returns balances in this history as a JSON array
    private JSONArray balancesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (DrinkingBalance b : drinkHistory) {
            jsonArray.put(b.toJson());
        }

        return jsonArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (DrinkingBalance db: drinkHistory) {
            sb.append(db.toString());
            sb.append(awardsBag.toString());
            sb.append("\n");

        }
        return sb.toString();
    }
}
