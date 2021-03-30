package ui.drink.balance;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import static model.AwardsBag.findMedal;

public class AddDrinkingHandler implements ActionListener {
    private JTextField year;
    private JTextField month;
    private JTextField day;
    private JTextField addBalance;
    private JTextField subBalance;
    private JTextField addGoal;
    private JTextField subGoal;

    private AwardsBag bag;
    private DrinkHistory history;
    private TodayDrinkingGoal goal = new TodayDrinkingGoal(500);
    private DrinkingBalance balance;

    public AddDrinkingHandler(DrinkHistory history, JTextField year, JTextField month, JTextField day,
                              JTextField addBalance, JTextField subBalance, JTextField addGoal, JTextField subGoal) {
        this.history = history;
        this.bag = history.getAwardsBag();
        this.year = year;
        this.month = month;
        this.day = day;
        this.addBalance = addBalance;
        this.subBalance = subBalance;
        this.addGoal = addGoal;
        this.subGoal = subGoal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Save")) {
            addBalance();
            addGoal();
            subBalance();
            subGoal();
            System.out.println(history.toString());
        }
    }

    // MODIFIES: this
    // EFFECTS: remove the corresponding medal if balance no longer meet that day's goal
    public void subMedal(int day, int month, int year, String date) {
        if (bag.findMedal(date) != null) {
            Medal needRemove = findMedal(date);
            this.bag.removeMedal(needRemove);
        } else {
            this.bag = bag;
        }
    }

    // MODIFIES: this
    // EFFECTS: add rand medal if that day don't have medal yet
    public void addMedal(int day, int month, int year, String date) {
        if (bag.findMedal(date) == null) {
            this.bag.addRandMedal(day, month, year);
        } else {
            this.bag = bag;
        }
    }

    // Must enter the proper format of date
    // MODIFIES: this
    // EFFECTS: add balance, also check whether balance meet the goal, if yes, add medal to that day
    public void addBalance() {
        //ask the date
        int inputDay = Integer.parseInt(day.getText());
        int inputMonth = Integer.parseInt(month.getText());
        int inputYear = Integer.parseInt(year.getText());

        String date = cleanFormat(inputDay) + "-" + cleanFormat(inputMonth) + "-" + cleanFormat(inputYear);

        findHistory2(inputDay, inputMonth, inputYear, date);
        int inputInt = Integer.parseInt(addBalance.getText());
        balance.addBalance(inputInt);

        if (balance.isAchieved()) {
            addMedal(inputDay, inputMonth, inputYear, date);
        }
    }


    //EFFECTS: find if exist a day that have use history, exist then set balance to this.balance, create new otherwise
    private void findHistory2(int inputDay, int inputMonth, int inputYear, String date) {
        if (history.findBalance(date) == null) {
            balance = new DrinkingBalance(inputDay, inputMonth, inputYear);
            history.addDate(balance);
        } else {
            balance = history.findBalance(date);
        }
    }


    // MODIFIES: this
    // EFFECTS: subtract balance, also check whether balance meet the goal, if no, subtract that day's medal
    public void subBalance() {
        int inputDay = Integer.parseInt(day.getText());
        int inputMonth = Integer.parseInt(month.getText());
        int inputYear = Integer.parseInt(year.getText());
        String date = cleanFormat(inputDay) + "-" + cleanFormat(inputMonth) + "-" + cleanFormat(inputYear);

        findHistory2(inputDay, inputMonth, inputYear, date);

        int inputInt = Integer.parseInt(subBalance.getText());
        balance.subBalance(inputInt);

        if ((!balance.isAchieved()) && (history.getAwardsBag().numMedalsInBag() > 0)) {
            subMedal(inputDay, inputMonth, inputYear, date);
        }
    }


    // MODIFIES: this
    // EFFECTS: add goal, also check whether balance meet the goal, if no, subtract that day's medal
    public void addGoal() {

        int inputDay = Integer.parseInt(day.getText());
        int inputMonth = Integer.parseInt(month.getText());
        int inputYear = Integer.parseInt(year.getText());
        String date = cleanFormat(inputDay) + "-" + cleanFormat(inputMonth) + "-" + cleanFormat(inputYear);

        findHistory(inputDay, inputMonth, inputYear, date);

        goal = balance.getGoal();

        int inputInt = Integer.parseInt(addGoal.getText());

        historyForGoal(inputInt);

        if ((!balance.isAchieved()) && (history.getAwardsBag().numMedalsInBag() > 0)) {
            subMedal(inputDay, inputMonth, inputYear, date);
        }

    }

    // MODIFIES: this
    //EFFECTS: find if exist a day that have use history, exist then set balance to this.goal, create new otherwise
    private void historyForGoal(int goal1) {
        if (goal == null) {
            balance.addGoal(goal1);
            goal = balance.getGoal();
        } else {
            goal.addGoal(goal1);
        }
    }



    // MODIFIES: this
    // EFFECTS: subtract goal, also check whether balance meet the goal, if yes, add medal to that day
    public void subGoal() {
        int inputDay = Integer.parseInt(day.getText());
        int inputMonth = Integer.parseInt(month.getText());
        int inputYear = Integer.parseInt(year.getText());
        String date = cleanFormat(inputDay) + "-" + cleanFormat(inputMonth) + "-" + cleanFormat(inputYear);

        findHistory(inputDay, inputMonth, inputYear, date);

        goal = balance.getGoal();

        int inputInt = Integer.parseInt(subGoal.getText());
        goal.subGoal(inputInt);

        if (balance.isAchieved()) {
            addMedal(inputDay, inputMonth, inputYear, date);
        }

    }

    // MODIFIES: this
    // EFFECTS: find if exist a day that have use history, exist then set balance to this.balance, create new otherwise
    private void findHistory(int inputDay, int inputMonth, int inputYear, String date) {
        if (history.findBalance(date) == null) {
            balance = new DrinkingBalance(inputDay, inputMonth, inputYear);
            balance.addGoal(0);
            history.addDate(balance);
        } else {
            balance = history.findBalance(date);
        }
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
