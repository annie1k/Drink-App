package ui.BalancePage;

import javax.swing.*;
import java.awt.*;

public class TodayDrinking extends JFrame {
    private static DrinkingListener drinkingListener = new DrinkingListener();
    private static JTextField year;
    private static JTextField month;
    private static JTextField day;
    private static JTextField balance;
    private static JTextField goal;
    private static JTextField addb;
    private static JTextField subb;
    private static JTextField addg;
    private static JTextField subg;
    private static JLabel yearL;
    private static JLabel monthL;
    private static JLabel dayL;
    private static JLabel balanceL;
    private static JLabel goalL;
    private static JLabel addbL;
    private static JLabel subbL;
    private static JLabel addgL;
    private static JLabel subgL;

    public TodayDrinking() {
        //one frame
        JFrame frame = new JFrame("Drink Balance");

        //one panel
        JPanel panelForDate = new JPanel();
        JPanel panelForText = new JPanel();
        JPanel panelForAnimation = new JPanel();

        //9 text field
        year = new JTextField(4);
        month = new JTextField(2);
        day = new JTextField(2);
        balance = new JTextField(10);
        goal = new JTextField(10);
        addb = new JTextField(10);
        addg = new JTextField(10);
        subb = new JTextField(10);
        subg = new JTextField(10);

        //9 Label
        yearL = new JLabel("Welcome to Drink It App, Let's Drink!");
        monthL = new JLabel("Welcome to Drink It App, Let's Drink!");
        dayL = new JLabel("Welcome to Drink It App, Let's Drink!");
        balanceL = new JLabel("Welcome to Drink It App, Let's Drink!");
        goalL = new JLabel("Welcome to Drink It App, Let's Drink!");
        addbL = new JLabel("Welcome to Drink It App, Let's Drink!");
        addgL = new JLabel("Welcome to Drink It App, Let's Drink!");
        subbL = new JLabel("Welcome to Drink It App, Let's Drink!");
        subgL = new JLabel("Welcome to Drink It App, Let's Drink!");

        //container
        Container container = this.getContentPane();
        container.setLayout(null);


        frame.setBounds(700, 200, 400, 400);
        frame.setBackground(Color.cyan);
        container.setBackground(new Color(154, 186, 236));

        add(year);
        add(month);
        add(day);
        add(yearL);
        add(monthL);
        add(dayL);


        pack();

        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

    }

    public static void main(String[] args) {
        new TodayDrinking();
    }
}
