package ui.drink.BalancePage;

import javax.swing.*;
import java.awt.*;

public class TodayDrinking extends JFrame {
    private static DrinkingListener drinkingListener = new DrinkingListener();
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

    public TodayDrinking() {
        //one frame
        JFrame frame = new JFrame("Drink Balance");

        //one panel
        JPanel panelForDate = new JPanel();
        JPanel panelForText = new JPanel();
        JPanel panelForButton = new JPanel();

        frame.add(panelForButton);
        frame.add(panelForDate);
        frame.add(panelForText);
        frame.setBounds(700, 200, 400, 400);
        frame.setBackground(Color.cyan);
        frame.setBackground(new Color(154, 186, 236));

        setEverything(year, month, day, addBalance, addGoal, subBalance, subGoal, yearLabel, monthLabel,
                dayLabel, addBalanceLabel, addGoalLabel, subBalanceLabel, subGoalLabel, saveButton);

        addEverything(panelForButton, panelForDate, panelForText);



        this.setVisible(true);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    //Modifies:this
    //Effects: set every element
    private void setEverything(JTextField year, JTextField month, JTextField day, JTextField addBalance,
                               JTextField addGoal, JTextField subBalance, JTextField subGoal, JLabel yearLabel,
                               JLabel monthLabel, JLabel dayLabel, JLabel addBalanceLabel, JLabel addGoalLabel,
                               JLabel subBalanceLabel, JLabel subGoalLabel, JButton saveButton) {
        //9 text field
        year = new JTextField(4);
        month = new JTextField(2);
        day = new JTextField(2);
        addBalance = new JTextField(10);
        addGoal = new JTextField(10);
        subBalance = new JTextField(10);
        subGoal = new JTextField(10);

        //9 Label
        yearLabel = new JLabel("year");
        monthLabel = new JLabel("month");
        dayLabel = new JLabel("day");
        addBalanceLabel = new JLabel("Add Balance (ml):");
        addGoalLabel = new JLabel("Add Goal (ml):");
        subBalanceLabel = new JLabel("Subtract Balance (ml):");
        subGoalLabel = new JLabel("Subtract Goal (ml):");

        //1 button
        saveButton = new JButton("Save");
    }

    //Modifies:this
    //Effects: add every element
    private void addEverything(JPanel panelForButton, JPanel panelForDate, JPanel panelForText) {
        panelForButton.add(saveButton);
        panelForDate.add(year);
        panelForDate.add(month);
        panelForDate.add(day);
        panelForDate.add(yearLabel);
        panelForDate.add(monthLabel);
        panelForDate.add(dayLabel);
        panelForText.add(addBalance);
        panelForText.add(addGoal);
        panelForText.add(subBalance);
        panelForText.add(subGoal);
        panelForText.add(addBalanceLabel);
        panelForText.add(subBalanceLabel);
        panelForText.add(addGoalLabel);
        panelForText.add(subGoalLabel);
    }


    public static void main(String[] args) {
        new TodayDrinking();
    }
}
