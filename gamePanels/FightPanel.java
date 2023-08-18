package gamePanels;

import java.awt.*;
import javax.swing.*;
import characters.*;
import skills.Skill;

public class FightPanel extends JPanel{

    //characters
    private Player player;
    private Enemy enemy;

    //player
    private JLabel playerNameLabel;
    private JProgressBar playerHpBar;
    private JLabel playerActionLabel;

    private JLabel skill1Label;
    private JLabel skill2Label;
    private JLabel skill3Label;
    private JLabel skill4Label;

    //enemy
    private JLabel enemyNameLabel;
    private JLabel enemyActionLabel;
    private JProgressBar enemyHpBar;

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

        skill1Label = new JLabel("");
        skill1Label.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        skill1Label.setBounds(skillLabelsStartX, skillLabelsY, skillLabelWidth, skillLabelHeight);

        skill2Label = new JLabel("");
        skill2Label.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        skill2Label.setBounds(skill1Label.getX()+skill1Label.getWidth(), skillLabelsY, skillLabelWidth, skillLabelHeight);

        skill3Label = new JLabel("");
        skill3Label.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        skill3Label.setBounds(skill2Label.getX()+skill2Label.getWidth(), skillLabelsY, skillLabelWidth, skillLabelHeight);

        skill4Label = new JLabel("");
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

        playerActionLabel = new JLabel("action");
        playerActionLabel.setBounds(225, 400, 150 , 50);
        playerActionLabel.setHorizontalAlignment(JLabel.CENTER);
        playerActionLabel.setFont(gameFont.deriveFont(20f));

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

        enemyActionLabel = new JLabel("mons action");
        enemyActionLabel.setBounds(100, 345, 400, 80);
        enemyActionLabel.setFont(gameFont.deriveFont(40f));
        enemyActionLabel.setHorizontalAlignment(JLabel.CENTER);


        //-- Add components
        //skill labels
        add(skill1Label);
        add(skill2Label);
        add(skill3Label);
        add(skill4Label);

        //player stuff
        add(playerHpBar);
        add(playerNameLabel);
        add(playerActionLabel);

        //enemy stuff
        add(enemyImageLabel);
        add(enemyHpBar);
        add(enemyNameLabel);
        add(enemyActionLabel);
    }

    public void setCharacters (Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;

        //player hp bar
        playerHpBar.setMaximum(player.getHealth());
        playerHpBar.setValue(player.getHealth());
        //player
        playerNameLabel.setText(player.getName());
        setPlayerSkills();

        //enemy hp bar
        enemyHpBar.setMaximum(enemy.getMaxHealth());
        enemyHpBar.setValue(enemy.getHealth());
        //enemy
        enemyNameLabel.setText(enemy.getName());
        
    }

    public void refreshHealthBars () {
        playerHpBar.setValue(player.getHealth());
        enemyHpBar.setValue(enemy.getHealth());
    }

    private void setPlayerSkills () {
        Skill[] equippedSkills = player.getEquippedSkills();

        skill1Label.setText("null");
        skill2Label.setText("null");
        skill3Label.setText("null");
        skill4Label.setText("null");

        if (equippedSkills[0] != null) {
            skill1Label.setText(equippedSkills[0].toString());    
        }
        if (equippedSkills[1] != null) {
            skill2Label.setText(equippedSkills[1].toString());    
        }
        if (equippedSkills[2] != null) {
            skill3Label.setText(equippedSkills[2].toString());    
        }
        if (equippedSkills[3] != null) {
            skill4Label.setText(equippedSkills[3].toString());    
        }

    }

    //gets
    public Player getPlayer () {
        return player;
    }
    public Enemy getEnemy () {
        return enemy;
    }
    public JLabel getEnemyActionLabel () {
        return enemyActionLabel;
    }
    public JLabel getPlayerActionLabel () {
        return playerActionLabel;
    }


}
