package model;

// Represent the water drinking balance in a day
// plus: Representing the the drink date, will be used for history tracking, in drinking history class
public class DrinkingBalance {

    // changing properties of a day's drinking amount
    // balance is how many ml have drank so far
    private int balance;


    //year, month and day for the drink date
    private int year;
    private int month;
    private int day;


    // REQUIRES: input day and month must be a proper date, not 02-31-2020, not future date like 01-01-2100
    //           year must be four digit, day and month can only be one or two digit
    //           initialBalance >= 0
    // MODIFIES: this
    // EFFECTS:  make the day, month, year input into this.day, this.month, this.year
    //           set balance to it's initial value, which is 0
    public DrinkingBalance(int day, int month, int year) {
        balance = 0;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // REQUIRES: input day and month must be a proper date, not 02-31-2020, not future date like 01-01-2100
    //           year must be four digit, day and month can only be one or two digit
    //           initialBalance >= 0, one more input
    // MODIFIES: this
    // EFFECTS:  make the day, month, year input into this.day, this.month, this.year
    //           set balance to it's initial value, which is 0
    public DrinkingBalance(int day, int month, int year, int balance) {
        this.balance = balance;
        this.day = day;
        this.month = month;
        this.year = year;
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



    // MODIFIES: this
    // EFFECTS: make date into clean format and return the date with "-" symbol
    public String getDate() {
        String formatDay = cleanFormat(day);
        String formatMonth = cleanFormat(month);
        return formatDay + "-" + formatMonth + "-" + year;
    }

    // MODIFIES: this
    // EFFECTS: make single digit day and month into two digit
    public String cleanFormat(int i) {
        if (i < 10) {
            return "" + "0" + i;
        } else {
            return "" + i;
        }
    }

    // MODIFIES: this
    // EFFECTS: combine the date and the current balance
    public String combineDateBalance() {
        return getDate() + " corresponding balance: " + getBalance();
    }



}
