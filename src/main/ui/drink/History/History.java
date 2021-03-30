package ui.drink.History;

import model.DrinkHistory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class History extends JFrame {
    private DrinkHistory history;
    private List<String> listHistory;

    public History(DrinkHistory history) {
        this.history = history;
        listHistory = new ArrayList<>();
        listOfHistory();
        Container container = this.getContentPane();
        setTitle("History");

        JTextArea textArea = new JTextArea(listHistory.size(),1);

        System.out.println(listHistory.size());

        for (int i = 0; i < listHistory.size(); i++) {
            textArea.setText(textArea.getText() + "\n" + listHistory.get(i));
        }

        JScrollPane scrollPane = new JScrollPane(textArea);

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

}
