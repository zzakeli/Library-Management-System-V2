package Managements;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controls.BorrowerButtonListener.*;
import Functions.Functions;
import Initial.Constants;
import Managements.BorrowerPanel.*;

public class Borrower extends JPanel implements Functions {

    protected JButton addBorrower = new JButton("ADD BORROWER");
    protected JButton editBorrower = new JButton("EDIT BORROWER");
    protected JButton deleteBorrower = new JButton("DELETE BORROWER");

    protected AddBorrowerPanel addBorrowerPanel = new AddBorrowerPanel(addBorrower, editBorrower, deleteBorrower);
    protected EditBorrowerPanel editBorrowerPanel = new EditBorrowerPanel(addBorrower, editBorrower, deleteBorrower);
    protected DeleteBorrowerPanel deleteBorrowerPanel = new DeleteBorrowerPanel(addBorrower, editBorrower,
            deleteBorrower);

    public Borrower() {
        setLayout(null);
        setBackground(Constants.MAIN_COLOR);
        setSize(Constants.MAIN_DIMENSIONS[0], Constants.MAIN_DIMENSIONS[1]);
        setLocation(100, 0);
        setVisible(false);

        add(addBorrowerPanel);
        add(editBorrowerPanel);
        add(deleteBorrowerPanel);

        displayLabel();
        displayButtons();
        displayTable();
    }

    @Override
    public void add() {
        addBorrowerPanel.setVisible(true);
        addBorrower.setEnabled(false);
        editBorrower.setEnabled(false);
        deleteBorrower.setEnabled(false);
    }

    @Override
    public void edit() {
        editBorrowerPanel.setVisible(true);
        addBorrower.setEnabled(false);
        editBorrower.setEnabled(false);
        deleteBorrower.setEnabled(false);
    }

    @Override
    public void delete() {
        deleteBorrowerPanel.setVisible(true);
        addBorrower.setEnabled(false);
        editBorrower.setEnabled(false);
        deleteBorrower.setEnabled(false);
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
        addBorrower.addMouseListener(new AddBorrowerListener(addBorrower));
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
        editBorrower.addMouseListener(new EditBorrowerListener(editBorrower));
        editBorrower.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                edit();
            }

        });
        add(editBorrower);

        deleteBorrower.setFocusable(false);
        deleteBorrower.setFont(Constants.MEM_BUTTON_FONT);
        deleteBorrower.setForeground(Constants.FORE_COLOR);
        deleteBorrower.setBackground(Constants.BACK_COLOR);
        deleteBorrower.setFocusable(false);
        deleteBorrower.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        deleteBorrower.setSize(180, 70);
        deleteBorrower.setLocation(490, 30);
        deleteBorrower.addMouseListener(new DeleteBorrowerListener(deleteBorrower));
        deleteBorrower.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }

        });
        add(deleteBorrower);
    }

    private void displayTable() {
        // final String[] columnNames = { "Borrower ID", "Title", "Author", "Genre",
        // "Date Published", "Worth" };
        // DefaultTableModel model = new DefaultTableModel();
        JTable borrowerTable = new JTable();

        borrowerTable.setFocusable(false);
        borrowerTable.getTableHeader().setResizingAllowed(false);
        borrowerTable.getTableHeader().setReorderingAllowed(false);
        borrowerTable.getTableHeader().setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        borrowerTable.getTableHeader().setBackground(new Color(0, 0, 0));
        borrowerTable.getTableHeader().setFont(new Font("Dialog", Font.PLAIN, 20));
        borrowerTable.setFont(new Font("Dialog", Font.PLAIN, 15));

        borrowerTable.setSize(1100, 530);
        borrowerTable.setLocation(35, 125);
        borrowerTable.setLayout(null);
        borrowerTable.setBackground(Constants.BACK_COLOR);
        borrowerTable.setShowGrid(true);
        borrowerTable.setEnabled(false);
        add(borrowerTable);

    }
}
