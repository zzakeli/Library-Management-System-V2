package Controls.FieldListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import INITIAL.Constants;

public class AuthorFieldListener implements MouseListener {

    JTextField authorField;

    public AuthorFieldListener(JTextField authorField) {
        this.authorField = authorField;
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
        authorField.setBackground(new Color(220, 220, 220));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        authorField.setBackground(Constants.MAIN_COLOR);
    }

}
