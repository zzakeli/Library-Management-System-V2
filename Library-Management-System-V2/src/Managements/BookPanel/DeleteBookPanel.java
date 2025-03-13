package Managements.BookPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Controls.FieldListener.FieldListener;
import Initial.Constants;

public class DeleteBookPanel extends JPanel {

    JButton addButton;
    JButton editButton;

    public DeleteBookPanel(JButton addButton, JButton editButton) {
        setLayout(null);
        setBackground(Constants.BACK_COLOR);
        setSize(480, 450);
        setLocation(320, 110);
        setVisible(false);
        setBorder(BorderFactory.createLineBorder(Color.black, 3));
        initButtons(addButton, editButton);
        constructPanel();
    }

    private void initButtons(JButton addButton, JButton editButton) {
        this.addButton = addButton;
        this.editButton = editButton;
    }

    private void constructPanel() {

        JLabel closeButton = new JLabel();
        closeButton.setSize(Constants.CLOSE_SIZE, Constants.CLOSE_SIZE);
        closeButton.setLocation(430, 20);
        ImageIcon closeIcon = new ImageIcon("Library-Management-System-V2/src/Icons/close.png");
        Image closeImage = closeIcon.getImage();
        Image closeScale = closeImage.getScaledInstance(closeButton.getWidth(), closeButton.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon scaledClose = new ImageIcon(closeScale);
        closeButton.setIcon(scaledClose);
        closeButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                addButton.setEnabled(true);
                editButton.setEnabled(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        add(closeButton);

        JLabel titleLabel = new JLabel("Title");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        titleLabel.setSize(100, 30);
        titleLabel.setLocation(29, 40);
        add(titleLabel);

        JTextField searchField = new JTextField();
        searchField.setSize(420, 60);
        searchField.setFont(new Font("Dialog", Font.PLAIN, 25));
        searchField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        searchField.setBackground(Constants.MAIN_COLOR);
        searchField.setLocation(29, 70);
        searchField.addMouseListener(new FieldListener(searchField));
        add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setBackground(Constants.MAIN_COLOR);
        searchButton.setFont(new Font("Dialog", Font.BOLD, 20));
        searchButton.setSize(160, 50);
        searchButton.setLocation(159, 180);
        searchButton.setFocusable(false);
        searchButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        searchButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Show the matching book title when entered
                // else prompt the book title not found.
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                searchButton.setBackground(new Color(220, 220, 220));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                searchButton.setBackground(Constants.MAIN_COLOR);
            }

        });
        add(searchButton);
    }
}
