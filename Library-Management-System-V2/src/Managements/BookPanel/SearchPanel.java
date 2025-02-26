package Managements.BookPanel;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Initial.Constants;

public class SearchPanel extends JPanel {

    private EditBookPanel editBookPanel;
    private JButton addButton, editButton, deleteButton;
    private JScrollPane tableScrollPane;

    public SearchPanel(EditBookPanel editBookPanel, JButton addButton, JButton editButton, JButton deleteButton,
            JScrollPane tableScrollPane) {
        this.editBookPanel = editBookPanel;
        this.tableScrollPane = tableScrollPane;

        setLayout(null);
        setSize(300, 200);
        setBackground(Constants.BACK_COLOR);
        setLocation(320, 110);
        setVisible(false);
        initComps();
        initButtons(addButton, editButton, deleteButton);
    }

    private void initButtons(JButton addButton, JButton editButton, JButton deleteButton) {
        this.addButton = addButton;
        this.editButton = editButton;
        this.deleteButton = deleteButton;
    }

    private void initComps() {
        JTextField searchField = new JTextField();
        searchField.setSize(150, 50);
        searchField.setLocation(0, 0);

        JButton searchButton = new JButton("Search");
        searchButton.setSize(100, 50);
        searchButton.setLocation(0, 50);
        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (accountExist()) {
                    // Run code here that shows the main Edit Panel
                    setVisible(false);
                    editBookPanel.setVisible(true);
                    return;
                }
                System.out.println("account does not exist.");
            }

        });

        JLabel closeButton = new JLabel();
        closeButton.setSize(Constants.CLOSE_SIZE, Constants.CLOSE_SIZE);
        closeButton.setLocation(200, 15);
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

    private boolean accountExist() {
        // Database manipulation code here

        return false;
    }
}
