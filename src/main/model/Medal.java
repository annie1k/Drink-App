package model;

public class Medal {
    private int year;
    private int month;
    private int day;
    private String img;

    // EFFECTS: get the year
    public int getYear() {
        return year;
    }

    // MODIFIES: this
    // EFFECTS: set the year to be year
    public void setYear(int year) {
        this.year = year;
    }

    // EFFECTS: get the month
    public int getMonth() {
        return month;
    }

    // MODIFIES: this
    // EFFECTS: set the month to be month
    public void setMonth(int month) {
        this.month = month;
    }

    // EFFECTS: get the day
    public int getDay() {
        return day;
    }

    // MODIFIES: this
    // EFFECTS: set the day to be day
    public void setDay(int day) {
        this.day = day;
    }

    // EFFECTS: get the string address of the image (x.png)
    public String getImg() {
        return img;
    }

    // MODIFIES: this
    // EFFECTS: set the string img to be img (x.png)
    public void setImg(String img) {
        this.img = img;
    }

    // EFFECTS: convert day, month, year, img all together into String
    public String toString() {
        return String.format("day: %d, month: %d, year: %d, img: %s", day, month,
                year, img);
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
    // EFFECTS: make date into clean format and return the date with "-" symbol
    public String getDate() {
        String formatDay = cleanFormat(day);
        String formatMonth = cleanFormat(month);
        return formatDay + "-" + formatMonth + "-" + year;
    }


}
