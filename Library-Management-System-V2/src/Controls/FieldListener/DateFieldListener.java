package Controls.FieldListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextField;

import Initial.Constants;

public class DateFieldListener implements MouseListener {

    JTextField datePublishedField;

    public DateFieldListener(JTextField datePublishedField) {
        this.datePublishedField = datePublishedField;
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
        datePublishedField.setBackground(new Color(220, 220, 220));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        datePublishedField.setBackground(Constants.MAIN_COLOR);
    }

}
