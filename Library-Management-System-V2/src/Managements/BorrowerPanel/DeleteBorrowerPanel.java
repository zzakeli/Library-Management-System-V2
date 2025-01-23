package Managements.BorrowerPanel;

import java.awt.*;

import javax.swing.*;
import Initial.Constants;

public class DeleteBorrowerPanel extends JPanel {

    JButton addButton;
    JButton editButton;
    JButton deleteButton;

    public DeleteBorrowerPanel(JButton addButton, JButton editButton, JButton deleteButton) {
        setLayout(null);
        setBackground(Constants.BACK_COLOR);
        setSize(480, 450);
        setLocation(320, 110);
        setVisible(false);
        setBorder(BorderFactory.createLineBorder(Color.black, 3));
        initButtons(addButton, editButton, deleteButton);
        constructPanel();
    }

    private void initButtons(JButton addButton, JButton editButton, JButton deleteButton) {
        this.addButton = addButton;
        this.editButton = editButton;
        this.deleteButton = deleteButton;
    }

    private void constructPanel() {

    }
}
