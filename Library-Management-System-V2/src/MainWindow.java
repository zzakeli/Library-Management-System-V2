import java.awt.*;
import javax.swing.*;
import INITIAL.Constants;

public class MainWindow extends JFrame {

    Sidebar sidebar = new Sidebar();
    ShowPanel showPanel = new ShowPanel();

    MainWindow() {
        super(Constants.TITLE);
        setLayout(null);
        setSize(Constants.WINDOW_DIMENSIONS[0], Constants.WINDOW_DIMENSIONS[1]);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        add(sidebar);
        add(showPanel);
    }

}
