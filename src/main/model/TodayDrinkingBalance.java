package model;

// Represent the water drinking balance in a day
public class TodayDrinkingBalance {

    // changing properties of today's drinking amount
    // balance is how many ml have drank so far
    private int balance;



    // REQUIRES: initialBalance >= 0
    // EFFECTS: set balance to it's initial value, which is 0
    public TodayDrinkingBalance() {
        balance = 0;
    }


    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: adds amount ml to balance
    public void addBalance(int amount) {
        balance = balance + amount;
    }

    // REQUIRES: balance > amount > 0
    // MODIFIES: this
    // EFFECTS: subtracts amount ml from balance
    public void subBalance(int amount) {
        balance = balance - amount;
    }

    // EFFECTS: return current balance in ml
    public int getBalance() {
        return balance;
    }

    // MODIFIES: this
    // EFFECTS: check if balance achieve goal
    //              -if achieve, return true
    //              -if not achieve yet, return false
    public boolean isAchieved() {
        TodayDrinkingGoal goal = new TodayDrinkingGoal(500);
        if (balance >= goal.getGoal()) {
            return true;
        } else {
            return false;
        }
    }

}
