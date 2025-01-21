package Controls.BlockListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class TPListener implements MouseListener {

    JPanel totalPrice;

    public TPListener(JPanel totalPrice) {
        this.totalPrice = totalPrice;
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
        totalPrice.setBackground(new Color(220, 220, 220));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        totalPrice.setBackground(new Color(183, 183, 183));
    }

}
