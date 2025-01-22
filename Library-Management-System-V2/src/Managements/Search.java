package Managements;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Initial.Constants;

public class Search extends JPanel {

    public Search() {
        setBackground(new Color(58, 57, 96));
        setSize(Constants.MAIN_DIMENSIONS[0], Constants.MAIN_DIMENSIONS[1]);
        setLocation(100, 0);
        setVisible(false);
        displayLabel();
    }

    public void displayLabel() {
        JLabel label = new JLabel("Search");
        label.setFont(new Font("Dialog", Font.PLAIN, 50));
        add(label);
    }
}
