package ui.HomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HPActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("drinking")) {
            System.out.println("drinking");
        } else if (e.getActionCommand().equals("history")) {
            System.out.println("history");
        } else if (e.getActionCommand().equals("bag")) {
            System.out.println("bag");
        } else if (e.getActionCommand().equals("load")) {
            System.out.println("load");
        } else {
            System.out.println("save");
        }
    }
}
