// This is the rewarded metal bag that collects all the metal earned by users

package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AwardsBag implements Writable {


    // changing properties of awards bag
    // list of medal images in the bag
    private final List<String> medals;


    // EFFECTS: constructs an empty collection of medals that earned
    public AwardsBag() {
        this.medals = new ArrayList<>();
    }



    // MODIFIES: this
    // EFFECTS: adds a new medal to the collection of medal to awards bag
    public void addRandMedal() {
        Random rand = new Random();
        int randMedalNum = rand.nextInt(10) + 1;
        String randMedal = randMedalNum + ".png"; // Is this the problem?
        this.medals.add(randMedal);
    }

    // MODIFIES: this
    // EFFECTS: adds a new medal to the collection of medal to awards bag
    public void addMedal(String m) {
        String medal = m;
        this.medals.add(medal);
    }

    // EFFECTS: remove the last medal
    public void subLastMedal() {
        int index = this.medals.size() - 1;
        medals.remove(index);
    }

    // EFFECTS: returns number of medals in bag
    public int numMedalsInBag() {
        return this.medals.size();
    }

    // EFFECT: return the bag
    public List<String> getBag() {
        return this.medals;
    }


    //EFFECTS: return json
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("total number", numMedalsInBag()); // is this okay???
        json.put("medals", medalsToJson());
        return json;
    }

    // EFFECTS: returns things in this awards bag as a JSON array
    private JSONArray medalsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (String m : medals) {
            jsonArray.put(m); // can this work?
        }

        return jsonArray;
    }


}
