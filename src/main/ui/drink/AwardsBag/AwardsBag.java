package ui.drink.AwardsBag;


import model.Medal;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

//"./MetalBank/1.png"
//https://stackoverflow.com/questions/18027833/adding-image-to-jframe/18027889

public class AwardsBag extends JFrame {

    private Medal image;

    public AwardsBag() {
        super("Awards");
        add(new JLabel(new ImageIcon("./MetalBank/1.png")));
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }




    public static void main(String[] args) {
        new AwardsBag();
    }

}