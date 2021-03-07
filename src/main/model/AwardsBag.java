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
    private static List<Medal> medals;
    private static Medal medal;


    // EFFECTS: constructs an empty collection of medals that earned
    public AwardsBag() {
        this.medals = new ArrayList<>();
    }


    // MODIFIES: this
    // EFFECTS: adds a new medal to the collection of medal to awards bag
    public void addRandMedal(int day, int month, int year) {
        Random rand = new Random();
        Medal medal = new Medal();
        int randMedalNum = rand.nextInt(10) + 1;
        String randMedal = randMedalNum + ".png";
        medal.setImg(randMedal);
        medal.setDay(day);
        medal.setMonth(month);
        medal.setYear(year);
        medal.getDate();

        this.medals.add(medal);
    }

    // MODIFIES: this
    // EFFECTS: adds a new medal to the collection of medal to awards bag
    public void addMedal(Medal m) {
        this.medals.add(m);
    }

    // MODIFIES: this
    // EFFECTS: remove a new medal to the collection of medal to awards bag
    public void removeMedal(Medal m) {
        this.medals.remove(m);
    }

    // EFFECT: add and return the drinking balance if it is not in the history, if exist, just return the original one
    public static Medal findMedal(String date) {

        for (int i = 0; i < medals.size(); i++) {
            Medal m = medals.get(i);
            String historyDate = m.getDate();
            if (date.equals(historyDate)) {
                return m;
            }
        }
        return null;
    }




    // EFFECTS: returns number of medals in bag
    public int numMedalsInBag() {
        return this.medals.size();
    }

    // EFFECT: return the bag
    public List<Medal> getBag() {
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

        for (Medal m : medals) {
            JSONObject jo = new JSONObject();
            jo.put("day",m.getDay());
            jo.put("month",m.getMonth());
            jo.put("year",m.getYear());
            jo.put("img",m.getImg());
            jsonArray.put(jo); // can this work?
        }

        return jsonArray;
    }

    @Override
    public String toString() {
        JSONArray jsonArray = new JSONArray();

        for (Medal m : medals) {

            jsonArray.put(m.toString());
        }

        return jsonArray.toString();
    }


}
