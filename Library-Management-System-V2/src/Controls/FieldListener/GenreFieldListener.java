package Controls.FieldListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import Managements.BookPanel.AddBookPanel;
import Managements.BookPanel.EditBookPanel;

public class GenreFieldListener implements MouseListener {

    JTextField field;
    AddBookPanel addBookPanel;
    EditBookPanel editBookPanel;
    int x = 0;

    public GenreFieldListener(JTextField field, AddBookPanel addBookPanel) {
        this.field = field;
        this.addBookPanel = addBookPanel;
        x = 0;
    }

    public GenreFieldListener(JTextField field, EditBookPanel editBookPanel) {
        this.field = field;
        this.editBookPanel = editBookPanel;
        x = 1;
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
        if (x == 0) {
            addBookPanel.showGenreSelection();
            return;
        }
        editBookPanel.showGenreSelection();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (x == 0) {
            addBookPanel.hideGenreSelection();
            return;
        }
        editBookPanel.hideGenreSelection();

    }

}
