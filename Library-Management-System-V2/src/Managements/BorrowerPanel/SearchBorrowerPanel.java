package Managements.BorrowerPanel;

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

import DatabaseConnection.Connector;
import Initial.Constants;

public class SearchBorrowerPanel extends JPanel {
    private Connector connector = new Connector();

    private EditBorrowerPanel editBorrowerPanel;
    private JButton addButton, editButton;
    private JScrollPane tableScrollPane;

    public SearchBorrowerPanel(EditBorrowerPanel editBorrowerPanel, JButton addButton, JButton editButton,
            JScrollPane tableScrollPane) {
        this.editBorrowerPanel = editBorrowerPanel;
        this.tableScrollPane = tableScrollPane;
        setBorder(BorderFactory.createLineBorder(Color.black, 3));
        setLayout(null);
        setSize(300, 200);
        setBackground(Constants.BACK_COLOR);
        setLocation(420, 240);
        setVisible(false);
        initComps();
        initButtons(addButton, editButton);
    }

    private void initButtons(JButton addButton, JButton editButton) {
        this.addButton = addButton;
        this.editButton = editButton;
    }

    private void enableButtons(boolean isEnabled) {
        addButton.setEnabled(isEnabled);
        editButton.setEnabled(isEnabled);
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
                    // editBorrowerPanel.borrowerID.setText(searchField.getText());
                    searchField.setText("");
                    setVisible(false);
                    enableButtons(false);
                    editBorrowerPanel.setVisible(true);
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
            connector.query = "SELECT borrower_id AS 'borrower id', borrower_name AS 'borrower', book_title AS 'book', start_date AS 'start', due_date AS 'due' FROM borrower;";
            connector.resultSet = connector.statement.executeQuery(connector.query);

            while (connector.resultSet.next()) {
                if (connector.resultSet.getString("borrower id").toString().equals(searchField.getText())) {
                    System.out.println("Account Exists.");

                    // editBorrowerPanel.borrowerField.setText(connector.resultSet.getString("borrower").toString());
                    // editBorrowerPanel.bookField.setText(connector.resultSet.getString("book").toString());
                    // editBorrowerPanel.startDateField.setText(connector.resultSet.getString("start").toString());
                    // editBorrowerPanel.dueDateField.setText(connector.resultSet.getString("due").toString());

                    if (connector.resultSet.getString("status").toString().equals("active")) {
                        // editBorrowerPanel.activeButton.setBackground(Color.GREEN);
                        // editBorrowerPanel.activeButton.setText("Active");
                    } else {
                        // editBorrowerPanel.activeButton.setBackground(Color.RED);
                        // editBorrowerPanel.activeButton.setText("Inactive");
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
