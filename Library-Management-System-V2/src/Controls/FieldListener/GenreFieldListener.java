package Controls.FieldListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import Managements.BookPanel.AddBookPanel;

public class GenreFieldListener implements MouseListener {

    JTextField field;
    AddBookPanel addBookPanel;

    public GenreFieldListener(JTextField field, AddBookPanel addBookPanel) {
        this.field = field;
        this.addBookPanel = addBookPanel;
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
        addBookPanel.showGenreSelection();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        addBookPanel.hideGenreSelection();
    }

}
