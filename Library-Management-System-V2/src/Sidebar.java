import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import INITIAL.Constants;

public class Sidebar extends JPanel {

    Sidebar() {
        setLayout(null);
        setBackground(new Color(94, 104, 109));
        setSize(Constants.SIDE_DIMENSIONS[0], Constants.SIDE_DIMENSIONS[1]);
        setLocation(0, 0);
        displayButtons();
        setVisible(true);
    }

    public void displayButtons() {

        JLabel homeButton = new JLabel();
        homeButton.setSize(60, 60);
        homeButton.setLocation(20, 70);
        ImageIcon homeIcon = new ImageIcon("src/Icons/home.png");
        Image homeImage = homeIcon.getImage();
        Image homeScale = homeImage.getScaledInstance(homeButton.getWidth(), homeButton.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon scaledHome = new ImageIcon(homeScale);
        homeButton.setIcon(scaledHome);
        add(homeButton);

        JLabel searchButton = new JLabel();
        searchButton.setSize(60, 60);
        searchButton.setLocation(20, 170);
        ImageIcon searchIcon = new ImageIcon("src/Icons/search.png");
        Image searchImage = searchIcon.getImage();
        Image searchScale = searchImage.getScaledInstance(searchButton.getWidth(), searchButton.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon scaledSearch = new ImageIcon(searchScale);
        searchButton.setIcon(scaledSearch);
        add(searchButton);

        JLabel bookButton = new JLabel();
        bookButton.setSize(60, 60);
        bookButton.setLocation(20, 270);
        ImageIcon bookIcon = new ImageIcon("src/Icons/book.png");
        Image bookImage = bookIcon.getImage();
        Image bookScale = bookImage.getScaledInstance(bookButton.getWidth(), bookButton.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon scaledBook = new ImageIcon(bookScale);
        bookButton.setIcon(scaledBook);
        add(bookButton);

        JLabel borrowerButton = new JLabel();
        borrowerButton.setSize(60, 60);
        borrowerButton.setLocation(20, 370);
        ImageIcon borrowerIcon = new ImageIcon("src/Icons/borrower.png");
        Image borrowerImage = borrowerIcon.getImage();
        Image borrowerScale = borrowerImage.getScaledInstance(borrowerButton.getWidth(), borrowerButton.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon scaledBorrower = new ImageIcon(borrowerScale);
        borrowerButton.setIcon(scaledBorrower);
        add(borrowerButton);

        JLabel memberButton = new JLabel();
        memberButton.setSize(60, 60);
        memberButton.setLocation(20, 470);
        ImageIcon memberIcon = new ImageIcon("src/Icons/member.png");
        Image memberImage = memberIcon.getImage();
        Image memberScale = memberImage.getScaledInstance(memberButton.getWidth(), memberButton.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon scaledMember = new ImageIcon(memberScale);
        memberButton.setIcon(scaledMember);
        add(memberButton);

        JLabel staffButton = new JLabel();
        staffButton.setSize(60, 60);
        staffButton.setLocation(20, 570);
        ImageIcon staffIcon = new ImageIcon("src/Icons/staff.png");
        Image staffImage = staffIcon.getImage();
        Image staffScale = staffImage.getScaledInstance(staffButton.getWidth(), staffButton.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon scaledStaff = new ImageIcon(staffScale);
        staffButton.setIcon(scaledStaff);
        add(staffButton);

    }
}
