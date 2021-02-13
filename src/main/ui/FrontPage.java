package ui;

import model.AwardsBag;
import model.DrinkHistory;
import model.DrinkingBalance;
import model.TodayDrinkingGoal;

import java.util.Calendar;

public class FrontPage {
    AwardsBag bag;
    DrinkHistory history;
    DrinkingBalance balance;
    TodayDrinkingGoal goal;
    int day;
    int month;
    int year;


    public static void main(String[] args) {
        FrontPage frontPage = new FrontPage();
        RespondCommand respondCommand = new RespondCommand();

        System.out.println("Welcome and Let's Drink Water!");

        respondCommand.handleUserInput();
        respondCommand.endProgram();

        System.out.println("Oh, bye dear! Wish you a healthy life!");
    }

    public FrontPage() {
        day = Calendar.DAY_OF_MONTH;
        month = Calendar.MONTH;
        year = Calendar.YEAR;
        goal = new TodayDrinkingGoal(500);
        balance = new DrinkingBalance(day, month, year);
        bag = new AwardsBag();
        history = new DrinkHistory();
    }
}
