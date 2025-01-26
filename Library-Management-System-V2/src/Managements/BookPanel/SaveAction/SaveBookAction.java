package Managements.BookPanel.SaveAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import DatabaseConnection.Connector;

public class SaveBookAction implements ActionListener {
    Connector connector = new Connector();

    private JTextField titleField, authorField, datePublishedField, genreField, worthField;

    public SaveBookAction(JTextField titleField, JTextField authorField, JTextField datePublishedField,
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
        if (titleField.getText().isEmpty() || authorField.getText().isEmpty() || datePublishedField.getText().isEmpty()
                || genreField.getText().isEmpty() || worthField.getText().isEmpty()) {
            System.out.println("Fill out all of the blanks.");
            return;
        }

        String title = titleField.getText();
        String author = authorField.getText();
        String date = datePublishedField.getText();
        String genre = genreField.getText();
        String worth = worthField.getText();

        saveBook(title, author, date, genre, worth);
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
