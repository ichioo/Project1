package gamePanels;

import java.awt.*;
import javax.swing.*;

public class HomePanel extends JPanel {

    private JLabel enterFightLabel;
    private JLabel seeStatsLabel;
    private JLabel seeSkillsLabel;

    public HomePanel (Font gameFont) {
        //--
        setLayout(null);
        setPreferredSize(new Dimension(600,600));
        setBackground(Color.BLACK);

        //components
        int startLabX = 100;
        int startLabY = 150;
        int selectLabHeight = 150;
        int selectLabWidth = 200;

        enterFightLabel = new JLabel("enter fight");
        enterFightLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        enterFightLabel.setForeground(Color.white);
        enterFightLabel.setBounds(startLabX, startLabY, selectLabWidth, selectLabHeight);
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

        seeSkillsLabel = new JLabel("see skills");
        seeSkillsLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        seeSkillsLabel.setForeground(Color.white);
        seeSkillsLabel.setBounds(enterFightLabel.getX(), enterFightLabel.getY() + enterFightLabel.getHeight() + 10, selectLabWidth, selectLabHeight);
        seeSkillsLabel.setFont(gameFont.deriveFont(30f));
        seeSkillsLabel.setHorizontalAlignment(JLabel.CENTER);
        seeSkillsLabel.setOpaque(true);
        seeSkillsLabel.setBackground(Color.BLACK);

        //add components
        add(enterFightLabel);
        add(seeStatsLabel);
        add(seeSkillsLabel);
    }

    //gets
    public JLabel getEnterFightLabel () {
        return enterFightLabel;
    }
    public JLabel getSeeStatsLabel () {
        return seeStatsLabel;
    }
    public JLabel getSeeSkillsLabel () {
        return seeSkillsLabel;
    }
}
