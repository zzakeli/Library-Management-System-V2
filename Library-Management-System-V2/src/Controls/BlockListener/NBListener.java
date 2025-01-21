package Controls.BlockListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class NBListener implements MouseListener {

    JPanel numBorrower;

    public NBListener(JPanel numBorrower) {
        this.numBorrower = numBorrower;
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
        numBorrower.setBackground(new Color(220, 220, 220));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        numBorrower.setBackground(new Color(183, 183, 183));
    }

}
