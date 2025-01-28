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

}
