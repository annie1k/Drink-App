package ui.drink.AwardsBag;


import model.DrinkHistory;
import javax.swing.*;
import java.awt.*;

//"./MetalBank/1.png"
//https://stackoverflow.com/questions/18027833/adding-image-to-jframe/18027889

public class AwardsBag extends JFrame {

    private DrinkHistory history = new DrinkHistory();


    public AwardsBag() {
        super("Awards");


        setLayout(new FlowLayout());

//        add(new JLabel(new ImageIcon("./MetalBank/1.png")));
//        add(new JLabel(new ImageIcon("./MetalBank/2.png")));
//        add(new JLabel(new ImageIcon("./MetalBank/2.png")));

        //displayImages();

        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // EFFECTS: display all medals earned
    public void displayAllMedals() {
        model.AwardsBag bag = history.getAwardsBag();

        System.out.println("you have " + bag.numMedalsInBag() + " medals");
        System.out.println("Awards: ");

        System.out.println(bag.getBag());

    }

    // EFFECTS: add images
    public void displayImages() {
        model.AwardsBag bag = history.getAwardsBag();
        for (int i = 1; i <= (bag.numMedalsInBag()); i++) {
            int index = i - 1;
            System.out.println(bag.getBag().get(index));
            add(new JLabel(new ImageIcon(String.valueOf(bag.getBag().get(index)))));
        }
    }


    public static void main(String[] args) {
        new AwardsBag();
    }

}