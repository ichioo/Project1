package gamePanels;

import java.awt.*;
import javax.swing.*;

public class HomePanel extends JPanel {

    private JLabel enterFightLabel;
    private JLabel seeStatsLabel;
    
    public HomePanel (Font gameFont) {
        //--
        setLayout(null);
        setPreferredSize(new Dimension(600,600));
        setBackground(Color.BLACK);

        //components
        int selectLabHeight = 150;
        int selectLabWidth = 200;

        enterFightLabel = new JLabel("enter fight");
        enterFightLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        enterFightLabel.setForeground(Color.white);
        enterFightLabel.setBounds(100, 200, selectLabWidth, selectLabHeight);
        enterFightLabel.setFont(gameFont.deriveFont(30f));
        enterFightLabel.setHorizontalAlignment(JLabel.CENTER);
        enterFightLabel.setOpaque(true);
        enterFightLabel.setBackground(Color.BLACK);

        seeStatsLabel = new JLabel("see stats");
        seeStatsLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        seeStatsLabel.setForeground(Color.white);
        seeStatsLabel.setBounds(enterFightLabel.getX() + selectLabWidth + 10, enterFightLabel.getY(), selectLabWidth, selectLabHeight);
        seeStatsLabel.setFont(gameFont.deriveFont(30f));
        seeStatsLabel.setHorizontalAlignment(JLabel.CENTER);
        seeStatsLabel.setOpaque(true);
        seeStatsLabel.setBackground(Color.BLACK);

        //add components
        add(enterFightLabel);
        add(seeStatsLabel);
    }

    //gets
    public JLabel getEnterFightLabel () {
        return enterFightLabel;
    }
    public JLabel getSeeStatsLabel () {
        return seeStatsLabel;
    }
}
