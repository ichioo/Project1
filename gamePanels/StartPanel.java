package gamePanels;

import java.awt.*;
import javax.swing.*;

public class StartPanel extends JPanel {

    private JLabel newGameLabel;
    private JLabel loadGameLabel;
    
    public StartPanel (Font gameFont) {
        //--
        setLayout(null);
        setPreferredSize(new Dimension(600,600));
        setBackground(Color.BLACK);

        //Components
        int selectLabX = 175;
        int selectLabStartY = 275;
        int selectLabSpaceing = 10;
        int selectLabWidth = 250;
        int selectLabHeight = 100;

        JLabel gameTitleLabel = new JLabel("game title");
        gameTitleLabel.setFont(gameFont.deriveFont(60f));
        gameTitleLabel.setForeground(Color.white);
        gameTitleLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        gameTitleLabel.setBounds(100, 50, 400, 200);
        gameTitleLabel.setHorizontalAlignment(JLabel.CENTER);

        newGameLabel = new JLabel("new game");
        newGameLabel.setFont(gameFont);
        newGameLabel.setForeground(Color.white);
        newGameLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        newGameLabel.setBounds(selectLabX, selectLabStartY, selectLabWidth, selectLabHeight);
        newGameLabel.setHorizontalAlignment(JLabel.CENTER);
        newGameLabel.setBackground(Color.BLACK);
        newGameLabel.setOpaque(true);

        loadGameLabel = new JLabel("load game");
        loadGameLabel.setFont(gameFont);
        loadGameLabel.setForeground(Color.white);
        loadGameLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        loadGameLabel.setBounds(selectLabX, selectLabStartY + selectLabHeight + selectLabSpaceing, selectLabWidth, selectLabHeight);
        loadGameLabel.setHorizontalAlignment(JLabel.CENTER);
        loadGameLabel.setBackground(Color.black);
        loadGameLabel.setOpaque(true);

        //Add components
        add(gameTitleLabel);
        add(newGameLabel);
        add(loadGameLabel);
    }

    //gets
    public JLabel getNewGameLabel () {
        return newGameLabel;
    }
    public JLabel getLoadGameLabel () {
        return loadGameLabel;
    }
}
