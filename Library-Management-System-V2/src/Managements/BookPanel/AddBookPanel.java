package Managements.BookPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Controls.FieldListener.*;
import Controls.SubButtonListener.SubButtonListener;
import Initial.Constants;

public class AddBookPanel extends JPanel {

    JButton addButton;
    JButton editButton;
    JButton deleteButton;

    public AddBookPanel(JButton addButton, JButton editButton, JButton deleteButton) {
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

        JTextField titleField = new JTextField();
        titleField.setSize(420, 40);
        titleField.setFont(new Font("Dialog", Font.PLAIN, 20));
        titleField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        titleField.setBackground(Constants.MAIN_COLOR);
        titleField.setLocation(29, 60);
        titleField.addMouseListener(new FieldListener(titleField));
        add(titleField);

        JTextField authorField = new JTextField();
        authorField.setSize(200, 40);
        authorField.setFont(new Font("Dialog", Font.PLAIN, 15));
        authorField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        authorField.setBackground(Constants.MAIN_COLOR);
        authorField.setLocation(29, 140);
        authorField.addMouseListener(new FieldListener(authorField));
        add(authorField);

        JTextField datePublishedField = new JTextField();
        datePublishedField.setSize(200, 40);
        datePublishedField.setFont(new Font("Dialog", Font.PLAIN, 15));
        datePublishedField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        datePublishedField.setBackground(Constants.MAIN_COLOR);
        datePublishedField.setLocation(249, 140);
        datePublishedField.addMouseListener(new FieldListener(datePublishedField));
        add(datePublishedField);

        JTextField genreField = new JTextField();
        genreField.setSize(200, 40);
        genreField.setFont(new Font("Dialog", Font.PLAIN, 15));
        genreField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        genreField.setBackground(Constants.MAIN_COLOR);
        genreField.setLocation(29, 230);
        genreField.addMouseListener(new FieldListener(genreField));
        add(genreField);

        JTextField worthField = new JTextField();
        worthField.setSize(200, 40);
        worthField.setFont(new Font("Dialog", Font.PLAIN, 15));
        worthField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        worthField.setBackground(Constants.MAIN_COLOR);
        worthField.setLocation(249, 230);
        worthField.addMouseListener(new FieldListener(worthField));
        add(worthField);

        JButton saveButton = new JButton("Save");
        saveButton.setBackground(Constants.MAIN_COLOR);
        saveButton.setFont(new Font("Dialog", Font.BOLD, 20));
        saveButton.setSize(160, 50);
        saveButton.setLocation(159, 310);
        saveButton.setFocusable(false);
        saveButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        saveButton.addMouseListener(new SubButtonListener(saveButton));
        add(saveButton);

        addLabels();
    }

    private void addLabels() {
        JLabel titleLabel = new JLabel("Title");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        titleLabel.setSize(100, 30);
        titleLabel.setLocation(29, 30);
        add(titleLabel);

        JLabel authorLabel = new JLabel("Author");
        authorLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        authorLabel.setSize(100, 30);
        authorLabel.setLocation(29, 110);
        add(authorLabel);

        JLabel datePublishedLabel = new JLabel("Date Published");
        datePublishedLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        datePublishedLabel.setSize(200, 30);
        datePublishedLabel.setLocation(249, 110);
        add(datePublishedLabel);

        JLabel genreLabel = new JLabel("Genre");
        genreLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        genreLabel.setSize(200, 30);
        genreLabel.setLocation(29, 200);
        add(genreLabel);

        JLabel worthLabel = new JLabel("Worth");
        worthLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        worthLabel.setSize(200, 30);
        worthLabel.setLocation(249, 200);
        add(worthLabel);
    }

}
