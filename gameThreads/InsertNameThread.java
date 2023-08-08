package gameThreads;

import java.awt.Font;
import characters.*;
import frames.MainFrame;

public class InsertNameThread extends Thread{

    MainFrame mainFrame;
    Font gameFont;
    Player player;

    public InsertNameThread (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        gameFont = mainFrame.gameFont;
    }

    @Override
    public void run() {
        nameInsert();
    }

    //Game phase methods
    public void nameInsert () {
        String text = "Enter your name: ";
        String effectString = "";

        //takes chars 1 by 1 form text and puts it into the effectString that is set as the text to the nameInseredLabel
        for (int i=0; i<text.length(); i++) {
            effectString += text.charAt(i);
            mainFrame.nameInPanel.nameInsertLabel.setText(effectString);

            try {
                Thread.sleep(50);
            } catch (Exception e) { }
        }
    }

}
