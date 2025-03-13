package Managements.BorrowerPanel.SaveAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SaveAddBorrowerAction implements ActionListener {

    private JTextField borrowerField;
    private JTextField bookField;
    private JTextField startDateField;
    private JTextField dueDateField;
    private JButton addButton;
    private JButton editButton;
    private DefaultTableModel model;
    private JTable borrowerTable;
    private JScrollPane tableScrollPane;

    public SaveAddBorrowerAction(JTextField borrowerField, JTextField bookField, JTextField startDateField,
            JTextField dueDateField,
            JButton addButton, JButton editButton, DefaultTableModel model, JTable borrowerTable,
            JScrollPane tableScrollPane) {
        this.borrowerField = borrowerField;
        this.bookField = bookField;
        this.startDateField = startDateField;
        this.dueDateField = dueDateField;
        this.addButton = addButton;
        this.editButton = editButton;
        this.model = model;
        this.borrowerTable = borrowerTable;
        this.tableScrollPane = tableScrollPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
