package ui.drink.history;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//class of action listener for history class of GUI
public class HistoryHandler implements ActionListener {
    private HistoryPage app;

    //constructor
    public HistoryHandler(HistoryPage app) {
        this.app = app;
    }

    //Modifies: History, AwardsBag
    //EFFECTS: return a empty history list and empty bag
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Clear")) {
            app.clear();
        }
    }
}
