package Managements;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controls.BlockListener.*;
import INITIAL.Constants;

public class Home extends JPanel {

    public Home() {
        setLayout(null);
        setBackground(new Color(239, 243, 234));
        setSize(Constants.MAIN_DIMENSIONS[0], Constants.MAIN_DIMENSIONS[1]);
        setLocation(100, 20);
        setVisible(true);
        displayTitle();
        displayBlocks();
    }

    private void displayTitle() {
        JLabel title = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setLocation(-48, 30);
        title.setSize(1280, 50);
        title.setFont(new Font("Dialog", Font.BOLD, 50));
        add(title);
    }

    private void displayBlocks() {
        JPanel totalBook = new JPanel();
        totalBook.setLayout(null);
        totalBook.setLocation(80, 130);
        totalBook.setSize(300, 200);
        totalBook.setBackground(new Color(183, 183, 183));
        totalBook.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        totalBook.addMouseListener(new TBListener(totalBook));
        add(totalBook);

        JPanel availBook = new JPanel();
        availBook.setLayout(null);
        availBook.setLocation(440, 130);
        availBook.setSize(300, 200);
        availBook.setBackground(new Color(183, 183, 183));
        availBook.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        availBook.addMouseListener(new ABListener(availBook));
        add(availBook);

        JPanel totalPrice = new JPanel();
        totalPrice.setLayout(null);
        totalPrice.setLocation(800, 130);
        totalPrice.setSize(300, 200);
        totalPrice.setBackground(new Color(183, 183, 183));
        totalPrice.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        totalPrice.addMouseListener(new TPListener(totalPrice));
        add(totalPrice);

        JPanel numMember = new JPanel();
        numMember.setLayout(null);
        numMember.setLocation(80, 390);
        numMember.setSize(300, 200);
        numMember.setBackground(new Color(183, 183, 183));
        numMember.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        numMember.addMouseListener(new NMListener(numMember));
        add(numMember);

        JPanel numBorrower = new JPanel();
        numBorrower.setLayout(null);
        numBorrower.setLocation(440, 390);
        numBorrower.setSize(300, 200);
        numBorrower.setBackground(new Color(183, 183, 183));
        numBorrower.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        numBorrower.addMouseListener(new NBListener(numBorrower));
        add(numBorrower);

        JPanel numStaff = new JPanel();
        numStaff.setLayout(null);
        numStaff.setLocation(800, 390);
        numStaff.setSize(300, 200);
        numStaff.setBackground(new Color(183, 183, 183));
        numStaff.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        numStaff.addMouseListener(new NSListener(numStaff));
        add(numStaff);

        displayNumCount(totalBook, availBook, totalPrice, numMember, numBorrower, numStaff);
    }

    private void displayNumCount(JPanel totalBook, JPanel availBook, JPanel totalPrice, JPanel numMember,
            JPanel numBorrower, JPanel numStaff) {

        JLabel totalBookLabel = new JLabel("Total Books");
        totalBookLabel.setFont(new Font("Dialog", Font.BOLD, 30));
        totalBookLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totalBookLabel.setVerticalAlignment(SwingConstants.CENTER);
        totalBookLabel.setLocation(25, 40);
        totalBookLabel.setSize(250, 50);
        totalBook.add(totalBookLabel);

        JLabel availBookLabel = new JLabel("Available Books");
        availBookLabel.setFont(new Font("Dialog", Font.BOLD, 30));
        availBookLabel.setHorizontalAlignment(SwingConstants.CENTER);
        availBookLabel.setVerticalAlignment(SwingConstants.CENTER);
        availBookLabel.setLocation(25, 40);
        availBookLabel.setSize(250, 50);
        availBook.add(availBookLabel);

        JLabel totalPriceLabel = new JLabel("Total Price");
        totalPriceLabel.setFont(new Font("Dialog", Font.BOLD, 30));
        totalPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totalPriceLabel.setVerticalAlignment(SwingConstants.CENTER);
        totalPriceLabel.setLocation(25, 40);
        totalPriceLabel.setSize(250, 50);
        totalPrice.add(totalPriceLabel);

        JLabel numMemberLabel = new JLabel("Members");
        numMemberLabel.setFont(new Font("Dialog", Font.BOLD, 30));
        numMemberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numMemberLabel.setVerticalAlignment(SwingConstants.CENTER);
        numMemberLabel.setLocation(25, 40);
        numMemberLabel.setSize(250, 50);
        numMember.add(numMemberLabel);

        JLabel numBorrowerLabel = new JLabel("Borrowers");
        numBorrowerLabel.setFont(new Font("Dialog", Font.BOLD, 30));
        numBorrowerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numBorrowerLabel.setVerticalAlignment(SwingConstants.CENTER);
        numBorrowerLabel.setLocation(25, 40);
        numBorrowerLabel.setSize(250, 50);
        numBorrower.add(numBorrowerLabel);

        JLabel numStaffLabel = new JLabel("Staffs");
        numStaffLabel.setFont(new Font("Dialog", Font.BOLD, 30));
        numStaffLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numStaffLabel.setVerticalAlignment(SwingConstants.CENTER);
        numStaffLabel.setLocation(25, 40);
        numStaffLabel.setSize(250, 50);
        numStaff.add(numStaffLabel);

        JLabel totalBookCount = new JLabel("2890");
        totalBookCount.setFont(new Font("Dialog", Font.PLAIN, 50));
        totalBookCount.setHorizontalAlignment(SwingConstants.CENTER);
        totalBookCount.setVerticalAlignment(SwingConstants.CENTER);
        totalBookCount.setLocation(25, 90);
        totalBookCount.setSize(250, 50);
        totalBook.add(totalBookCount);

        JLabel availBookCount = new JLabel("2305");
        availBookCount.setFont(new Font("Dialog", Font.PLAIN, 50));
        availBookCount.setHorizontalAlignment(SwingConstants.CENTER);
        availBookCount.setVerticalAlignment(SwingConstants.CENTER);
        availBookCount.setLocation(25, 90);
        availBookCount.setSize(250, 50);
        availBook.add(availBookCount);

        JLabel totalPriceCount = new JLabel("$153,200");
        totalPriceCount.setFont(new Font("Dialog", Font.PLAIN, 50));
        totalPriceCount.setHorizontalAlignment(SwingConstants.CENTER);
        totalPriceCount.setVerticalAlignment(SwingConstants.CENTER);
        totalPriceCount.setLocation(25, 90);
        totalPriceCount.setSize(250, 50);
        totalPrice.add(totalPriceCount);

        JLabel numMemberCount = new JLabel("207");
        numMemberCount.setFont(new Font("Dialog", Font.PLAIN, 50));
        numMemberCount.setHorizontalAlignment(SwingConstants.CENTER);
        numMemberCount.setVerticalAlignment(SwingConstants.CENTER);
        numMemberCount.setLocation(25, 90);
        numMemberCount.setSize(250, 50);
        numMember.add(numMemberCount);

        JLabel numBorrowerCount = new JLabel("360");
        numBorrowerCount.setFont(new Font("Dialog", Font.PLAIN, 50));
        numBorrowerCount.setHorizontalAlignment(SwingConstants.CENTER);
        numBorrowerCount.setVerticalAlignment(SwingConstants.CENTER);
        numBorrowerCount.setLocation(25, 90);
        numBorrowerCount.setSize(250, 50);
        numBorrower.add(numBorrowerCount);

        JLabel numStaffCount = new JLabel("15");
        numStaffCount.setFont(new Font("Dialog", Font.PLAIN, 50));
        numStaffCount.setHorizontalAlignment(SwingConstants.CENTER);
        numStaffCount.setVerticalAlignment(SwingConstants.CENTER);
        numStaffCount.setLocation(25, 90);
        numStaffCount.setSize(250, 50);
        numStaff.add(numStaffCount);
    }

}
