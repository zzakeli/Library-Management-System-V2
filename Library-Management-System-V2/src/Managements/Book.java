package Managements;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controls.BookButtonListener.*;
import Functions.Functions;
import Initial.Constants;
import Managements.BookPanel.*;

public class Book extends JPanel implements Functions {

    protected AddBookPanel addBookPanel = new AddBookPanel();
    protected EditBookPanel editBookPanel = new EditBookPanel();
    protected DeleteBookPanel deleteBookPanel = new DeleteBookPanel();

    public Book() {
        setLayout(null);
        setBackground(Constants.MAIN_COLOR);
        setSize(Constants.MAIN_DIMENSIONS[0], Constants.MAIN_DIMENSIONS[1]);
        setLocation(100, 0);
        setVisible(false);

        add(addBookPanel);
        add(editBookPanel);
        add(deleteBookPanel);

        displayLabel();
        displayButtons();
        displayTable();
    }

    @Override
    public void add() {
        addBookPanel.setVisible(true);
        addButton.setEnabled(false);
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }

    @Override
    public void edit() {
        editBookPanel.setVisible(true);
        addButton.setEnabled(false);
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }

    @Override
    public void delete() {
        deleteBookPanel.setVisible(true);
        addButton.setEnabled(false);
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }

    private void displayLabel() {
        JLabel bookSection = new JLabel("Book Section");
        bookSection.setSize(1280, 50);
        bookSection.setLocation(275, 35);
        bookSection.setHorizontalAlignment(SwingConstants.CENTER);
        bookSection.setFont(new Font("Dialog", Font.BOLD, 50));
        add(bookSection);
    }

    protected JButton addButton = new JButton("ADD BOOK");
    protected JButton editButton = new JButton("EDIT BOOK");
    protected JButton deleteButton = new JButton("DELETE BOOK");

    private void displayButtons() {
        addButton.setFocusable(false);
        addButton.setFont(Constants.BUTTON_FONT);
        addButton.setForeground(Constants.FORE_COLOR);
        addButton.setBackground(Constants.BACK_COLOR);
        addButton.setFocusable(false);
        addButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        addButton.setSize(180, 70);
        addButton.setLocation(70, 30);
        addButton.addMouseListener(new AddBookListener(addButton));
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                add();
            }

        });
        add(addButton);

        editButton.setFocusable(false);
        editButton.setFont(Constants.BUTTON_FONT);
        editButton.setForeground(Constants.FORE_COLOR);
        editButton.setBackground(Constants.BACK_COLOR);
        editButton.setFocusable(false);
        editButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        editButton.setSize(180, 70);
        editButton.setLocation(280, 30);
        editButton.addMouseListener(new EditBookListener(editButton));
        editButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                edit();
            }

        });
        add(editButton);

        deleteButton.setFocusable(false);
        deleteButton.setFont(Constants.BUTTON_FONT);
        deleteButton.setForeground(Constants.FORE_COLOR);
        deleteButton.setBackground(Constants.BACK_COLOR);
        deleteButton.setFocusable(false);
        deleteButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        deleteButton.setSize(180, 70);
        deleteButton.setLocation(490, 30);
        deleteButton.addMouseListener(new DeleteBookListener(deleteButton));
        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }

        });
        add(deleteButton);
    }

    private void displayTable() {
        final String[] columnNames = { "Book ID", "Title", "Author", "Genre", "Date Published", "Worth" };
        DefaultTableModel model = new DefaultTableModel();
        JTable bookTable = new JTable();

        bookTable.setFocusable(false);
        bookTable.getTableHeader().setResizingAllowed(false);
        bookTable.getTableHeader().setReorderingAllowed(false);
        bookTable.getTableHeader().setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        bookTable.getTableHeader().setBackground(new Color(0, 0, 0));
        bookTable.getTableHeader().setFont(new Font("Dialog", Font.PLAIN, 20));
        bookTable.setFont(new Font("Dialog", Font.PLAIN, 15));

        bookTable.setSize(1100, 530);
        bookTable.setLocation(35, 125);
        bookTable.setLayout(null);
        bookTable.setBackground(Constants.BACK_COLOR);
        bookTable.setShowGrid(true);
        bookTable.setEnabled(false);
        add(bookTable);

    }
}
