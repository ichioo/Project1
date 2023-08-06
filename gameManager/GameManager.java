package gameManager;


import java.awt.Font;

import frames.MainFrame;
import keyListeners.NameInKeyListener;

//Used to manage game phases: start, fight, ...

public class GameManager implements Runnable{

    MainFrame mainFrame;
    Font gameFont;
    String playerName;

    public GameManager (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        gameFont = mainFrame.gameFont;
    }

    @Override
    public void run() {
        nameInsert();
    }

    //Other methods

    public void setPlayerName (String playerName) {
        this.playerName = playerName;
        mainFrame.changePanel();
        test();
    }   

    //Game fase methods
    public void nameInsert() {
        mainFrame.addKeyListener(new NameInKeyListener(mainFrame));

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

    public void test () {
        mainFrame.testPanel.test.setText("ciao! " + playerName);
    }

}
