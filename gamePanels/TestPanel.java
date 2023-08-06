package gamePanels;

import java.awt.*;
import javax.swing.*;

public class TestPanel extends JPanel {

    public JLabel test;

    public TestPanel (Font gameFont) {
        //--
        setPreferredSize(new Dimension(600,600));
        setBackground(Color.BLACK);

        //Components
        test = new JLabel("asdads");
        test.setForeground(Color.white);
        test.setFont(gameFont);

        //Add components
        add(test);
    }

}
