package Managements;

import java.awt.Color;

import javax.swing.JPanel;

import INITIAL.Constants;

public class Staff extends JPanel {

    Staff() {
        setBackground(new Color(58, 57, 96));
        setSize(Constants.MAIN_DIMENSIONS[0], Constants.MAIN_DIMENSIONS[1]);
        setLocation(100, 0);
        setVisible(true);
    }
}
