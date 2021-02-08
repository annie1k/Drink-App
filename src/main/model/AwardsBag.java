// This is the rewarded metal bag that collects all the metal earned by users

package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AwardsBag {

    // changing properties of awards bag
    // list of medal images in the bag
    private List<JLabel> medals;


    // EFFECTS: constructs an empty collection of medals that earned
    public AwardsBag() {
        this.medals = new ArrayList<>();
    }



    // MODIFIES: this
    // EFFECTS: adds a new medal to the collection of medal to awards bag
    public void addRandMedal() {
        Random rand = new Random();
        int randMedalNum = rand.nextInt(11);
        JLabel randMedal = new JLabel(new ImageIcon(randMedalNum + ".png"));
        this.medals.add(randMedal);
    }

    // EFFECTS: returns number of medals in bag
    public int numMedalsInBag() {
        return this.medals.size();
    }
}
