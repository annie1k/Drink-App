package ui;

import model.DrinkHistory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class History extends JFrame {
    private DrinkHistory history = new DrinkHistory();
    private List<String> listHistory = new ArrayList<>();

    public History() {
        Container container = this.getContentPane();
        setTitle("History");
        JTable table = new JTable();
        Vector<String> columns = new Vector<>();
        columns.addElement("Date with according balance");

        Vector<Vector<Object>> data = new Vector<>();
        Vector<Object> rowVector = new Vector<>();
        // add rows


        DefaultTableModel model = new DefaultTableModel();
        model.setDataVector(data,columns);


        JScrollPane scrollPane = new JScrollPane();

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
        new History();
    }
}
