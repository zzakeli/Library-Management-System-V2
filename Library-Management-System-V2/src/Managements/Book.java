package Managements;

import java.awt.*;

import javax.swing.*;

import Controls.BookButtonListener.*;
import Functions.Functions;
import INITIAL.Constants;

public class Book extends JPanel implements Functions {

    public Book() {
        setLayout(null);
        setBackground(Constants.MAIN_COLOR);
        setSize(Constants.MAIN_DIMENSIONS[0], Constants.MAIN_DIMENSIONS[1]);
        setLocation(100, 0);
        setVisible(false);
        displayLabel();
        displayButtons();
        displayTable();
    }

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void edit() {

    }

    public void displayLabel() {
        JLabel bookSection = new JLabel("Book Section");
        bookSection.setSize(1280, 50);
        bookSection.setLocation(275, 55);
        bookSection.setHorizontalAlignment(SwingConstants.CENTER);
        bookSection.setFont(new Font("Dialog", Font.BOLD, 50));
        add(bookSection);
    }

    public void displayButtons() {
        JButton addButton = new JButton("ADD BOOK");
        addButton.setFont(Constants.BUTTON_FONT);
        addButton.setForeground(Constants.FORE_COLOR);
        addButton.setBackground(Constants.BACK_COLOR);
        addButton.setFocusable(false);
        addButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        addButton.setSize(180, 70);
        addButton.setLocation(70, 50);
        addButton.addMouseListener(new AddBookListener(addButton));
        add(addButton);

        JButton editButton = new JButton("EDIT BOOK");
        editButton.setFont(Constants.BUTTON_FONT);
        editButton.setForeground(Constants.FORE_COLOR);
        editButton.setBackground(Constants.BACK_COLOR);
        editButton.setFocusable(false);
        editButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        editButton.setSize(180, 70);
        editButton.setLocation(280, 50);
        editButton.addMouseListener(new EditBookListener(editButton));
        add(editButton);

        JButton deleteButton = new JButton("DELETE BOOK");
        deleteButton.setFont(Constants.BUTTON_FONT);
        deleteButton.setForeground(Constants.FORE_COLOR);
        deleteButton.setBackground(Constants.BACK_COLOR);
        deleteButton.setFocusable(false);
        deleteButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        deleteButton.setSize(180, 70);
        deleteButton.setLocation(490, 50);
        deleteButton.addMouseListener(new DeleteBookListener(deleteButton));
        add(deleteButton);
    }

    public void displayTable() {

    }
}
