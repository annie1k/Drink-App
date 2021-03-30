package ui.drink.home;

import model.DrinkHistory;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// GUI for Drink It App :)
public class DrinkIt extends Frame {
    private static HPActionListener hpActionListener;
    private DrinkHistory drinkHistory = new DrinkHistory();


    public DrinkIt() {
        hpActionListener = new HPActionListener(this);
        //one frame
        Frame frame = new Frame("Drink It");

        //one panel
        Panel panelForButtons = new Panel();
        Panel panelForLabel = new Panel();

        //5 buttons
        Button drinking = new Button("Drinking Balance");
        Button history = new Button("History");
        Button bag = new Button("Awards Bag");
        Button save = new Button("Save Balance");
        Button load = new Button("Load History");

        //one label
        Label welcome = new Label("Welcome to Drink It App, Let's Drink!");

        setAndAddEverything(frame,panelForButtons,panelForLabel,drinking,history,bag,save,load,welcome);

        pack();

        frame.setResizable(false);

        frame.setVisible(true);

        windowClose(frame);
    }

    // Modifies: this
    // Effects: set and add every element in this frame
    private void setAndAddEverything(Frame frame, Panel panelForButtons, Panel panelForLabel, Button drinking,
                                     Button history, Button bag, Button save, Button load, Label welcome) {
        frame.setLayout(null);

        frame.setBounds(200, 200, 500, 300);
        frame.setBackground(new Color(154, 186, 236));
        panelForButtons.setBounds(25, 180, 450, 70);
        panelForButtons.setBackground(new Color(203, 217, 239));
        panelForLabel.setBounds(100, 100, 300, 30);
        panelForLabel.setBackground(new Color(246, 227, 235));


        panelForLabel.add(welcome);
        frame.add(panelForLabel);
        frame.add(panelForButtons);


        panelForButtons.add(drinking);
        panelForButtons.add(history);
        panelForButtons.add(bag);
        panelForButtons.add(save);
        panelForButtons.add(load);


        drinking.setActionCommand("drinking");
        history.setActionCommand("history");
        bag.setActionCommand("bag");
        load.setActionCommand("load");
        save.setActionCommand("save");

        setActionCommand(drinking, history, bag, load, save);


        panelForButtons.setLayout(new FlowLayout());
    }

    // Modifies: this
    // Effects: close the window
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // Modifies: this
    // Effects: add action listeners
    private static void setActionCommand(Button drinking, Button history, Button bag,
                                         Button load, Button save) {
        drinking.addActionListener(hpActionListener);
        history.addActionListener(hpActionListener);
        bag.addActionListener(hpActionListener);
        save.addActionListener(hpActionListener);
        load.addActionListener(hpActionListener);
    }

    public void setDrinkHistory(DrinkHistory drinkHistory) {
        this.drinkHistory = drinkHistory;
    }

    public DrinkHistory getDrinkHistory() {
        return drinkHistory;
    }
}


