package ui;

import model.AwardsBag;
import model.DrinkHistory;
import model.DrinkingBalance;
import model.TodayDrinkingGoal;

import java.util.Calendar;
import java.util.Scanner;

public class RespondCommand {
    int day = Calendar.DAY_OF_MONTH;
    int month = Calendar.MONTH;
    int year = Calendar.YEAR;

    private static final String MEDAL_COMMAND = "medal bag";
    private static final String HISTORY_COMMAND = "history";
    private static final String TODAY_BALANCE_ADD_SUB_COMMAND = "add or sub balance";
    private static final String TODAY_BALANCE_COMMAND = "balance";
    private static final String TODAY_GOAL_COMMAND = "goal";
    private static final String TODAY_GOAL_ADD_SUB_COMMAND = "add or sub goal";
    private static final String QUIT_COMMAND = "quit";

    private Scanner input;
    private boolean runProgram;
    private AwardsBag bag = new AwardsBag();
    private DrinkHistory history = new DrinkHistory();
    private TodayDrinkingGoal goal = new TodayDrinkingGoal(500);
    private DrinkingBalance balance = new DrinkingBalance(day,month,year);

    public RespondCommand() {
        input = new Scanner(System.in);
        runProgram = true;
    }

    //EFFECTS: parses user input until user quits
    public void handleUserInput() {
        System.out.println("How can I help you today?");
        printInstructions();
        String str;

        while (runProgram) {
            if (input.hasNext()) {
                str = input.nextLine();
                str = makePrettyString(str);
                respondInput(str);
            }
        }
    }


    // EFFECTS: give respond depending on input command str
    private void respondInput(String str) {
        if (str.length() > 0) {
            switch (str) {
                case MEDAL_COMMAND:
                    displayAllMedals();
                    break;
                case HISTORY_COMMAND:
                    displayHistory();
                    break;
                case TODAY_BALANCE_COMMAND:
                    displayBalance();
                    break;
                case TODAY_BALANCE_ADD_SUB_COMMAND:
                    operateBalance();
                    break;
                case TODAY_GOAL_COMMAND:
                    displayGoal();
                    break;
                case TODAY_GOAL_ADD_SUB_COMMAND:
                    operateGoal();
                    break;
                case QUIT_COMMAND:
                    runProgram = false;
                    break;
                default:
                    System.out.println("Sorry, I don't understand. Please try again.");
            }
        }
    }


    // EFFECTS: prints instructions to use Respond Command
    private void printInstructions() {
        System.out.println("Enter '" + MEDAL_COMMAND + "' to check medal bag");
        System.out.println("Enter '" + HISTORY_COMMAND + "' to check water drinking history");
        System.out.println("Enter '" + TODAY_BALANCE_COMMAND + "' to check today's drinking balance");
        System.out.println("Enter '" + TODAY_BALANCE_ADD_SUB_COMMAND + "' to add or subtract ml to drink balance");
        System.out.println("Enter '" + TODAY_GOAL_COMMAND + "' to check today's goal");
        System.out.println("Enter '" + TODAY_GOAL_ADD_SUB_COMMAND + "' to add or subtract ml to today's goal");
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

    // EFFECTS: add or subtract balance
    public void operateBalance() {
        System.out.println("balance ope");

    }


    // EFFECTS: add or subtract goal
    public void operateGoal() {
        System.out.println("goal ope");

    }


    //EFFECTS: stops receiving user input
    public void endProgram() {
        System.out.println("Quitting...");
        input.close();
    }


}
