package gamePanels;

import javax.swing.*;
import characters.Player;
import java.awt.*;

public class SpendPointsPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel levelLabel;
    private JLabel xpLabel;
    private JLabel pointsLabel;
    private JLabel maxHealthLabel;

    private JLabel sepndPointsLabel;

    private Player player;

    public SpendPointsPanel (Font gameFont, Player player) {
        this.player = player;

        //--
        setLayout(null);
        setPreferredSize(new Dimension(600,600));
        setBackground(Color.black);

        //Components
        int startX = 20;
        int startY = 110;
        int width = 275;
        int height = 50;
        int spaceY = 5;
        
        nameLabel = new JLabel("name");
        nameLabel.setFont(gameFont.deriveFont(60f));
        nameLabel.setForeground(Color.white);
        nameLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        nameLabel.setBounds(startX, 30, 400, 70);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);

        levelLabel = new JLabel("level: 0");
        levelLabel.setFont(gameFont);
        levelLabel.setForeground(Color.white);
        levelLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        levelLabel.setBounds(nameLabel.getX() + nameLabel.getWidth() + spaceY, nameLabel.getY(), 160, 70);
        levelLabel.setHorizontalAlignment(JLabel.CENTER);
        
        xpLabel = new JLabel("xp: 0/0");
        xpLabel.setFont(gameFont);
        xpLabel.setForeground(Color.white);
        xpLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        xpLabel.setBounds(startX, startY, width, height);
        xpLabel.setHorizontalAlignment(JLabel.CENTER);

        pointsLabel = new JLabel("skill points: 0");
        pointsLabel.setFont(gameFont);
        pointsLabel.setForeground(Color.white);
        pointsLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        pointsLabel.setBounds(startX, startY + (height * 1) + (spaceY * 1), width, height);
        pointsLabel.setHorizontalAlignment(JLabel.CENTER);

        maxHealthLabel = new JLabel("max health: 0");
        maxHealthLabel.setFont(gameFont);
        maxHealthLabel.setForeground(Color.white);
        maxHealthLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        maxHealthLabel.setBounds(startX, startY + (height * 2) + (spaceY * 2), width, height);
        maxHealthLabel.setHorizontalAlignment(JLabel.CENTER);
        


        sepndPointsLabel = new JLabel("press (P) to spend points");
        sepndPointsLabel.setFont(gameFont.deriveFont(20f));
        sepndPointsLabel.setForeground(Color.white);
        sepndPointsLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        sepndPointsLabel.setBounds(300, 600 - (height + spaceY + 5), width, height);
        sepndPointsLabel.setHorizontalAlignment(JLabel.CENTER);
        

        //Add components
        add(nameLabel);
        add(levelLabel);
        add(xpLabel);
        add(pointsLabel);
        add(maxHealthLabel);

        add(sepndPointsLabel);

        updateLabels();
    }

    private void updateLabels () {

        nameLabel.setText(player.getName());
        levelLabel.setText("level: " + player.getLevel());
        xpLabel.setText("xp: " + player.getXp() + "/" + player.getXpToNextLvl());
        pointsLabel.setText("points: " + player.getPoints());
        maxHealthLabel.setText("max health : " + player.getMaxHealth());
    }

    public void updatePointsLabel () {
        pointsLabel.setText("points: " + player.getPoints());
    }

    public JLabel[] getAllLabels () {

        JLabel[] allLabels = new JLabel[1];

        allLabels[0] = maxHealthLabel;

        return allLabels;
    }

    public void setHpUpText () {
        maxHealthLabel.setText("max health : " + player.getMaxHealth() + " + " + (player.getMaxHpLvl() + 10));
    }

}
