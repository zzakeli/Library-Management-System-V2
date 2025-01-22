package Controls.FieldListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import INITIAL.Constants;

public class TitleFieldListener implements MouseListener {

    JTextField titleField;

    public TitleFieldListener(JTextField titleField) {
        this.titleField = titleField;
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
        titleField.setBackground(new Color(220, 220, 220));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        titleField.setBackground(Constants.MAIN_COLOR);
    }

}
