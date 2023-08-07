package gameManager;

import java.awt.Font;

import characters.*;
import frames.MainFrame;
import skills.*;

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
    public void temporary (Player player, Enemy enemy) {
        
        mainFrame.changeToFight();
        mainFrame.fightPanel.setCharacters(player, enemy);
        //collegates the player and the keyListener
        mainFrame.fightKeyListener.player = player;

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

}
