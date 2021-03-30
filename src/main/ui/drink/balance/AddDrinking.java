package ui.drink.balance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrinking extends JFrame implements ActionListener {
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

    public AddDrinking() {

        setTitle("Add Balance");

        setBounds(0, 0, 1000, 100);
        setBackground(Color.cyan);
        setBackground(new Color(154, 186, 236));


        setUpFields();

        //9 Label
        setLabel();

        //1 button
        saveButton = new JButton("Save");

        setLayout(new FlowLayout());

        addEverything(yearLabel, year, monthLabel, month, dayLabel, day, addBalanceLabel, addBalance,
                addGoalLabel, addGoal, subBalanceLabel, subBalance, subGoalLabel, subGoal, saveButton);

        this.setVisible(true);
        setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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


    public static void main(String[] args) {
        new AddDrinking();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
