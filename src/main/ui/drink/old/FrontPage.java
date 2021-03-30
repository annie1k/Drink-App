package ui.drink.old;

public class FrontPage {

    // EFFECTS: starter function
    public static void main(String[] args) {
        RespondCommand respondCommand = new RespondCommand();

        System.out.println("Welcome and Let's Drink Water!");

        respondCommand.handleUserInput();
        respondCommand.endProgram();

        System.out.println("Oh, bye dear! Wish you a healthy life!");
    }
}
