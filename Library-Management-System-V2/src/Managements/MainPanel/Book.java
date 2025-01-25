package Managements.MainPanel;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;

import Controls.ButtonListener.ButtonListener;
import Functions.Functions;
import Initial.Constants;
import Managements.BookPanel.*;
import DatabaseConnection.*;

public class Book extends JPanel implements Functions {

    protected Connector connector = new Connector();

    protected JButton addButton = new JButton("ADD BOOK");
    protected JButton editButton = new JButton("EDIT BOOK");
    protected JButton deleteButton = new JButton("DELETE BOOK");

    protected AddBookPanel addBookPanel = new AddBookPanel(addButton, editButton, deleteButton);
    protected EditBookPanel editBookPanel = new EditBookPanel(addButton, editButton, deleteButton);
    protected DeleteBookPanel deleteBookPanel = new DeleteBookPanel(addButton, editButton, deleteButton);

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

    private void displayButtons() {
        addButton.setFocusable(false);
        addButton.setFont(Constants.BUTTON_FONT);
        addButton.setForeground(Constants.FORE_COLOR);
        addButton.setBackground(Constants.BACK_COLOR);
        addButton.setFocusable(false);
        addButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        addButton.setSize(180, 70);
        addButton.setLocation(70, 30);
        addButton.addMouseListener(new ButtonListener(addButton));
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
        editButton.addMouseListener(new ButtonListener(editButton));
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
        deleteButton.addMouseListener(new ButtonListener(deleteButton));
        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }

        });
        add(deleteButton);
    }

    protected final String[] columnNames = { "Book ID", "Title", "Author", "Genre", "Date Published", "Worth" };
    protected DefaultTableModel model = new DefaultTableModel(dataTable(columnNames), columnNames);

    private void displayTable() {

        JTable bookTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        bookTable.setFocusable(false);

        bookTable.getTableHeader().setResizingAllowed(false);
        bookTable.getTableHeader().setReorderingAllowed(false);
        bookTable.getTableHeader().setBorder(BorderFactory.createLineBorder(
                new Color(62, 50, 50)));
        bookTable.getTableHeader()
                .setBackground(new Color(126, 99, 99));
        bookTable.getTableHeader()
                .setForeground(new Color(228, 224, 225));
        bookTable.getTableHeader().setFont(new Font("Dialog", Font.PLAIN, 20));
        bookTable.setFont(new Font("Dialog", Font.PLAIN, 15));
        bookTable.setBackground(new Color(146, 119, 119));
        bookTable.setForeground(new Color(228, 224, 225));
        bookTable.setGridColor(new Color(62, 50, 50));
        bookTable.setShowGrid(true);
        bookTable.setCellSelectionEnabled(false);
        bookTable.setEnabled(false);
        bookTable.setRowHeight(40);
        bookTable.setSize(1100, 540);
        bookTable.setLocation(40, 150);
        bookTable.setLayout(null);
        scrollPane.setBounds(40, 150, 1100, 540);
        scrollPane.getViewport()
                .setBackground(new Color(186, 159, 159));
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        add(scrollPane);
    }

    private String[][] dataTable(String[] columnNames) {
        int rowCount = getNumData();
        int columnCount = columnNames.length;

        try {
            connector.statement = connector.connect().createStatement();
            connector.query = "SELECT * FROM book;";
            connector.resultSet = connector.statement.executeQuery(connector.query);

            String[][] data = new String[rowCount][columnCount];
            int i = 0;
            while (connector.resultSet.next()) {
                for (int j = 0; j < columnNames.length; j++) {
                    data[i][j] = connector.resultSet.getString(j + 1).toString();
                }
                i++;
            }

            connector.resultSet.close();

            return data;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected int getNumData() {
        try {
            connector.statement = connector.connect().createStatement();
            connector.query = "SELECT COUNT(*) AS num_of_book FROM book;";
            connector.resultSet = connector.statement.executeQuery(connector.query);

            int numData = 0;
            while (connector.resultSet.next()) {
                numData = Integer.parseInt(connector.resultSet.getString(1));
            }

            connector.resultSet.close();
            return numData;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
