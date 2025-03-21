package Managements.BookPanel.SaveAction;

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

public class SaveAddBookAction implements ActionListener {
    Connector connector = new Connector();
    private JTextField titleField, authorField, datePublishedField, genreField, worthField;

    private JPanel addBookPanel;
    private JButton addButton;
    private JButton editButton;
    private JScrollPane scrollPane;

    private final String[] columnNames = { "Book ID", "Title", "Author", "Genre", "Date Published", "Worth" };
    private DefaultTableModel model;
    private JTable bookTable;

    public SaveAddBookAction(JTextField titleField, JTextField authorField, JTextField datePublishedField,
            JTextField genreField, JTextField worthField, JPanel addBookPanel, JButton addButton, JButton editButton,
            DefaultTableModel model, JTable bookTable, JScrollPane scrollPane) {
        this.titleField = titleField;
        this.authorField = authorField;
        this.datePublishedField = datePublishedField;
        this.genreField = genreField;
        this.worthField = worthField;
        this.addBookPanel = addBookPanel;
        this.addButton = addButton;
        this.editButton = editButton;
        this.model = model;
        this.bookTable = bookTable;
        this.scrollPane = scrollPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        save();
    }

    private void save() {
        if (!hasValidFields()) {
            return;
        }

        String title = titleField.getText();
        String author = authorField.getText();
        String date = datePublishedField.getText();
        String genre = genreField.getText();
        String worth = worthField.getText();

        saveBook(title, author, date, genre, worth);
        addButton.setEnabled(true);
        editButton.setEnabled(true);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        addBookPanel.setVisible(false);

        clearState();
        refresh();
    }

    private void refresh() {
        model = new DefaultTableModel(dataTable(columnNames), columnNames);
        bookTable.setModel(model);
    }

    private void clearState() {
        titleField.setText("");
        authorField.setText("");
        datePublishedField.setText("");
        genreField.setText("");
        worthField.setText("");
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

    private boolean hasValidFields() {
        setDefault();
        JTextField[] fields = { titleField, authorField, datePublishedField, genreField, worthField };
        boolean isValid = true;
        int pointCount = 0;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getText().isEmpty()) {
                isValid = changeBorderRed(fields[i]);
            }
        }
        for (int i = 0; i < worthField.getText().length(); i++) {
            if (worthField.getText().charAt(i) == '.') {
                pointCount++;
                if (pointCount > 1) {
                    isValid = changeBorderRed(worthField);
                    break;
                }
                continue;
            }
            if (!Character.isDigit(worthField.getText().charAt(i))) {
                isValid = changeBorderRed(worthField);
                break;
            }
        }
        final int dateLength = 10;
        if (datePublishedField.getText().length() != dateLength || datePublishedField.getText().charAt(4) != '-'
                || datePublishedField.getText().charAt(7) != '-') {
            isValid = changeBorderRed(datePublishedField);

            StringBuilder dateBuilder = new StringBuilder();
            dateBuilder.setLength(0);
            datePublishedField.getText().trim();
            dateBuilder.append(datePublishedField.getText());
            for (int i = 0; i < datePublishedField.getText().length(); i++) {
                dateBuilder.append(" ");
            }
            datePublishedField.setText(dateBuilder.toString());
        }

        for (int i = 0; i < datePublishedField.getText().length(); i++) {
            // 0-4,5-7,8-10
            if (i == 4 || i == 7)
                continue;

            if (!Character.isDigit(datePublishedField.getText().charAt(i))) {
                isValid = changeBorderRed(datePublishedField);
                break;
            }
        }

        for (int i = 0; i < authorField.getText().length(); i++) {
            if (authorField.getText().charAt(i) == ' ')
                continue;
            if (!Character.isAlphabetic(authorField.getText().charAt(i))) {
                isValid = changeBorderRed(authorField);
                break;
            }
        }

        if (datePublishedField.getText().equals("")) {
            isValid = changeBorderRed(datePublishedField);
            return isValid;
        }

        if (Character.isDigit(datePublishedField.getText().charAt(5))
                && Character.isDigit(datePublishedField.getText().charAt(6))) {
            EndingDay endingDay = EndingDay.THIRTY_ONE;
            int month = Integer.parseInt(datePublishedField.getText().substring(5, 7));

            if (month < 1 || month > 12) {
                isValid = changeBorderRed(datePublishedField);
            }

            if (Character.isDigit(datePublishedField.getText().charAt(8))
                    && Character.isDigit(datePublishedField.getText().charAt(9))) {
                int day = Integer.parseInt(datePublishedField.getText().substring(8, 10));

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
                        isValid = changeBorderRed(datePublishedField);
                        break;
                    }
                }

                if (day > endingDay.getDay() || day < 1) {
                    isValid = changeBorderRed(datePublishedField);
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
        titleField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        authorField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        datePublishedField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        genreField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        worthField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    }

    private void saveBook(String title, String author, String date, String genre, String worth) {
        String bookID = getBookID();
        String titleData = getTitle(title);
        String authorData = getAuthor(author);
        String dateData = getDate(date);
        String genreData = getGenre(genre);
        String worthData = getWorth(worth);

        try {
            connector.statement = connector.connect().createStatement();
            connector.query = "INSERT INTO book(book_id,title,author,genre,date_published,worth) VALUES('" + bookID
                    + "','" + titleData + "','" + authorData + "','" + genreData + "','" + dateData + "'," + worthData
                    + ")";
            connector.statement.executeUpdate(connector.query);
            connector.statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private String getBookID() {
        String bookID = null;
        StringBuilder createID = new StringBuilder("B");
        try {
            connector.statement = connector.connect().createStatement();
            connector.query = "SELECT COUNT(book_id) AS bookID FROM book;";
            connector.resultSet = connector.statement.executeQuery(connector.query);

            int bookNum = 0;
            while (connector.resultSet.next()) {
                bookNum = Integer.parseInt(connector.resultSet.getString("bookID").toString());
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

    private String getTitle(String title) {
        title = title.stripLeading().stripTrailing().toLowerCase();
        title = String.join("", Character.toString(title.charAt(0)).toUpperCase(), title.substring(1, title.length()));

        StringBuilder titleSB = new StringBuilder();

        for (int i = 0; i < title.length(); i++) {
            if (title.charAt(i) == ' ' && title.charAt(i + 1) == ' ') {
                continue;
            }
            titleSB.append(title.charAt(i));
            if (i < title.length() - 1 && title.charAt(i) == ' ' && title.charAt(i + 1) != ' '
                    && Character.isLowerCase(title.charAt(i + 1))) {
                titleSB.append(Character.toUpperCase(title.charAt(i + 1)));
                i++;
            }
        }

        title = titleSB.toString();

        return title;
    }

    private String getAuthor(String author) {
        author = author.stripLeading().stripTrailing().toLowerCase();
        author = String.join("", Character.toString(author.charAt(0)).toUpperCase(),
                author.substring(1, author.length()));

        StringBuilder authorSB = new StringBuilder();

        for (int i = 0; i < author.length(); i++) {
            if (author.charAt(i) == ' ' && author.charAt(i + 1) == ' ') {
                continue;
            }
            authorSB.append(author.charAt(i));
            if (i < author.length() - 1 && author.charAt(i) == ' ' && author.charAt(i + 1) != ' '
                    && Character.isLowerCase(author.charAt(i + 1))) {
                authorSB.append(Character.toUpperCase(author.charAt(i + 1)));
                i++;
            }
        }

        author = authorSB.toString();

        return author;
    }

    private String getDate(String date) {
        date = date.trim();
        return date;
    }

    private String getGenre(String genre) {
        return genre;
    }

    private String getWorth(String worth) {
        return worth;
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
