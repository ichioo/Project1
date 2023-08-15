package gamePanels;

import javax.swing.*;
import characters.Player;
import java.awt.*;

public class StatsPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel maxHealthLabel;
    private Player player;

    public StatsPanel (Font gameFont, Player player) {
        this.player = player;

        //--
        setLayout(null);
        setPreferredSize(new Dimension(600,600));
        setBackground(Color.black);

        //Components
        int startX = 50;
        int startY = 170;
        int width = 300;
        int height = 50;
        
        nameLabel = new JLabel("name");
        nameLabel.setFont(gameFont.deriveFont(60f));
        nameLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        nameLabel.setBounds(50, 50, 500, 100);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        
        maxHealthLabel = new JLabel("max health: 0");
        maxHealthLabel.setFont(gameFont);
        maxHealthLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        maxHealthLabel.setBounds(startX, startY, width, height);
        maxHealthLabel.setHorizontalAlignment(JLabel.CENTER);



        //Add components
        add(nameLabel);
        add(maxHealthLabel);

        updateLabels();
    }

    private void updateLabels () {

        nameLabel.setText(player.getName());
        maxHealthLabel.setText("max health: " + player.getMaxHealth());
    }
}
