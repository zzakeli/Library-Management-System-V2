package Controls.FieldListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import Initial.Constants;

public class GenreFieldListener implements MouseListener {

    JTextField genreField;

    public GenreFieldListener(JTextField genreField) {
        this.genreField = genreField;
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
        genreField.setBackground(new Color(220, 220, 220));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        genreField.setBackground(Constants.MAIN_COLOR);
    }

}
