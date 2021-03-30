package ui.drink.history;

import model.DrinkHistory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryHandler implements ActionListener {
    private History app;

    public HistoryHandler(History app) {
        this.app = app;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Clear")) {
            app.clear();
        }
    }
}
