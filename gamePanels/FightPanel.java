package gamePanels;

import java.awt.*;
import javax.swing.*;

public class FightPanel extends JPanel {
    public JLabel playerNameLabel;
    public JProgressBar playerHpLabel;

    public FightPanel (Font gameFont) {
        //--
        setLayout(null);
        setPreferredSize(new Dimension(600,600));
        setBackground(Color.BLACK);

        //-- Components
        //skill labels
        int skillLabelWidth = 110;
        int skillLabelHeight = 90;
        int skillLabelsStartX = 80;
        int skillLabelsY = 450;

        JLabel skill1Label = new JLabel("");
        skill1Label.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        skill1Label.setBounds(skillLabelsStartX, skillLabelsY, skillLabelWidth, skillLabelHeight);

        JLabel skill2Label = new JLabel("");
        skill2Label.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        skill2Label.setBounds(skill1Label.getX()+skill1Label.getWidth(), skillLabelsY, skillLabelWidth, skillLabelHeight);

        JLabel skill3Label = new JLabel("");
        skill3Label.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        skill3Label.setBounds(skill2Label.getX()+skill2Label.getWidth(), skillLabelsY, skillLabelWidth, skillLabelHeight);

        JLabel skill4Label = new JLabel("");
        skill4Label.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        skill4Label.setBounds(skill3Label.getX()+skill3Label.getWidth(), skillLabelsY, skillLabelWidth, skillLabelHeight);

        //player
        playerHpLabel = new JProgressBar();
        playerHpLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        playerHpLabel.setBounds(140, 550, 250, 20);
        playerHpLabel.setMaximum(200);
        playerHpLabel.setValue(50);
        playerHpLabel.setForeground(Color.red);
        playerHpLabel.setBackground(Color.black);

        playerNameLabel = new JLabel();
        playerNameLabel.setForeground(Color.WHITE);
        playerNameLabel.setBounds(playerHpLabel.getX() + playerHpLabel.getWidth() + 10, playerHpLabel.getY(), 150 , playerHpLabel.getHeight());
        playerNameLabel.setFont(gameFont.deriveFont(20f));

        //monster 
        JLabel monsterLabel = new JLabel("Monster");
        monsterLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        monsterLabel.setBounds(155, 55, 290, 290);

        JLabel monsterHpLabel = new JLabel("mons hp");
        monsterHpLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        monsterHpLabel.setBounds(155, 25, 290, 15);

        JLabel monsterAction = new JLabel("mons action");
        monsterAction.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        monsterAction.setBounds(100, 350, 400, 80);
        monsterAction.setFont(gameFont.deriveFont(40f));
        monsterAction.setHorizontalAlignment(JLabel.CENTER);


        //-- Add components
        //skill labels
        add(skill1Label);
        add(skill2Label);
        add(skill3Label);
        add(skill4Label);

        //player stuff
        add(playerHpLabel);
        add(playerNameLabel);

        //monster stuff
        add(monsterLabel);
        add(monsterHpLabel);
        add(monsterAction);
    }

}
