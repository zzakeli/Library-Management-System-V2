package Managements.BorrowerPanel.SaveAction;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DatabaseConnection.Connector;

public class SaveAddBorrowerAction implements ActionListener {

    Connector connector = new Connector();

    private JTextField borrowerField;
    private JTextField bookField;
    private JTextField startDateField;
    private JTextField dueDateField;
    private JButton addButton;
    private JButton editButton;
    private DefaultTableModel model;
    private final String[] columnNames = { "Borrower ID", "Borrower Name", "Title", "Start Date", "Due Date" };
    private JTable borrowerTable;
    private JScrollPane tableScrollPane;
    private JPanel addBorrowerPanel;

    public SaveAddBorrowerAction(JTextField borrowerField, JTextField bookField, JTextField startDateField,
            JTextField dueDateField,
            JButton addButton, JButton editButton, DefaultTableModel model, JTable borrowerTable,
            JScrollPane tableScrollPane, JPanel addBorrowerPanel) {
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
        save();
    }

    private void save() {
        if (!hasValidFields()) {
            return;
        }

        String borrower = borrowerField.getText();
        String book = bookField.getText();
        String startDate = startDateField.getText();
        String dueDate = dueDateField.getText();

        saveBorrower(borrower, book, startDate, dueDate);
        addButton.setEnabled(true);
        editButton.setEnabled(true);
        tableScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        addBorrowerPanel.setVisible(false);

        refresh();
    }

    private void refresh() {
        model = new DefaultTableModel(dataTable(columnNames), columnNames);
        borrowerTable.setModel(model);
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

    private boolean hasValidFields() {
        setDefault();
        JTextField[] fields = { borrowerField, bookField, startDateField, dueDateField };
        JTextField[] dateFields = { this.startDateField, this.dueDateField };
        boolean isValid = true;

        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getText().isEmpty()) {
                isValid = changeBorderRed(fields[i]);
            }
        }

        final int dateLength = 10;
        for (int i = 0; i < dateFields.length; i++) {
            if (dateFields[i].getText().length() != dateLength || dateFields[i].getText().charAt(4) != '-'
                    || dateFields[i].getText().charAt(7) != '-') {
                isValid = changeBorderRed(dateFields[i]);

                StringBuilder dateBuilder = new StringBuilder();
                dateBuilder.setLength(0);
                dateFields[i].getText().trim();
                dateBuilder.append(dateFields[i].getText());
                for (int j = 0; j < dateFields[i].getText().length(); j++) {
                    dateBuilder.append(" ");
                }
                dateFields[i].setText(dateBuilder.toString());
            }

            for (int j = 0; j < dateFields[i].getText().length(); j++) {
                // 0-4,5-7,8-10
                if (j == 4 || j == 7)
                    continue;

                if (!Character.isDigit(dateFields[i].getText().charAt(j))) {
                    isValid = changeBorderRed(dateFields[i]);

                    break;
                }
            }
        }

        for (int i = 0; i < borrowerField.getText().length(); i++) {
            if (borrowerField.getText().charAt(i) == ' ')
                continue;
            if (!Character.isAlphabetic(borrowerField.getText().charAt(i))) {
                isValid = changeBorderRed(borrowerField);
                break;
            }
        }

        if (startDateField.getText().equals("")) {
            isValid = changeBorderRed(startDateField);
            return isValid;
        }
        if (dueDateField.getText().equals("")) {
            isValid = changeBorderRed(dueDateField);
            return isValid;
        }

        for (int i = 0; i < dateFields.length; i++) {
            if (Character.isDigit(dateFields[i].getText().charAt(5))
                    && Character.isDigit(dateFields[i].getText().charAt(6))) {
                EndingDay endingDay = EndingDay.THIRTY_ONE;
                int month = Integer.parseInt(dateFields[i].getText().substring(5, 7));

                if (month < 1 || month > 12) {
                    isValid = changeBorderRed(dateFields[i]);
                }

                if (Character.isDigit(dateFields[i].getText().charAt(8))
                        && Character.isDigit(dateFields[i].getText().charAt(9))) {
                    int day = Integer.parseInt(dateFields[i].getText().substring(8, 10));

                    switch (month) {
                        case 1, 3, 5, 7, 8, 10, 12 -> {
                            endingDay = EndingDay.THIRTY_ONE;
                            break;
                        }
                        case 4, 6, 9, 11 -> {
                            endingDay = EndingDay.THIRTY;
                            break;
                        }
                        case 2 -> {
                            endingDay = EndingDay.TWENTY_EIGHT;
                            break;
                        }
                        default -> {
                            isValid = changeBorderRed(dateFields[i]);
                            break;
                        }
                    }

                    if (day > endingDay.getDay() || day < 1) {
                        isValid = changeBorderRed(dateFields[i]);
                    }
                }
            }
        }

        return isValid;
    }

    private boolean changeBorderRed(JTextField field) {
        field.setBorder(BorderFactory.createLineBorder(Color.red, 3));
        return false;
    }

    private void setDefault() {
        borrowerField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        bookField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        startDateField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        dueDateField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    }

    private void saveBorrower(String borrower, String book, String startDate, String dueDate) {
        String borrowerID = getBorrowerID();
        String bookData = getBook(book);
        String borrowerData = getBorrower(borrower);
        String startDateData = getStartDate(startDate);
        String dueDateData = getDueDate(dueDate);

        try {
            connector.statement = connector.connect().createStatement();
            connector.query = "INSERT INTO borrower(borrower_id,borrower_name,book_title,start_date,due_date) VALUES('"
                    + borrowerID
                    + "','" + bookData + "','" + borrowerData + "','" + dueDateData + "','" + startDateData + "')";
            connector.statement.executeUpdate(connector.query);
            connector.statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private String getBorrowerID() {
        String bookID = null;
        StringBuilder createID = new StringBuilder("W");
        try {
            connector.statement = connector.connect().createStatement();
            connector.query = "SELECT COUNT(borrower_id) AS borrowerID FROM borrower;";
            connector.resultSet = connector.statement.executeQuery(connector.query);

            int bookNum = 0;
            while (connector.resultSet.next()) {
                bookNum = Integer.parseInt(connector.resultSet.getString("borrowerID").toString());
            }
            bookNum++;

            switch (Integer.toString(bookNum).length()) {
                case 1:
                    createID.append("000");
                    break;
                case 2:
                    createID.append("00");
                    break;
                case 3:
                    createID.append("0");
                    break;
                default:
                    break;
            }
            createID.append(Integer.toString(bookNum));
            bookID = createID.toString();

            connector.statement.close();
            connector.resultSet.close();

            return bookID;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getBook(String book) {
        book = book.stripLeading().stripTrailing().toLowerCase();
        book = String.join("", Character.toString(book.charAt(0)).toUpperCase(), book.substring(1, book.length()));

        StringBuilder titleSB = new StringBuilder();

        for (int i = 0; i < book.length(); i++) {
            if (book.charAt(i) == ' ' && book.charAt(i + 1) == ' ') {
                continue;
            }
            titleSB.append(book.charAt(i));
            if (i < book.length() - 1 && book.charAt(i) == ' ' && book.charAt(i + 1) != ' '
                    && Character.isLowerCase(book.charAt(i + 1))) {
                titleSB.append(Character.toUpperCase(book.charAt(i + 1)));
                i++;
            }
        }

        book = titleSB.toString();

        return book;
    }

    private String getBorrower(String borrower) {
        borrower = borrower.stripLeading().stripTrailing().toLowerCase();
        borrower = String.join("", Character.toString(borrower.charAt(0)).toUpperCase(),
                borrower.substring(1, borrower.length()));

        StringBuilder authorSB = new StringBuilder();

        for (int i = 0; i < borrower.length(); i++) {
            if (borrower.charAt(i) == ' ' && borrower.charAt(i + 1) == ' ') {
                continue;
            }
            authorSB.append(borrower.charAt(i));
            if (i < borrower.length() - 1 && borrower.charAt(i) == ' ' && borrower.charAt(i + 1) != ' '
                    && Character.isLowerCase(borrower.charAt(i + 1))) {
                authorSB.append(Character.toUpperCase(borrower.charAt(i + 1)));
                i++;
            }
        }

        borrower = authorSB.toString();

        return borrower;
    }

    private String getStartDate(String startDate) {
        startDate = startDate.trim();
        return startDate;
    }

    private String getDueDate(String dueDate) {
        dueDate = dueDate.trim();
        return dueDate;
    }

    private enum EndingDay {
        TWENTY_EIGHT(28), THIRTY(30), THIRTY_ONE(31);

        private int dayNum;

        private EndingDay(int dayNum) {
            this.dayNum = dayNum;
        }

        public int getDay() {
            return dayNum;
        }
    }

}
