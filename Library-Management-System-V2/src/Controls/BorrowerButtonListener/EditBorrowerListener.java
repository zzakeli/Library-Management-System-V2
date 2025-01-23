package Controls.BorrowerButtonListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import Initial.Constants;

public class EditBorrowerListener implements MouseListener {

    JButton editButton;

    public EditBorrowerListener(JButton editButton) {
        this.editButton = editButton;
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
        editButton.setBackground(Constants.HOVER_COLOR);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        editButton.setBackground(Constants.BACK_COLOR);
    }

}
