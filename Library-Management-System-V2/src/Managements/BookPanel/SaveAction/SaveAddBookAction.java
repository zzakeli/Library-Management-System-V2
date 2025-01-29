package Managements.BookPanel.SaveAction;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import DatabaseConnection.Connector;

public class SaveAddBookAction implements ActionListener {
    Connector connector = new Connector();

    private JTextField titleField, authorField, datePublishedField, genreField, worthField;

    public SaveAddBookAction(JTextField titleField, JTextField authorField, JTextField datePublishedField,
            JTextField genreField, JTextField worthField) {
        this.titleField = titleField;
        this.authorField = authorField;
        this.datePublishedField = datePublishedField;
        this.genreField = genreField;
        this.worthField = worthField;
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
        int dateLength = 10;
        if (datePublishedField.getText().length() != dateLength || datePublishedField.getText().charAt(4) != '-'
                || datePublishedField.getText().charAt(7) != '-') {
            System.out.println("Date invalid format.");
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
                System.out.println("Date invalid format.");
                isValid = changeBorderRed(datePublishedField);
                break;
            }
        }
        if (Character.isDigit(datePublishedField.getText().charAt(5))
                && Character.isDigit(datePublishedField.getText().charAt(6))) {
            EndingDay endingDay = EndingDay.THIRTY_ONE;
            int month = Integer.parseInt(datePublishedField.getText().substring(5, 7));

            if (month < 1 || month > 12) {
                System.out.println("Month should be 1 to 12");
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
                        System.out.println("Invalid Day");
                        break;
                    }
                }

                if (day > endingDay.getDay() || day < 1) {
                    System.out.println("Invalid day.");
                    isValid = changeBorderRed(datePublishedField);
                }
            }
        }

        for (int i = 0; i < authorField.getText().length(); i++) {
            if (!Character.isAlphabetic(authorField.getText().charAt(i))) {
                System.out.println("Author should not contain numbers and periods.");
                isValid = changeBorderRed(authorField);
                break;
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
        title = title.stripLeading().stripTrailing().toLowerCase();
        title = String.join("", Character.toString(title.charAt(0)).toUpperCase(), title.substring(1, title.length()));

        author = author.stripLeading().stripTrailing().toLowerCase();
        author = String.join("", Character.toString(author.charAt(0)).toUpperCase(),
                author.substring(1, author.length()));

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
        System.out.println(titleSB.toString());

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
        System.out.println(authorSB.toString());
    }

    private enum EndingDay {
        TWENTY_EIGHT(28), THIRTY(30), THIRTY_ONE(31);

        private int dayNum;

        EndingDay(int dayNum) {
            this.dayNum = dayNum;
        }

        public int getDay() {
            return dayNum;
        }
    }

}
