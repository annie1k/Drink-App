package model;

public class Medal {
    private int year;
    private int month;
    private int day;
    private String img;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

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
