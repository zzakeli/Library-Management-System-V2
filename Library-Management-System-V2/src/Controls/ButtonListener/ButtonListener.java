package Controls.ButtonListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import Initial.Constants;

public class ButtonListener implements MouseListener {

    JButton button;

    public ButtonListener(JButton button) {
        this.button = button;
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
        button.setBackground(Constants.HOVER_COLOR);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        button.setBackground(Constants.BACK_COLOR);
    }

}
