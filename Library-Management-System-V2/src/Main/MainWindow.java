package Main;

import javax.swing.*;

import Initial.Constants;

public class MainWindow extends JFrame {

    Sidebar sidebar = new Sidebar(this);

    MainWindow() {
        super(Constants.TITLE);
        setLayout(null);
        setSize(Constants.WINDOW_DIMENSIONS[0], Constants.WINDOW_DIMENSIONS[1]);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        add(sidebar);
    }

}
