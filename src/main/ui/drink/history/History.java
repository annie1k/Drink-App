package ui.drink.history;

import model.DrinkHistory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class History extends JFrame {
    private DrinkHistory history;
    private List<String> listHistory;
    private JButton clearButton;
    private JTextArea textArea;

    public History(DrinkHistory history) {
        JPanel southPanel = new JPanel();
        this.history = history;
        listHistory = new ArrayList<>();
        listOfHistory();
        Container container = this.getContentPane();
        setTitle("History");

        textArea = new JTextArea(listHistory.size(),1);

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

        this.setVisible(true);
        this.setSize(200, 200);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public List<String> listOfHistory() {

        for (int i = 0; i < history.numDatesRecorded(); i++) {
            listHistory.add(history.getDrinkHistory().get(i).combineDateBalance());
        }
        return listHistory;
    }

    public void clear() {
        history.clearHistory();
        textArea.setText("");
    }

}
