package Controls.BookButtonListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import INITIAL.Constants;

public class DeleteBookListener implements MouseListener {

    JButton deleteButton;

    public DeleteBookListener(JButton deleteButton) {
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
