package Controls.BorrowerButtonListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import Initial.Constants;

public class AddBorrowerListener implements MouseListener {

    JButton addButton;

    public AddBorrowerListener(JButton addButton) {
        this.addButton = addButton;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        addButton.setBackground(Constants.HOVER_COLOR);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        addButton.setBackground(Constants.BACK_COLOR);
    }

}
