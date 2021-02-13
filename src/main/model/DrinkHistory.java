package model;

// This is the water drinking history which collects all the drink date with balance

import java.util.ArrayList;
import java.util.List;

public class DrinkHistory {
    // changing properties of DrinkingHistory
    // list of date that drinks with drinking amount
    private List<DrinkingBalance> drinkHistory;


    // EFFECTS: constructs an empty history, which is list of drinking dates
    public DrinkHistory() {
        this.drinkHistory = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a new drink balance date to the drinking history dates
    public void addDate(DrinkingBalance drinkHistory) {
        this.drinkHistory.add(drinkHistory);
    }

    // EFFECTS: returns number of dates in history recorded
    public int numDatesRecorded() {
        return this.drinkHistory.size();
    }

}
