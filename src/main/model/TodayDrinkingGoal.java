package model;

import org.json.JSONObject;
import persistence.Writable;

// Represent the water drinking goal's amount in a day
public class TodayDrinkingGoal extends ChangeableClass implements Writable  {

    // changing properties of today's drinking amount
    // goal is set for today's water drink goal
    private int goal;



    // REQUIRES: initialGoal >= 500
    // EFFECTS: set goal to it's initial value
    public TodayDrinkingGoal(int initialGoal) {
        goal = initialGoal;
    }


    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: adds amount ml to goal
    public void addValue(int amount) {
        goal = goal + amount;
    }

    // REQUIRES: goal > amount > 0
    // MODIFIES: this
    // EFFECTS: subtracts amount ml from goal
    public void subValue(int amount) {
        goal = goal - amount;
    }

    // EFFECTS: return current goal in ml
    public int getGoal() {
        return goal;
    }

    //EFFECTS: set json object's key value and return this json
    @Override
    public JSONObject toJson() {
        JSONObject goal = new JSONObject();
        goal.put("goal",this.goal);
        return goal;
    }
}
