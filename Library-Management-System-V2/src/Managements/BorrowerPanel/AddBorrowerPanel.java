package Managements.BorrowerPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Controls.FieldListener.*;
import Initial.Constants;

public class AddBorrowerPanel extends JPanel {

    JButton addButton;
    JButton editButton;
    JButton deleteButton;

    public AddBorrowerPanel(JButton addButton, JButton editButton, JButton deleteButton) {
        setLayout(null);
        setBackground(Constants.BACK_COLOR);
        setSize(480, 450);
        setLocation(320, 110);
        setVisible(false);
        setBorder(BorderFactory.createLineBorder(Color.black, 3));
        initButtons(addButton, editButton, deleteButton);
        constructPanel();
    }

    private void initButtons(JButton addButton, JButton editButton, JButton deleteButton) {
        this.addButton = addButton;
        this.editButton = editButton;
        this.deleteButton = deleteButton;
    }

    private void constructPanel() {
        JLabel closeButton = new JLabel();
        closeButton.setSize(Constants.CLOSE_SIZE, Constants.CLOSE_SIZE);
        closeButton.setLocation(430, 15);
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
                deleteButton.setEnabled(true);
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

        JTextField borrowerField = new JTextField();
        borrowerField.setSize(420, 40);
        borrowerField.setFont(new Font("Dialog", Font.PLAIN, 20));
        borrowerField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        borrowerField.setBackground(Constants.MAIN_COLOR);
        borrowerField.setLocation(29, 60);
        borrowerField.addMouseListener(new TitleFieldListener(borrowerField));
        add(borrowerField);

        JTextField bookField = new JTextField();
        bookField.setSize(420, 40);
        bookField.setFont(new Font("Dialog", Font.PLAIN, 20));
        bookField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        bookField.setBackground(Constants.MAIN_COLOR);
        bookField.setLocation(29, 140);
        bookField.addMouseListener(new TitleFieldListener(bookField));
        add(bookField);

        JButton saveButton = new JButton("Save");
        saveButton.setBackground(Constants.MAIN_COLOR);
        saveButton.setFont(new Font("Dialog", Font.BOLD, 20));
        saveButton.setSize(160, 50);
        saveButton.setLocation(159, 310);
        saveButton.setFocusable(false);
        saveButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        saveButton.addMouseListener(new MouseListener() {

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
                saveButton.setBackground(new Color(220, 220, 220));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                saveButton.setBackground(Constants.MAIN_COLOR);
            }

        });
        add(saveButton);

        addLabels();
    }

    private void addLabels() {
        JLabel borrowerLabel = new JLabel("Borrower");
        borrowerLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        borrowerLabel.setSize(100, 30);
        borrowerLabel.setLocation(29, 30);
        add(borrowerLabel);

        JLabel bookLabel = new JLabel("Book");
        bookLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        bookLabel.setSize(100, 30);
        bookLabel.setLocation(29, 110);
        add(bookLabel);

    }

}
