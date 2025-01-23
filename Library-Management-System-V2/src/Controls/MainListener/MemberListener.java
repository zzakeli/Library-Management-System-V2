package Controls.MainListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Managements.MainPanel.*;

public class MemberListener implements MouseListener {

    Home home;
    Search search;
    Book book;
    Borrower borrower;
    Member member;
    Staff staff;

    public MemberListener(Home home, Search search, Book book, Borrower borrower, Member member, Staff staff) {
        this.home = home;
        this.search = search;
        this.book = book;
        this.borrower = borrower;
        this.member = member;
        this.staff = staff;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        home.setVisible(false);
        search.setVisible(false);
        book.setVisible(false);
        borrower.setVisible(false);
        member.setVisible(true);
        staff.setVisible(false);
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

}
