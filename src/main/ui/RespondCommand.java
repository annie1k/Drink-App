package ui;

import model.AwardsBag;
import model.DrinkHistory;
import model.DrinkingBalance;
import model.TodayDrinkingGoal;

import java.util.Calendar;
import java.util.Scanner;

public class RespondCommand {

    // fields for respond command

    int day = Calendar.DAY_OF_MONTH;
    int month = Calendar.MONTH;
    int year = Calendar.YEAR;

    private static final String MEDAL_COMMAND = "medal bag";
    private static final String HISTORY_COMMAND = "history";
    private static final String TODAY_BALANCE_ADD_COMMAND = "add balance";
    private static final String TODAY_BALANCE_SUB_COMMAND = "sub balance";
    private static final String TODAY_BALANCE_COMMAND = "balance";
    private static final String TODAY_GOAL_COMMAND = "goal";
    private static final String TODAY_GOAL_ADD_COMMAND = "add goal";
    private static final String TODAY_GOAL_SUB_COMMAND = "sub goal";
    private static final String QUIT_COMMAND = "quit";

    private Scanner inputString;
    private Scanner inputInt;
    private boolean runProgram;
    private AwardsBag bag = new AwardsBag();
    private DrinkHistory history = new DrinkHistory();
    private TodayDrinkingGoal goal = new TodayDrinkingGoal(500);
    private DrinkingBalance balance = new DrinkingBalance(day,month,year);

    // EFFECTS: start the application
    public RespondCommand() {
        inputString = new Scanner(System.in);
        runProgram = true;
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
        } else if (str.equals(TODAY_BALANCE_COMMAND)) {
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
        } else if (str.equals(QUIT_COMMAND)) {
            runProgram = false;
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
        System.out.println("you have " + bag.numMedalsInBag() + " medals");
    }

    // EFFECTS: display days have drink history
    public void displayHistory() {
        System.out.println("you have drink " + history.numDatesRecorded() + " days");

    }

    // EFFECTS: display balance of today's drink habit
    public void displayBalance() {
        System.out.println("Today you drink " + balance.getBalance() + " ml so far.");
    }

    // EFFECTS: display goal
    public void displayGoal() {
        System.out.println("Today's goal is: " + goal.getGoal());
    }

    // EFFECTS: add balance
    public void addBalance() {
        System.out.println("Please type the number you wanna change");

        inputInt = new Scanner(System.in);
        int balance1 = inputInt.nextInt();
        balance.addBalance(balance1);

        System.out.println("current balance: " + balance.getBalance());
        if (balance.isAchieved() && (bag.numMedalsInBag() == 0)) {
            bag.addRandMedal();
            System.out.println("current # medals: " + bag.numMedalsInBag());
        }
    }

    // EFFECTS: subtract balance
    public void subBalance() {
        System.out.println("Please type the number you wanna change");

        inputInt = new Scanner(System.in);
        int balance2 = inputInt.nextInt();
        balance.subBalance(balance2);

        System.out.println("current balance: " + balance.getBalance());
        if ((!balance.isAchieved()) && (bag.numMedalsInBag() == 1)) {
            bag.subLastMedal();
            System.out.println("current # medals: " + bag.numMedalsInBag());
        }
    }


    // EFFECTS: add goal
    public void addGoal() {
        System.out.println("Please type the number you wanna change");

        inputInt = new Scanner(System.in);
        int goal1 = inputInt.nextInt();
        goal.addGoal(goal1);

        System.out.println("current goal: " + goal.getGoal());

    }

    // EFFECTS: subtract goal
    public void subGoal() {
        System.out.println("Please type the number you wanna change");

        inputInt = new Scanner(System.in);
        int goal2 = inputInt.nextInt();
        goal.subGoal(goal2);

        System.out.println("current goal: " + goal.getGoal());

    }


    //EFFECTS: stops receiving user input
    public void endProgram() {
        System.out.println("Quitting...");
        inputString.close();
    }


}
