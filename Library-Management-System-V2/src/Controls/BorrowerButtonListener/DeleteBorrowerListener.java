package Controls.BorrowerButtonListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import Initial.Constants;

public class DeleteBorrowerListener implements MouseListener {

    JButton deleteButton;

    public DeleteBorrowerListener(JButton deleteButton) {
        this.deleteButton = deleteButton;
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
        deleteButton.setBackground(Constants.HOVER_COLOR);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        deleteButton.setBackground(Constants.BACK_COLOR);

    }

}
