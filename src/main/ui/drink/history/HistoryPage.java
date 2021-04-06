package ui.drink.history;

import model.DrinkHistory;
import ui.drink.SubPages;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Class for list of History for GUI

public class HistoryPage extends JFrame implements SubPages {
    private DrinkHistory history;
    private List<String> listHistory;
    private JButton clearButton;
    private JTextArea textArea;

    // constructor
    public HistoryPage(DrinkHistory history) {
        JPanel southPanel = new JPanel();
        this.history = history;
        listHistory = new ArrayList<>();
        listOfHistory();
        Container container = this.getContentPane();
        setUp();

        System.out.println(listHistory.size());

        for (int i = 0; i < listHistory.size(); i++) {
            textArea.setText(textArea.getText() + "\n" + listHistory.get(i));
        }

        JScrollPane scrollPane = new JScrollPane(textArea);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new HistoryHandler(this));
        southPanel.add(clearButton);

        container.add(scrollPane,BorderLayout.CENTER);
        container.add(southPanel,BorderLayout.SOUTH);


        quit();
    }

    //MODIFIES: this
    //EFFECTS: close this page
    @Override
    public void quit() {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    //MODIFIES: this
    //EFFECTS: set up this page
    @Override
    public void setUp() {
        setTitle("History");
        textArea = new JTextArea(listHistory.size(),1);
        this.setVisible(true);
        this.setSize(200, 200);
    }

    // MODIFIES: DrinkHistory
    // EFFECTS: a list of history
    public List<String> listOfHistory() {

        for (int i = 0; i < history.numDatesRecorded(); i++) {
            listHistory.add(history.getDrinkHistory().get(i).combineDateBalance());
        }
        return listHistory;
    }

    // MODIFIES: DrinkHistory, Awards
    // EFFECTS: clear history and award bag
    public void clear() {
        history.clearHistory();
        textArea.setText("");
    }

}
