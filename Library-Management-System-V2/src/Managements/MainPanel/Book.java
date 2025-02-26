package Managements.MainPanel;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controls.ButtonListener.ButtonListener;
import Functions.Functions;
import Initial.Constants;
import Managements.BookPanel.*;
import DatabaseConnection.*;

public class Book extends JPanel implements Functions {

    protected Connector connector = new Connector();

    private JButton addButton = new JButton("ADD BOOK");
    private JButton editButton = new JButton("EDIT BOOK");
    private JButton deleteButton = new JButton("DELETE BOOK");

    private final String[] columnNames = { "Book ID", "Title", "Author", "Genre", "Date Published", "Worth" };
    private DefaultTableModel model = new DefaultTableModel(dataTable(columnNames), columnNames);
    private JTable bookTable = new JTable(model);
    private JScrollPane scrollPane = new JScrollPane(bookTable);

    protected AddBookPanel addBookPanel = new AddBookPanel(addButton, editButton, deleteButton, model, bookTable,
            scrollPane);
    protected EditBookPanel editBookPanel = new EditBookPanel(addButton, editButton, deleteButton, model, bookTable,
            scrollPane);
    protected SearchPanel searchPanel = new SearchPanel(editBookPanel, addButton, editButton, deleteButton, scrollPane);
    protected DeleteBookPanel deleteBookPanel = new DeleteBookPanel(addButton, editButton, deleteButton);

    public Book() {
        setLayout(null);
        setBackground(Constants.MAIN_COLOR);
        setSize(Constants.MAIN_DIMENSIONS[0], Constants.MAIN_DIMENSIONS[1]);
        setLocation(100, 0);
        setVisible(false);

        add(addBookPanel);
        add(searchPanel);
        add(deleteBookPanel);

        displayLabel();
        displayButtons();
        displayTable();
    }

    @Override
    public void add() {
        addBookPanel.setVisible(true);
        setButtonEnabled(false);
    }

    @Override
    public void edit() {
        searchPanel.setVisible(true);
        setButtonEnabled(false);
    }

    @Override
    public void delete() {
        deleteBookPanel.setVisible(true);
        setButtonEnabled(false);
    }

    private void setButtonEnabled(boolean isEnabled) {
        addButton.setEnabled(isEnabled);
        editButton.setEnabled(isEnabled);
        deleteButton.setEnabled(isEnabled);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    }

    private void displayLabel() {
        JLabel bookSection = new JLabel("Book Section");
        bookSection.setSize(1280, 50);
        bookSection.setLocation(270, 35);
        bookSection.setHorizontalAlignment(SwingConstants.CENTER);
        bookSection.setFont(new Font("Dialog", Font.BOLD, 50));
        add(bookSection);
    }

    private void displayButtons() {
        addButton.setFocusable(false);
        addButton.setFont(Constants.BUTTON_FONT);
        addButton.setForeground(Constants.FORE_COLOR);
        addButton.setBackground(Constants.BACK_COLOR);
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

    private void displayTable() {
        bookTable.setFocusable(false);
        bookTable.getTableHeader().setResizingAllowed(false);
        bookTable.getTableHeader().setReorderingAllowed(false);
        bookTable.getTableHeader().setFocusable(false);
        bookTable.getTableHeader()
                .setBackground(new Color(245, 245, 245));
        bookTable.setFocusable(false);
        bookTable.getTableHeader()
                .setForeground(Color.BLACK);
        bookTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 20));
        bookTable.setFont(new Font("Dialog", Font.BOLD, 15));
        bookTable.setBackground(new Color(210, 210, 210));
        bookTable.setForeground(Color.BLACK);
        bookTable.setGridColor(new Color(62, 50, 50));
        bookTable.setShowGrid(true);
        bookTable.setCellSelectionEnabled(false);
        bookTable.setEnabled(false);
        bookTable.setRowHeight(40);
        bookTable.setLocation(40, 150);
        bookTable.setLayout(null);
        scrollPane.setBounds(35, 125, 1100, 530);
        scrollPane.getViewport()
                .setBackground(new Color(238, 238, 238));
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(scrollPane);
    }

    private String[][] dataTable(String[] columnNames) {
        int rowCount = getNumData();
        int columnCount = columnNames.length;

        try {
            connector.statement = connector.connect().createStatement();
            connector.query = "SELECT * FROM book WHERE status = 'active';";
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
            connector.statement.close();

            return data;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected int getNumData() {
        try {
            connector.statement = connector.connect().createStatement();
            connector.query = "SELECT COUNT(*) AS num_of_book FROM book WHERE status = 'active';";
            connector.resultSet = connector.statement.executeQuery(connector.query);

            int numData = 0;
            while (connector.resultSet.next()) {
                numData = Integer.parseInt(connector.resultSet.getString(1));
            }

            connector.resultSet.close();
            connector.statement.close();

            return numData;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
