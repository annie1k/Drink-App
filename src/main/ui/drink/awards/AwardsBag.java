package ui.drink.awards;


import model.DrinkHistory;

import javax.swing.*;
import java.awt.*;

// Class for swing AwardsBag

public class AwardsBag extends JFrame {

    private DrinkHistory history;


    //constructor
    public AwardsBag(DrinkHistory history) {
        this.history = history;

        setTitle("Awards");


        setLayout(new FlowLayout());


        displayImages();

        setSize(1500, 1000);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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