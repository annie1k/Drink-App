package ui.drink.login;

import javax.swing.*;
import java.awt.*;

//class for the LoginView GUI page
public class LoginView extends JFrame {

    JLabel nameLabel = new JLabel("Welcome to Drink It App",JLabel.CENTER);


    SpringLayout springLayout = new SpringLayout();
    JPanel centerPanel = new JPanel(springLayout);
    JLabel userNameLabel = new JLabel("username");
    JTextField userNameInput = new JTextField();
    JLabel pwdLabel = new JLabel("password");
    JPasswordField pwdInput = new JPasswordField();
    JButton loginBtn = new JButton("Log In");
    JButton resetBtn = new JButton("Clear");
    LoginHandler loginHandler;

    // constructor
    public LoginView() {
        super("Drink It App");
        Container contentPane = getContentPane();

        setFontAndAdd(nameLabel,userNameLabel,userNameInput,pwdLabel,pwdInput,loginBtn,resetBtn);

        setLayout(userNameLabel,userNameInput,pwdLabel,pwdInput,loginBtn,resetBtn);

        loginHandler = new LoginHandler(this);

        loginBtn.addActionListener(loginHandler);
        resetBtn.addActionListener(loginHandler);

        contentPane.add(nameLabel,BorderLayout.NORTH);
        contentPane.add(centerPanel,BorderLayout.CENTER);

        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    // Modify: this
    // Effects: set layout for the log in view
    private void setLayout(JLabel userNameLabel, JTextField userNameInput,
                           JLabel pwdLabel, JPasswordField pwdInput, JButton loginBtn, JButton resetBtn) {
        Spring userWidth = Spring.sum(Spring.sum(Spring.width(userNameLabel),Spring.width(userNameInput)),
                Spring.constant(20));

        int offsetX = userWidth.getValue() / 2;

        springLayout.putConstraint(SpringLayout.WEST,userNameLabel,-offsetX,
                SpringLayout.HORIZONTAL_CENTER,centerPanel);
        springLayout.putConstraint(SpringLayout.NORTH,userNameLabel,20,
                SpringLayout.NORTH,centerPanel);

        springLayout.putConstraint(SpringLayout.WEST,userNameInput,20,SpringLayout.EAST,userNameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,userNameInput,0,SpringLayout.NORTH,userNameLabel);

        springLayout.putConstraint(SpringLayout.EAST,pwdLabel,0,SpringLayout.EAST,userNameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,pwdLabel,20,SpringLayout.SOUTH,userNameLabel);

        springLayout.putConstraint(SpringLayout.WEST,pwdInput,20,SpringLayout.EAST,pwdLabel);
        springLayout.putConstraint(SpringLayout.NORTH,pwdInput,0,SpringLayout.NORTH,pwdLabel);

        springLayout.putConstraint(SpringLayout.WEST,loginBtn,50,SpringLayout.WEST,pwdLabel);
        springLayout.putConstraint(SpringLayout.NORTH,loginBtn,20,SpringLayout.SOUTH,pwdLabel);

        springLayout.putConstraint(SpringLayout.WEST,resetBtn,50,SpringLayout.EAST,loginBtn);
        springLayout.putConstraint(SpringLayout.NORTH,resetBtn,0,SpringLayout.NORTH,loginBtn);
    }

    // Modify: this
    // Effects: set front for each objects and add to the panel
    private void setFontAndAdd(JLabel nameLabel, JLabel userNameLabel, JTextField userNameInput,
                               JLabel pwdLabel, JPasswordField pwdInput, JButton loginBtn, JButton resetBtn) {
        nameLabel.setFont(new Font("",Font.BOLD,40));
        nameLabel.setPreferredSize(new Dimension(0,80));
        userNameLabel.setFont(new Font("",Font.PLAIN,20));
        userNameInput.setPreferredSize(new Dimension(200,30));
        pwdLabel.setFont(new Font("",Font.PLAIN,20));
        pwdInput.setPreferredSize(new Dimension(200,30));
        loginBtn.setFont(new Font("",Font.PLAIN,20));
        resetBtn.setFont(new Font("",Font.PLAIN,20));

        centerPanel.add(userNameInput);
        centerPanel.add(userNameLabel);
        centerPanel.add(pwdInput);
        centerPanel.add(pwdLabel);
        centerPanel.add(loginBtn);
        centerPanel.add(resetBtn);
    }

    //EFFECTS: return user name input from user
    public JTextField getUserNameInput() {
        return userNameInput;
    }

    //EFFECTS: return password input from user
    public JPasswordField getPwdInput() {
        return pwdInput;
    }

}
