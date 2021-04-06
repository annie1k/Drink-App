package ui.drink.old;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

import static model.AwardsBag.findMedal;

public class RespondCommand {

    // fields for respond command

    int day = Calendar.DAY_OF_MONTH;
    int month = Calendar.MONTH;
    int year = 2020 + Calendar.YEAR;


    //jSon
    private static final String JSON_STORE = "./data/drinkApp.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    private static final String MEDAL_COMMAND = "medal bag";
    private static final String HISTORY_COMMAND = "history";
    private static final String TODAY_BALANCE_ADD_COMMAND = "add balance";
    private static final String TODAY_BALANCE_SUB_COMMAND = "sub balance";
    private static final String TODAY_BALANCE_COMMAND = "balance";
    private static final String TODAY_GOAL_COMMAND = "goal";
    private static final String TODAY_GOAL_ADD_COMMAND = "add goal";
    private static final String TODAY_GOAL_SUB_COMMAND = "sub goal";
    private static final String SAVE_COMMAND = "save";
    private static final String LOAD_COMMAND = "load";
    private static final String QUIT_COMMAND = "quit";

    private Scanner inputString;
    private Scanner inputInt;
    private boolean runProgram;
    private AwardsBag bag = new AwardsBag();
    private DrinkHistory history = new DrinkHistory();
    private TodayDrinkingGoal goal = new TodayDrinkingGoal(500);
    private DrinkingBalance balance = new DrinkingBalance(day, month, year);


    // EFFECTS: start the application
    public RespondCommand() {
        inputString = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runProgram = true;
        //history.addDate(balance);

    }

    // EFFECTS: parses user input until user quits
    public void handleUserInput() {
        System.out.println("How can I help you today?");
        printInstructions();
        String str;

        while (runProgram) {
            if (inputString.hasNext()) {
                str = inputString.nextLine();
                str = makePrettyString(str);
                respondInput(str);
            }
        }
    }

    // REQUIRE: string length must >0, not empty
    // EFFECTS: give respond depending on input command str
    private void respondInput(String str) {
        if (str.equals(MEDAL_COMMAND)) {
            displayAllMedals();
        } else if (str.equals(HISTORY_COMMAND)) {
            displayHistory();
        } else if (str.equals(SAVE_COMMAND)) {
            saveHistoryAndAwards();
        } else if (str.equals(LOAD_COMMAND)) {
            loadHistoryAndAwards();
        } else if (str.equals(QUIT_COMMAND)) {
            runProgram = false;
        } else {
            respondInputAddition(str);
        }
    }

    // Helper function of respondInput
    // REQUIRE: string length must >0, not empty
    // EFFECTS: give respond depending on input command str
    private void respondInputAddition(String str) {
        if (str.equals(TODAY_BALANCE_COMMAND)) {
            displayBalance();
        } else if (str.equals(TODAY_BALANCE_ADD_COMMAND)) {
            addBalance();
        } else if (str.equals(TODAY_BALANCE_SUB_COMMAND)) {
            subBalance();
        } else if (str.equals(TODAY_GOAL_COMMAND)) {
            displayGoal();
        } else if (str.equals(TODAY_GOAL_ADD_COMMAND)) {
            addGoal();
        } else if (str.equals(TODAY_GOAL_SUB_COMMAND)) {
            subGoal();
        } else {
            System.out.println("Sorry, I don't understand. Please try again.");
        }
    }


    // EFFECTS: prints instructions to use Respond Command
    private void printInstructions() {
        System.out.println("Enter '" + MEDAL_COMMAND + "' to check medal bag");
        System.out.println("Enter '" + HISTORY_COMMAND + "' to check water drinking history");
        System.out.println("Enter '" + TODAY_BALANCE_COMMAND + "' to check today's drinking balance");
        System.out.println("Enter '" + TODAY_BALANCE_ADD_COMMAND + "' to add ml to drink balance");
        System.out.println("Enter '" + TODAY_BALANCE_SUB_COMMAND + "' to subtract ml to drink balance");
        System.out.println("Enter '" + TODAY_GOAL_COMMAND + "' to check today's goal");
        System.out.println("Enter '" + TODAY_GOAL_ADD_COMMAND + "' to add ml to today's goal");
        System.out.println("Enter '" + TODAY_GOAL_SUB_COMMAND + "' to subtract ml to today's goal");
        System.out.println("Enter '" + SAVE_COMMAND + "' to save history and awards");
        System.out.println("Enter '" + LOAD_COMMAND + "' to load history and awards bag");
        System.out.println("Enter '" + QUIT_COMMAND + "' to quit the application");
    }

    //EFFECTS: removes white space and quotation marks around s
    private String makePrettyString(String s) {
        s = s.toLowerCase();
        s = s.trim();
        s = s.replaceAll("\"|\'", "");
        return s;
    }


    // EFFECTS: display all medals earned
    public void displayAllMedals() {
        AwardsBag bag = history.getAwardsBag();

        System.out.println("you have " + bag.numMedalsInBag() + " medals");
        System.out.println("Awards: ");

        System.out.println(bag.getBag());

    }

    // EFFECTS: display days have drink history
    public void displayHistory() {
        System.out.println("you have drink " + history.numDatesRecorded() + " days");
        System.out.println("History: ");
        for (int i = 0; i < history.numDatesRecorded(); i++) {
            System.out.println(history.getDrinkHistory().get(i).combineDateBalance());
        }

    }

    // EFFECTS: display balance of today's drink habit, actually is will be a fixed number
    public void displayBalance() {
        System.out.println("Today you drink " + balance.getBalance() + " ml so far.");
    }

    // EFFECTS: display goal of today's drink habit, actually is will be a fixed number
    public void displayGoal() {
        System.out.println("Today's goal is: " + goal.getGoal());
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
        System.out.println("Please enter the day, for example, 1");
        int inputDay = inputString.nextInt();
        inputString.nextLine();
        System.out.println("Please enter the month, for example, 1");
        int inputMonth = inputString.nextInt();
        inputString.nextLine();
        System.out.println("Please enter the year, for example, 2000");
        int inputYear = inputString.nextInt();
        inputString.nextLine();

        String date = cleanFormat(inputDay) + "-" + cleanFormat(inputMonth) + "-" + cleanFormat(inputYear);

        findHistory2(inputDay, inputMonth, inputYear, date);

        System.out.println("Please type the number you wanna change");

        inputInt = new Scanner(System.in);
        int balance1 = inputInt.nextInt();
        balance.addValue(balance1);

        System.out.println("current balance: " + balance.getBalance());
        if (balance.isAchieved()) {
            //history.getAwardsBag().addRandMedal(inputDay, inputMonth, inputYear);
            addMedal(inputDay, inputMonth, inputYear, date);
            System.out.println("current # medals: " + history.getAwardsBag().numMedalsInBag());
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
        System.out.println("Please enter the day, for example, 1");
        int inputDay = inputString.nextInt();
        inputString.nextLine();
        System.out.println("Please enter the month, for example, 1");
        int inputMonth = inputString.nextInt();
        inputString.nextLine();
        System.out.println("Please enter the year, for example, 2000");
        int inputYear = inputString.nextInt();
        inputString.nextLine();

        String date = cleanFormat(inputDay) + "-" + cleanFormat(inputMonth) + "-" + cleanFormat(inputYear);

        findHistory2(inputDay, inputMonth, inputYear, date);

        System.out.println("Please type the number you wanna change");

        inputInt = new Scanner(System.in);
        int balance2 = inputInt.nextInt();
        balance.subFromIt(balance2);

        System.out.println("current balance: " + balance.getBalance());
        if ((!balance.isAchieved()) && (history.getAwardsBag().numMedalsInBag() > 0)) {
            //history.getAwardsBag().subMedal(inputDay, inputMonth, inputYear, date);
            subMedal(inputDay, inputMonth, inputYear, date);
            System.out.println("current # medals: " + history.getAwardsBag().numMedalsInBag());
        }
    }


    // MODIFIES: this
    // EFFECTS: add goal, also check whether balance meet the goal, if no, subtract that day's medal
    public void addGoal() {

        System.out.println("Please enter the day, for example, 1");
        int inputDay = inputString.nextInt();
        inputString.nextLine();
        System.out.println("Please enter the month, for example, 1");
        int inputMonth = inputString.nextInt();
        inputString.nextLine();
        System.out.println("Please enter the year, for example, 2000");
        int inputYear = inputString.nextInt();
        inputString.nextLine();

        String date = cleanFormat(inputDay) + "-" + cleanFormat(inputMonth) + "-" + cleanFormat(inputYear);

        findHistory(inputDay, inputMonth, inputYear, date);

        goal = balance.getGoal();



        System.out.println("Please type the number you wanna change");

        inputInt = new Scanner(System.in);
        int goal1 = inputInt.nextInt();

        historyForGoal(goal1);


        System.out.println("current goal: " + goal.getGoal());

        if ((!balance.isAchieved()) && (history.getAwardsBag().numMedalsInBag() > 0)) {
            //history.getAwardsBag().subMedal(inputDay, inputMonth, inputYear, date);
            subMedal(inputDay, inputMonth, inputYear, date);
            System.out.println("current # medals: " + history.getAwardsBag().numMedalsInBag());
        }

    }

    // MODIFIES: this
    //EFFECTS: find if exist a day that have use history, exist then set balance to this.goal, create new otherwise
    private void historyForGoal(int goal1) {
        if (goal == null) {
            balance.addGoal(goal1);
            goal = balance.getGoal();
        } else {
            goal.addValue(goal1);
        }
    }



    // MODIFIES: this
    // EFFECTS: subtract goal, also check whether balance meet the goal, if yes, add medal to that day
    public void subGoal() {
        System.out.println("Please enter the day, for example, 1");
        int inputDay = inputString.nextInt();
        inputString.nextLine();
        System.out.println("Please enter the month, for example, 1");
        int inputMonth = inputString.nextInt();
        inputString.nextLine();
        System.out.println("Please enter the year, for example, 2000");
        int inputYear = inputString.nextInt();
        inputString.nextLine();

        String date = cleanFormat(inputDay) + "-" + cleanFormat(inputMonth) + "-" + cleanFormat(inputYear);

        findHistory(inputDay, inputMonth, inputYear, date);

        goal = balance.getGoal();

        System.out.println("Please type the number you wanna change");

        inputInt = new Scanner(System.in);
        int goal2 = inputInt.nextInt();
        goal.subFromIt(goal2);

        System.out.println("current goal: " + goal.getGoal());
        if (balance.isAchieved()) {
            //history.getAwardsBag().addRandMedal(inputDay, inputMonth, inputYear);
            addMedal(inputDay, inputMonth, inputYear, date);
            System.out.println("current # medals: " + history.getAwardsBag().numMedalsInBag());
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

    // EFFECTS: saves the history and awards to file
    private void saveHistoryAndAwards() {
        try {
            jsonWriter.open();
            jsonWriter.write(history);
            System.out.println(history.toString());
            //jsonWriter.write(bag);
            jsonWriter.close();
            System.out.println("Saved history and awards" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads history and awards from file
    private void loadHistoryAndAwards() {
        try {
            history = jsonReader.readHistory();
            //bag = jsonReader.readAwards();
            System.out.println("Loaded history and awards bag" + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }



    //EFFECTS: stops receiving user input
    public void endProgram() {
        System.out.println("Quitting...");
        inputString.close();
    }


}
