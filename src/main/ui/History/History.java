package ui.History;

import javax.swing.*;
import java.awt.*;

public class History extends JFrame {
    public History() {
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2,1,10,10));

        JPanel listPanel  = new JPanel(new GridLayout(1,2));
        listPanel.add(new JTextField());
        container.add(listPanel);

        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new History();
    }
}
