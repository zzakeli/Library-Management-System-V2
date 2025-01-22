package Controls.FieldListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import INITIAL.Constants;

public class WorthFieldListener implements MouseListener {

    JTextField worthField;

    public WorthFieldListener(JTextField worthField) {
        this.worthField = worthField;
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
        worthField.setBackground(new Color(220, 220, 220));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        worthField.setBackground(Constants.MAIN_COLOR);
    }

}
