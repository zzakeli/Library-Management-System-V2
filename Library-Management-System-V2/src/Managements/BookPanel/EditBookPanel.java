package Managements.BookPanel;

import java.awt.*;

import javax.swing.*;

import Initial.Constants;

public class EditBookPanel extends JPanel {

    public EditBookPanel() {
        setLayout(null);
        setBackground(Constants.BACK_COLOR);
        setSize(500, 500);
        setLocation(320, 110);
        setVisible(false);
        setBorder(BorderFactory.createLineBorder(Color.black, 3));
        constructPanel();
    }

    private void constructPanel() {

    }
}
