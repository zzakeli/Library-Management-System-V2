package Managements.BorrowerPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controls.FieldListener.FieldListener;
import Controls.SubButtonListener.SubButtonListener;
import Initial.Constants;
import Managements.BorrowerPanel.SaveAction.SaveAddBorrowerAction;

public class AddBorrowerPanel extends JPanel {

    JButton addButton;
    JButton editButton;

    private DefaultTableModel model;
    private JTable borrowerTable;
    private JScrollPane tableScrollPane;

    public AddBorrowerPanel(JButton addButton, JButton editButton, DefaultTableModel model, JTable borrowerTable,
            JScrollPane tableScrollPane) {
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
        borrowerField.addMouseListener(new FieldListener(borrowerField));
        add(borrowerField);

        JTextField bookField = new JTextField();
        bookField.setSize(420, 40);
        bookField.setFont(new Font("Dialog", Font.PLAIN, 20));
        bookField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        bookField.setBackground(Constants.MAIN_COLOR);
        bookField.setLocation(29, 140);
        bookField.addMouseListener(new FieldListener(bookField));
        add(bookField);

        JTextField startDateField = new JTextField();
        startDateField.setSize(190, 40);
        startDateField.setFont(new Font("Dialog", Font.PLAIN, 20));
        startDateField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        startDateField.setBackground(Constants.MAIN_COLOR);
        startDateField.setLocation(29, 220);
        startDateField.addMouseListener(new FieldListener(startDateField));
        add(startDateField);

        JTextField dueDateField = new JTextField();
        dueDateField.setSize(190, 40);
        dueDateField.setFont(new Font("Dialog", Font.PLAIN, 20));
        dueDateField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        dueDateField.setBackground(Constants.MAIN_COLOR);
        dueDateField.setLocation(259, 220);
        dueDateField.addMouseListener(new FieldListener(dueDateField));
        add(dueDateField);

        JButton saveButton = new JButton("Save");
        saveButton.setBackground(Constants.MAIN_COLOR);
        saveButton.setFont(new Font("Dialog", Font.BOLD, 20));
        saveButton.setSize(160, 50);
        saveButton.setLocation(159, 310);
        saveButton.setFocusable(false);
        saveButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        saveButton.addMouseListener(new SubButtonListener(saveButton));
        saveButton.addActionListener(new SaveAddBorrowerAction(borrowerField, bookField, startDateField, dueDateField,
                addButton, editButton, model, borrowerTable, tableScrollPane, this));
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

        JLabel startDateLabel = new JLabel("Start");
        startDateLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        startDateLabel.setSize(100, 30);
        startDateLabel.setLocation(29, 190);
        add(startDateLabel);

        JLabel endDateLabel = new JLabel("End");
        endDateLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        endDateLabel.setSize(100, 30);
        endDateLabel.setLocation(259, 190);
        add(endDateLabel);
    }

}
