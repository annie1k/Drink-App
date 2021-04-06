package ui.drink.balance;

import model.DrinkHistory;
import ui.drink.SubPages;

import javax.swing.*;
import java.awt.*;

//Class for Add Drink event to history
public class AddDrinkingPage extends JFrame implements SubPages {
    private AddDrinkingHandler addDrinkingHandler;
    private DrinkHistory history;
    private static JTextField year;
    private static JTextField month;
    private static JTextField day;
    private static JTextField addBalance;
    private static JTextField subBalance;
    private static JTextField addGoal;
    private static JTextField subGoal;

    private static JLabel yearLabel;
    private static JLabel monthLabel;
    private static JLabel dayLabel;
    private static JLabel addBalanceLabel;
    private static JLabel subBalanceLabel;
    private static JLabel addGoalLabel;
    private static JLabel subGoalLabel;

    private static JButton saveButton;

    //constructor
    public AddDrinkingPage(DrinkHistory history) {
        this.history = history;


        setUp();


        addDrinkingHandler = new AddDrinkingHandler(history,year, month, day, addBalance, subBalance, addGoal, subGoal);
        saveButton.addActionListener(addDrinkingHandler);

        setLayout(new FlowLayout());

        addEverything(yearLabel, year, monthLabel, month, dayLabel, day, addBalanceLabel, addBalance,
                addGoalLabel, addGoal, subBalanceLabel, subBalance, subGoalLabel, subGoal, saveButton);


        quit();

    }



    //MODIFIES: this
    //EFFECTS: set up this page
    @Override
    public void setUp() {
        setTitle("Add Balance");

        setBounds(0, 0, 1000, 100);
        setBackground(Color.cyan);
        setBackground(new Color(154, 186, 236));


        setUpFields();

        //9 Label
        setLabel();

        //1 button
        saveButton = new JButton("Save");

        this.setVisible(true);
        setResizable(false);
    }

    //MODIFIES: this
    //EFFECTS: close this page
    @Override
    public void quit() {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    // MODIFIES: this
    // EFFECTS: set Label for this frame
    private void setLabel() {
        yearLabel = new JLabel("year(ex.2000)");
        monthLabel = new JLabel("month(ex.01)");
        dayLabel = new JLabel("day(ex.01)");
        addBalanceLabel = new JLabel("Add Balance (ml):");
        addGoalLabel = new JLabel("Add Goal (ml):");
        subBalanceLabel = new JLabel("Subtract Balance (ml):");
        subGoalLabel = new JLabel("Subtract Goal (ml):");
    }

    // MODIFIES: this
    // EFFECTS: add every elements
    private void addEverything(JLabel yearLabel, JTextField year, JLabel monthLabel, JTextField month,
                               JLabel dayLabel, JTextField day, JLabel addBalanceLabel, JTextField addBalance,
                               JLabel addGoalLabel, JTextField addGoal, JLabel subBalanceLabel, JTextField subBalance,
                               JLabel subGoalLabel, JTextField subGoal, JButton saveButton) {
        add(yearLabel);
        add(year);
        add(monthLabel);
        add(month);
        add(dayLabel);
        add(day);
        add(addBalanceLabel);
        add(addBalance);
        add(addGoalLabel);
        add(addGoal);
        add(subBalanceLabel);
        add(subBalance);
        add(subGoalLabel);
        add(subGoal);
        add(saveButton);
    }

    //MODIFIES: this
    //EFFECTS: set up fields
    private void setUpFields() {
        year = new JTextField(4);
        month = new JTextField(2);
        day = new JTextField(2);
        addBalance = new JTextField(10);
        addGoal = new JTextField(10);
        subBalance = new JTextField(10);
        subGoal = new JTextField(10);
    }


}
