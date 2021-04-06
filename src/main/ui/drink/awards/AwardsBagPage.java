package ui.drink.awards;


import model.DrinkHistory;
import ui.drink.SubPages;

import javax.swing.*;
import java.awt.*;

// Class for swing AwardsBag

public class AwardsBagPage extends JFrame implements SubPages {

    private DrinkHistory history;


    //constructor
    public AwardsBagPage(DrinkHistory history) {
        this.history = history;

        setUp();

        displayImages();

        quit();

    }

    //MODIFIES: this
    //EFFECTS: close this page
    @Override
    public void quit() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    //MODIFIES: this
    //EFFECTS: set up this page
    @Override
    public void setUp() {
        setTitle("Awards");
        setLayout(new FlowLayout());
        setSize(1500, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    // EFFECTS: add images
    public void displayImages() {
        model.AwardsBag bag = history.getAwardsBag();
        for (int i = 1; i <= (bag.numMedalsInBag()); i++) {
            int index = i - 1;
            System.out.println(bag.getBag().get(index).getImg());
            add(new JLabel(new ImageIcon(bag.getBag().get(index).getImg())));
        }
        assert (!((bag.getBag().size() != 0) && (history.getDrinkHistory().size() == 0)));
    }


}