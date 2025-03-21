package Managements.MainPanel;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controls.ButtonListener.ButtonListener;
import DatabaseConnection.Connector;
import Functions.Functions;
import Initial.Constants;
import Managements.BorrowerPanel.*;

public class Borrower extends JPanel implements Functions {

    protected Connector connector = new Connector();

    protected JButton addBorrower = new JButton("ADD BORROWER");
    protected JButton editBorrower = new JButton("EDIT BORROWER");

    private final String[] columnNames = { "Borrower ID", "Borrower Name", "Title", "Start Date", "Due Date" };
    private DefaultTableModel model = new DefaultTableModel(dataTable(columnNames), columnNames);
    private JTable borrowerTable = new JTable(model);
    private JScrollPane tableScrollPane = new JScrollPane(borrowerTable);

    protected AddBorrowerPanel addBorrowerPanel = new AddBorrowerPanel(addBorrower, editBorrower, model, borrowerTable,
            tableScrollPane);
    protected EditBorrowerPanel editBorrowerPanel = new EditBorrowerPanel(addBorrower, editBorrower, model,
            borrowerTable, tableScrollPane);

    public Borrower() {
        setLayout(null);
        setBackground(Constants.MAIN_COLOR);
        setSize(Constants.MAIN_DIMENSIONS[0], Constants.MAIN_DIMENSIONS[1]);
        setLocation(100, 0);
        setVisible(false);

        add(addBorrowerPanel);
        add(editBorrowerPanel);

        displayLabel();
        displayButtons();
        displayTable();
    }

    @Override
    public void add() {
        addBorrowerPanel.setVisible(true);
        addBorrower.setEnabled(false);
        editBorrower.setEnabled(false);
    }

    @Override
    public void edit() {
        editBorrowerPanel.setVisible(true);
        addBorrower.setEnabled(false);
        editBorrower.setEnabled(false);
    }

    private void displayLabel() {
        JLabel bookSection = new JLabel("Borrower Section");
        bookSection.setSize(1280, 50);
        bookSection.setLocation(275, 35);
        bookSection.setHorizontalAlignment(SwingConstants.CENTER);
        bookSection.setFont(new Font("Dialog", Font.BOLD, 50));
        add(bookSection);
    }

    private void displayButtons() {
        addBorrower.setFocusable(false);
        addBorrower.setFont(Constants.MEM_BUTTON_FONT);
        addBorrower.setForeground(Constants.FORE_COLOR);
        addBorrower.setBackground(Constants.BACK_COLOR);
        addBorrower.setFocusable(false);
        addBorrower.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        addBorrower.setSize(180, 70);
        addBorrower.setLocation(70, 30);
        addBorrower.addMouseListener(new ButtonListener(addBorrower));
        addBorrower.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                add();
            }

        });
        add(addBorrower);

        editBorrower.setFocusable(false);
        editBorrower.setFont(Constants.MEM_BUTTON_FONT);
        editBorrower.setForeground(Constants.FORE_COLOR);
        editBorrower.setBackground(Constants.BACK_COLOR);
        editBorrower.setFocusable(false);
        editBorrower.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        editBorrower.setSize(180, 70);
        editBorrower.setLocation(280, 30);
        editBorrower.addMouseListener(new ButtonListener(editBorrower));
        editBorrower.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                edit();
            }

        });
        add(editBorrower);
    }

    private void displayTable() {
        borrowerTable.setFocusable(false);
        borrowerTable.getTableHeader().setResizingAllowed(false);
        borrowerTable.getTableHeader().setReorderingAllowed(false);
        borrowerTable.getTableHeader().setFocusable(false);
        borrowerTable.getTableHeader()
                .setBackground(new Color(245, 245, 245));
        borrowerTable.setFocusable(false);
        borrowerTable.getTableHeader()
                .setForeground(Color.BLACK);
        borrowerTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 20));
        borrowerTable.setFont(new Font("Dialog", Font.BOLD, 15));
        borrowerTable.setBackground(new Color(210, 210, 210));
        borrowerTable.setForeground(Color.BLACK);
        borrowerTable.setGridColor(new Color(62, 50, 50));
        borrowerTable.setShowGrid(true);
        borrowerTable.setCellSelectionEnabled(false);
        borrowerTable.setEnabled(false);
        borrowerTable.setRowHeight(40);
        borrowerTable.setLocation(40, 150);
        borrowerTable.setLayout(null);
        tableScrollPane.setBounds(35, 125, 1100, 530);
        tableScrollPane.getViewport()
                .setBackground(new Color(238, 238, 238));
        tableScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tableScrollPane);
    }

    private String[][] dataTable(String[] columnNames) {
        int rowCount = getNumData();
        int columnCount = columnNames.length;

        try {
            connector.statement = connector.connect().createStatement();
            connector.query = "SELECT * FROM borrower WHERE status = 'active';";
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
            connector.query = "SELECT COUNT(*) AS num_of_borrower FROM borrower WHERE status = 'active';";
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
