package ui.drink.home;

import model.DrinkHistory;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.drink.history.HistoryPage;
import ui.drink.awards.AwardsBagPage;
import ui.drink.balance.AddDrinkingPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// class of action listener for DrinkIt GUI frame
public class HPActionListener implements ActionListener {
    private static final String JSON_STORE = "./data/drinkApp.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private DrinkHistory history = new DrinkHistory();
    private DrinkIt app;

    public HPActionListener(DrinkIt app) {
        this.app = app;

    }

    //EFFECTS: open according page if click the corresponding page, or load, save the history and bag
    @Override
    public void actionPerformed(ActionEvent e) {

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        if (e.getActionCommand().equals("drinking")) {
            new AddDrinkingPage(history);
        } else if (e.getActionCommand().equals("history")) {
            DrinkHistory history = app.getDrinkHistory();
            new HistoryPage(history);
        } else if (e.getActionCommand().equals("bag")) {
            new AwardsBagPage(history); //haven't fully implemented
        } else if (e.getActionCommand().equals("load")) {
            loadHistoryAndAwards();
        } else {
            saveHistoryAndAwards();
        }
    }

    // EFFECTS: saves the history and awards to file
    private void saveHistoryAndAwards() {
        try {
            jsonWriter.open();
            jsonWriter.write(history);
            System.out.println(history.toString());
            jsonWriter.close();
            JOptionPane.showMessageDialog(app,
                    "Saved history and awards" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(app,
                    "Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads history and awards from file
    private void loadHistoryAndAwards() {
        try {
            history = jsonReader.readHistory();
            app.setDrinkHistory(history);
            JOptionPane.showMessageDialog(app,
                    "Loaded history and awards bag" + " from " + JSON_STORE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(app,
                    "Unable to read from file:" + " from " + JSON_STORE);
        }


    }
}
