package Managements;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import INITIAL.Constants;

public class Staff extends JPanel {

    public Staff() {
        setBackground(new Color(58, 57, 96));
        setSize(Constants.MAIN_DIMENSIONS[0], Constants.MAIN_DIMENSIONS[1]);
        setLocation(100, 0);
        setVisible(false);
        displayLabel();
    }

    public void displayLabel() {
        JLabel label = new JLabel("Staff");
        label.setFont(new Font("Dialog", Font.PLAIN, 50));
        add(label);
    }
}
