package model;

// Representing the the drink date, will be used for history tracking, in drinking history class
public class DrinkDate {

    //year, month and day for the drink date
    private int year;
    private int month;
    private int day;

    // REQUIRES: input day and month must be a proper date, not 02-31-2020, not future date like 01-01-2100
    //           year must be four digit, day and month can only be one or two digit
    // MODIFIES: this
    // EFFECTS: make the day, month, year input into this.day, this.month, this.year
    public DrinkDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
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

}
