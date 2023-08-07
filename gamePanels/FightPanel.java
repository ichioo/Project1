package gamePanels;

import java.awt.*;
import javax.swing.*;

import characters.*;
import skills.Skill;
import skills.TestSkill;

public class FightPanel extends JPanel {

    //characters
    Player player;
    Enemy enemy;

    //player
    JLabel playerNameLabel;
    JProgressBar playerHpBar;

    //enemy
    JLabel enemyNameLabel;
    JProgressBar enemyHpBar;

    public FightPanel (Font gameFont) {

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
        playerHpBar = new JProgressBar();
        playerHpBar.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        playerHpBar.setBounds(140, 550, 250, 20);
        playerHpBar.setForeground(Color.red);
        playerHpBar.setBackground(Color.black);

        playerNameLabel = new JLabel();
        playerNameLabel.setForeground(Color.WHITE);
        playerNameLabel.setBounds(playerHpBar.getX() + playerHpBar.getWidth() + 10, playerHpBar.getY(), 150 , playerHpBar.getHeight());
        playerNameLabel.setFont(gameFont.deriveFont(20f));

        //enemy 
        JLabel enemyImageLabel = new JLabel("enemy");
        enemyImageLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        enemyImageLabel.setBounds(155, 55, 290, 290);

        enemyHpBar = new JProgressBar();
        enemyHpBar.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        enemyHpBar.setBounds(140, 25, 250, 15);
        enemyHpBar.setForeground(Color.red);
        enemyHpBar.setBackground(Color.black);

        enemyNameLabel = new JLabel("enemy name");
        enemyNameLabel.setForeground(Color.WHITE);
        enemyNameLabel.setBounds(enemyHpBar.getX() + enemyHpBar.getWidth() + 10, enemyHpBar.getY(),150 , enemyHpBar.getHeight());
        enemyNameLabel.setFont(gameFont.deriveFont(20f));

        JLabel enemyAction = new JLabel("mons action");
        enemyAction.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        enemyAction.setBounds(100, 350, 400, 80);
        enemyAction.setFont(gameFont.deriveFont(40f));
        enemyAction.setHorizontalAlignment(JLabel.CENTER);


        //-- Add components
        //skill labels
        add(skill1Label);
        add(skill2Label);
        add(skill3Label);
        add(skill4Label);

        //player stuff
        add(playerHpBar);
        add(playerNameLabel);

        //enemy stuff
        add(enemyImageLabel);
        add(enemyHpBar);
        add(enemyNameLabel);
        add(enemyAction);
    }

    public void setCharacters (Player player, Enemy enemy) {
        
        this.player = player;
        this.enemy = enemy;

        //player hp bar
        playerHpBar.setMaximum(player.maxHealth);
        playerHpBar.setValue(player.health);
        //player
        playerNameLabel.setText(player.name);

        //enemy hp bar
        enemyHpBar.setMaximum(enemy.getMaxHealth());
        enemyHpBar.setValue(enemy.getHealth());
        //enemy
        enemyNameLabel.setText(enemy.getName());
        
    }

}
