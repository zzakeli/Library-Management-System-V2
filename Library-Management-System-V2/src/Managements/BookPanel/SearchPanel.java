package Managements.BookPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Initial.Constants;

import DatabaseConnection.Connector;

public class SearchPanel extends JPanel {

    private Connector connector = new Connector();

    private EditBookPanel editBookPanel;
    private JButton addButton, editButton, deleteButton;
    private JScrollPane tableScrollPane;

    public SearchPanel(EditBookPanel editBookPanel, JButton addButton, JButton editButton, JButton deleteButton,
            JScrollPane tableScrollPane) {
        this.editBookPanel = editBookPanel;
        this.tableScrollPane = tableScrollPane;
        setBorder(BorderFactory.createLineBorder(Color.black, 3));
        setLayout(null);
        setSize(300, 200);
        setBackground(Constants.BACK_COLOR);
        setLocation(420, 240);
        setVisible(false);
        initComps();
        initButtons(addButton, editButton, deleteButton);
    }

    private void initButtons(JButton addButton, JButton editButton, JButton deleteButton) {
        this.addButton = addButton;
        this.editButton = editButton;
        this.deleteButton = deleteButton;
    }

    private void enableButtons(boolean isEnabled) {
        addButton.setEnabled(isEnabled);
        editButton.setEnabled(isEnabled);
        deleteButton.setEnabled(isEnabled);
    }

    private void initComps() {
        JTextField searchField = new JTextField();
        searchField.setSize(200, 40);
        searchField.setLocation(50, 50);
        searchField.setFont(new Font("Dialog", Font.BOLD, 20));
        searchField.setBorder(BorderFactory.createLineBorder(Color.black, 3));

        JButton searchButton = new JButton("Search");
        searchButton.setSize(100, 40);
        searchButton.setLocation(100, 120);
        searchButton.setFocusable(false);
        searchButton.setFont(new Font("Dialog", Font.BOLD, 15));
        searchButton.setForeground(Constants.FORE_COLOR);
        searchButton.setBackground(Constants.MAIN_COLOR);
        searchButton.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (accountExist(searchField)) {
                    // Run code here that showss the main Edit Panel
                    editBookPanel.bookID.setText(searchField.getText());
                    searchField.setText("");
                    setVisible(false);
                    enableButtons(true);
                    editBookPanel.setVisible(true);
                    return;
                }
                System.out.println("account does not exist.");
            }

        });

        JLabel closeButton = new JLabel();
        closeButton.setSize(Constants.CLOSE_SIZE, Constants.CLOSE_SIZE);
        closeButton.setLocation(260, 10);
        ImageIcon closeIcon = new ImageIcon("Library-Management-System-V2/src/Icons/close.png");
        Image closeImage = closeIcon.getImage();
        Image closeScale = closeImage.getScaledInstance(closeButton.getWidth(), closeButton.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon scaledClose = new ImageIcon(closeScale);
        closeButton.setIcon(scaledClose);
        closeButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                addButton.setEnabled(true);
                editButton.setEnabled(true);
                deleteButton.setEnabled(true);
                tableScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                searchField.setText("");

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        add(closeButton);
        add(searchButton);
        add(searchField);
    }

    private boolean accountExist(JTextField searchField) {
        try {
            connector.statement = connector.connect().createStatement();
            connector.query = "SELECT book_id AS 'book id', title, author, genre, date_published AS 'date published', worth, status FROM book;";
            connector.resultSet = connector.statement.executeQuery(connector.query);

            while (connector.resultSet.next()) {
                if (connector.resultSet.getString("book id").toString().equals(searchField.getText())) {
                    System.out.println("Account Exists.");

                    editBookPanel.titleField.setText(connector.resultSet.getString("title").toString());
                    editBookPanel.authorField.setText(connector.resultSet.getString("author").toString());
                    editBookPanel.genreField.setText(connector.resultSet.getString("genre").toString());
                    editBookPanel.datePublishedField
                            .setText(connector.resultSet.getString("date published").toString());
                    editBookPanel.worthField.setText(connector.resultSet.getString("worth").toString());

                    if (connector.resultSet.getString("status").toString().equals("active")) {
                        editBookPanel.activeButton.setBackground(Color.GREEN);
                        editBookPanel.activeButton.setText("Active");
                    } else {
                        editBookPanel.activeButton.setBackground(Color.RED);
                        editBookPanel.activeButton.setText("Inactive");
                    }
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("program error.");
        }
        return false;
    }
}
