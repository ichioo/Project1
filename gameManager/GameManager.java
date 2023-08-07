package gameManager;

import java.awt.Font;

import characters.*;
import frames.MainFrame;
import gamePanels.FightPanel;
import skills.TestSkill;

//Used to manage game phases: start, fight, ...

public class GameManager implements Runnable{

    MainFrame mainFrame;
    Font gameFont;
    Player player;


    public GameManager (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        gameFont = mainFrame.gameFont;
    }

    @Override
    public void run() {
        nameInsert();
    }

    //Other methods

    public void createPlayer (String playerName) {
        player = new Player(playerName);
        mainFrame.changeToFight();
        mainFrame.fightKeyListener.player = player;

        player.addSkill(new TestSkill(), 0);

        fightPhase();
    }   

    //Game phase methods
    public void nameInsert() {
        String text = "Enter your name: ";
        String effectString = "";

        //takes chars 1 by 1 form text and puts it into the effectString that is set as the text to the nameInseredLabel
        for (int i=0; i<text.length(); i++) {
            effectString += text.charAt(i);

            mainFrame.startPanel.nameInsertLabel.setText(effectString);

            try {
                Thread.sleep(50);
            } catch (Exception e) { }
        }
    }

    public void fightPhase () {
        FightPanel fightPanel = mainFrame.fightPanel;

        //player health bar
        fightPanel.playerNameLabel.setText(player.name);
        fightPanel.playerHpLabel.setMaximum(player.maxHealth);
        fightPanel.playerHpLabel.setValue(player.health-10);


    }

}
