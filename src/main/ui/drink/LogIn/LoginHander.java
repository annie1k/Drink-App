package ui.drink.LogIn;

import ui.drink.HomePage.DrinkIt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginHander implements ActionListener {
    private LoginView loginView;

    public LoginHander(LoginView loginView) {
        this.loginView = loginView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();
        if ("Clear".equals(text)) {
            loginView.getUserNameInput().setText("");
            loginView.getPwdInput().setText("");
        } else if ("Log In".equals(text)) {
            String user = loginView.getUserNameInput().getText();
            char[] chars = loginView.getPwdInput().getPassword();
            String pwd = new String(chars);
            System.out.println(user + " : " + pwd);


            if (isAdmin()) {
                new DrinkIt();
                System.out.println("true");
            } else {
                JOptionPane.showMessageDialog(loginView, "user name or password incorrect");
            }
        }
    }

    // EFFECTS: to see whether the username and password is correct
    public boolean isAdmin() {
        char[] chars = loginView.getPwdInput().getPassword();
        String pwd = new String(chars);
        System.out.println(loginView.getUserNameInput().getText());
        System.out.println(pwd);
        if (("annie" == loginView.getUserNameInput().getText()) && (pwd == "210")) {
            return true;
        } else {
            return false;
        }
    }
}
