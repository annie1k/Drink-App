package ui;

import model.DrinkHistory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class HistoryLatest extends JFrame {
    private DrinkHistory history = new DrinkHistory();
    private List<String> listHistory = new ArrayList<>();

    public HistoryLatest() {
        Container container = this.getContentPane();
        setTitle("History");
        JLabel label = new JLabel(String.valueOf(listOfHistory()));


        JScrollPane scrollPane = new JScrollPane(label);

        container.add(scrollPane);

        this.setVisible(true);
        this.setSize(200, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public List<String> listOfHistory() {

        for (int i = 0; i < history.numDatesRecorded(); i++) {
            listHistory.add(history.getDrinkHistory().get(i).combineDateBalance());
        }
        return listHistory;
    }

    public static void main(String[] args) {
        new HistoryLatest();
    }
}
