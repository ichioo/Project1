package listeners;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import characters.Player;
import frames.MainFrame;
import gameSaverLoader.GameSaverLoader;

public class StartKeyListener implements KeyListener{

    private MainFrame mainFrame;
    private JLabel newGameLabel;
    private JLabel loadGameLabel;

    private GameSaverLoader gameSaverLoader;

    //keys
    private boolean up;
    private boolean down;
    private boolean isEnterKey;

    private int[] selectectBox = new int[2];

    public StartKeyListener (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        newGameLabel = mainFrame.getStartPanel().getNewGameLabel();
        loadGameLabel = mainFrame.getStartPanel().getLoadGameLabel();

        selectectBox[0] = 1;
        newGameLabelOn();

    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { 

        up = e.getKeyCode() == 38;
        down = e.getKeyCode() == 40;
        isEnterKey = e.getKeyCode() == 10;

        if(up) {
            if(selectectBox[0] != 1) {
                newGameLabelOn();
                loadGameLabelOff();
                selectectBox[0] = 1;
                selectectBox[1] = 0;
            }

        }
        if(down) {
            if(selectectBox[1] != 1) {
                newGameLabelOff();
                loadGameLabelOn();
                selectectBox[0] = 0;
                selectectBox[1] = 1;
            }

        }

        if(isEnterKey) {
            if(selectectBox[0] == 1) {
                
                System.out.println("StartKeyListener: new game");
                mainFrame.changeToNameInsert();
                mainFrame.getCurrentThread().start();
            } else {

                System.out.println("StartKeyListener: load game");

                //loading player
                gameSaverLoader = new GameSaverLoader();    
                Player loadedPlayer = gameSaverLoader.load();

                boolean playerLoaded = loadedPlayer != null;
                if (playerLoaded) {

                    mainFrame.setPlayer(loadedPlayer);
                    loadedPlayer.setMainFrame(mainFrame);
                    System.out.println("Player loaded");
                    mainFrame.changeToHome();
                } else {

                    System.out.println("Error while loading player");
                }
                
                gameSaverLoader = null;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    public void newGameLabelOn () {
        newGameLabel.setBackground(Color.WHITE);
        newGameLabel.setForeground(Color.black);
    }
    public void newGameLabelOff () {
        newGameLabel.setBackground(Color.black);
        newGameLabel.setForeground(Color.white);
    }

    public void loadGameLabelOn () {
        loadGameLabel.setBackground(Color.WHITE);
        loadGameLabel.setForeground(Color.black);
    }
    public void loadGameLabelOff () {
        loadGameLabel.setBackground(Color.black);
        loadGameLabel.setForeground(Color.white);
    }
    
}
