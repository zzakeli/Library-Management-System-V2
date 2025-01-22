package Managements;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controls.BlockListener.*;
import Initial.Constants;

public class Home extends JPanel {

    public Home() {
        setLayout(null);
        setBackground(Constants.MAIN_COLOR);
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
        totalBook.setBackground(Constants.BACK_COLOR);
        totalBook.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        totalBook.addMouseListener(new TBListener(totalBook));
        add(totalBook);

        JPanel availBook = new JPanel();
        availBook.setLayout(null);
        availBook.setLocation(440, 130);
        availBook.setSize(300, 200);
        availBook.setBackground(Constants.BACK_COLOR);
        availBook.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        availBook.addMouseListener(new ABListener(availBook));
        add(availBook);

        JPanel totalPrice = new JPanel();
        totalPrice.setLayout(null);
        totalPrice.setLocation(800, 130);
        totalPrice.setSize(300, 200);
        totalPrice.setBackground(Constants.BACK_COLOR);
        totalPrice.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        totalPrice.addMouseListener(new TPListener(totalPrice));
        add(totalPrice);

        JPanel numMember = new JPanel();
        numMember.setLayout(null);
        numMember.setLocation(80, 390);
        numMember.setSize(300, 200);
        numMember.setBackground(Constants.BACK_COLOR);
        numMember.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        numMember.addMouseListener(new NMListener(numMember));
        add(numMember);

        JPanel numBorrower = new JPanel();
        numBorrower.setLayout(null);
        numBorrower.setLocation(440, 390);
        numBorrower.setSize(300, 200);
        numBorrower.setBackground(Constants.BACK_COLOR);
        numBorrower.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        numBorrower.addMouseListener(new NBListener(numBorrower));
        add(numBorrower);

        JPanel numStaff = new JPanel();
        numStaff.setLayout(null);
        numStaff.setLocation(800, 390);
        numStaff.setSize(300, 200);
        numStaff.setBackground(Constants.BACK_COLOR);
        numStaff.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        numStaff.addMouseListener(new NSListener(numStaff));
        add(numStaff);

        displayNumCount(totalBook, availBook, totalPrice, numMember, numBorrower, numStaff);
    }

    private void displayNumCount(JPanel totalBook, JPanel availBook, JPanel totalPrice, JPanel numMember,
            JPanel numBorrower, JPanel numStaff) {

        JLabel totalBookLabel = new JLabel("Total Books");
        totalBookLabel.setFont(new Font("Dialog", Font.BOLD, Constants.FONT_SIZE_LABEL));
        totalBookLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totalBookLabel.setVerticalAlignment(SwingConstants.CENTER);
        totalBookLabel.setLocation(Constants.COUNT_POS[0], Constants.COUNT_POS[1]);
        totalBookLabel.setSize(Constants.BLOCK_SIZE[0], Constants.BLOCK_SIZE[1]);
        totalBook.add(totalBookLabel);

        JLabel availBookLabel = new JLabel("Available Books");
        availBookLabel.setFont(new Font("Dialog", Font.BOLD, Constants.FONT_SIZE_LABEL));
        availBookLabel.setHorizontalAlignment(SwingConstants.CENTER);
        availBookLabel.setVerticalAlignment(SwingConstants.CENTER);
        availBookLabel.setLocation(Constants.COUNT_POS[0], Constants.COUNT_POS[1]);
        availBookLabel.setSize(Constants.BLOCK_SIZE[0], Constants.BLOCK_SIZE[1]);
        availBook.add(availBookLabel);

        JLabel totalPriceLabel = new JLabel("Total Price");
        totalPriceLabel.setFont(new Font("Dialog", Font.BOLD, Constants.FONT_SIZE_LABEL));
        totalPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totalPriceLabel.setVerticalAlignment(SwingConstants.CENTER);
        totalPriceLabel.setLocation(Constants.COUNT_POS[0], Constants.COUNT_POS[1]);
        totalPriceLabel.setSize(Constants.BLOCK_SIZE[0], Constants.BLOCK_SIZE[1]);
        totalPrice.add(totalPriceLabel);

        JLabel numMemberLabel = new JLabel("Members");
        numMemberLabel.setFont(new Font("Dialog", Font.BOLD, Constants.FONT_SIZE_LABEL));
        numMemberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numMemberLabel.setVerticalAlignment(SwingConstants.CENTER);
        numMemberLabel.setLocation(Constants.COUNT_POS[0], Constants.COUNT_POS[1]);
        numMemberLabel.setSize(Constants.BLOCK_SIZE[0], Constants.BLOCK_SIZE[1]);
        numMember.add(numMemberLabel);

        JLabel numBorrowerLabel = new JLabel("Borrowers");
        numBorrowerLabel.setFont(new Font("Dialog", Font.BOLD, Constants.FONT_SIZE_LABEL));
        numBorrowerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numBorrowerLabel.setVerticalAlignment(SwingConstants.CENTER);
        numBorrowerLabel.setLocation(Constants.COUNT_POS[0], Constants.COUNT_POS[1]);
        numBorrowerLabel.setSize(Constants.BLOCK_SIZE[0], Constants.BLOCK_SIZE[1]);
        numBorrower.add(numBorrowerLabel);

        JLabel numStaffLabel = new JLabel("Staffs");
        numStaffLabel.setFont(new Font("Dialog", Font.BOLD, Constants.FONT_SIZE_LABEL));
        numStaffLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numStaffLabel.setVerticalAlignment(SwingConstants.CENTER);
        numStaffLabel.setLocation(Constants.COUNT_POS[0], Constants.COUNT_POS[1]);
        numStaffLabel.setSize(Constants.BLOCK_SIZE[0], Constants.BLOCK_SIZE[1]);
        numStaff.add(numStaffLabel);

        JLabel totalBookCount = new JLabel("2890");
        totalBookCount.setFont(new Font("Dialog", Font.PLAIN, Constants.FONT_SIZE_COUNT));
        totalBookCount.setHorizontalAlignment(SwingConstants.CENTER);
        totalBookCount.setVerticalAlignment(SwingConstants.CENTER);
        totalBookCount.setLocation(Constants.COUNT_POS[0], Constants.COUNT_POS[2]);
        totalBookCount.setSize(Constants.BLOCK_SIZE[0], Constants.BLOCK_SIZE[1]);
        totalBook.add(totalBookCount);

        JLabel availBookCount = new JLabel("2305");
        availBookCount.setFont(new Font("Dialog", Font.PLAIN, Constants.FONT_SIZE_COUNT));
        availBookCount.setHorizontalAlignment(SwingConstants.CENTER);
        availBookCount.setVerticalAlignment(SwingConstants.CENTER);
        availBookCount.setLocation(Constants.COUNT_POS[0], Constants.COUNT_POS[2]);
        availBookCount.setSize(Constants.BLOCK_SIZE[0], Constants.BLOCK_SIZE[1]);
        availBook.add(availBookCount);

        JLabel totalPriceCount = new JLabel("$153,200");
        totalPriceCount.setFont(new Font("Dialog", Font.PLAIN, Constants.FONT_SIZE_COUNT));
        totalPriceCount.setHorizontalAlignment(SwingConstants.CENTER);
        totalPriceCount.setVerticalAlignment(SwingConstants.CENTER);
        totalPriceCount.setLocation(Constants.COUNT_POS[0], Constants.COUNT_POS[2]);
        totalPriceCount.setSize(Constants.BLOCK_SIZE[0], Constants.BLOCK_SIZE[1]);
        totalPrice.add(totalPriceCount);

        JLabel numMemberCount = new JLabel("207");
        numMemberCount.setFont(new Font("Dialog", Font.PLAIN, Constants.FONT_SIZE_COUNT));
        numMemberCount.setHorizontalAlignment(SwingConstants.CENTER);
        numMemberCount.setVerticalAlignment(SwingConstants.CENTER);
        numMemberCount.setLocation(Constants.COUNT_POS[0], Constants.COUNT_POS[2]);
        numMemberCount.setSize(Constants.BLOCK_SIZE[0], Constants.BLOCK_SIZE[1]);
        numMember.add(numMemberCount);

        JLabel numBorrowerCount = new JLabel("360");
        numBorrowerCount.setFont(new Font("Dialog", Font.PLAIN, Constants.FONT_SIZE_COUNT));
        numBorrowerCount.setHorizontalAlignment(SwingConstants.CENTER);
        numBorrowerCount.setVerticalAlignment(SwingConstants.CENTER);
        numBorrowerCount.setLocation(Constants.COUNT_POS[0], Constants.COUNT_POS[2]);
        numBorrowerCount.setSize(Constants.BLOCK_SIZE[0], Constants.BLOCK_SIZE[1]);
        numBorrower.add(numBorrowerCount);

        JLabel numStaffCount = new JLabel("15");
        numStaffCount.setFont(new Font("Dialog", Font.PLAIN, Constants.FONT_SIZE_COUNT));
        numStaffCount.setHorizontalAlignment(SwingConstants.CENTER);
        numStaffCount.setVerticalAlignment(SwingConstants.CENTER);
        numStaffCount.setLocation(Constants.COUNT_POS[0], Constants.COUNT_POS[2]);
        numStaffCount.setSize(Constants.BLOCK_SIZE[0], Constants.BLOCK_SIZE[1]);
        numStaff.add(numStaffCount);
    }

}
