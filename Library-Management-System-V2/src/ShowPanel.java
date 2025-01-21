import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import INITIAL.Constants;
// import Managements.Book;
// import Managements.Borrower;
// import Managements.Home;
// import Managements.Member;
// import Managements.Search;
// import Managements.Staff;

public class ShowPanel extends JPanel {

    // Home home = new Home();
    // Search search = new Search();
    // Book book = new Book();
    // Member member = new Member();
    // Borrower borrower = new Borrower();
    // Staff staff = new Staff();

    ShowPanel() {
        setBackground(new Color(100, 100, 96));
        setSize(Constants.MAIN_DIMENSIONS[0], Constants.MAIN_DIMENSIONS[1]);
        setLocation(100, 0);
        displayLabel();
        setVisible(true);

        // add(home);
        // add(search);
        // add(book);
        // add(member);
        // add(borrower);
        // add(staff);
    }

    public void displayLabel() {
        JLabel label = new JLabel("Starting Panel");
        label.setFont(new Font("Dialog", Font.PLAIN, 50));
        add(label);
    }
}
