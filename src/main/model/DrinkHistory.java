package model;

// This is the water drinking history which collects all the drink date

import java.util.ArrayList;
import java.util.List;

public class DrinkHistory {
    // changing properties of DrinkingHistory
    // list of date that drinks
    private List<DrinkDate> dates;


    // EFFECTS: constructs an empty history, which is list of drinking dates
    public DrinkHistory() {
        this.dates = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a new date to the drinking history dates
    public void addDate(DrinkDate date) {
        this.dates.add(date);
    }

    // EFFECTS: returns number of dates in history recorded
    public int numDatesRecorded() {
        return this.dates.size();
    }

}
