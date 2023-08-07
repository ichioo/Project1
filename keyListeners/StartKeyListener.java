package keyListeners;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import frames.MainFrame;

public class StartKeyListener implements KeyListener {

    MainFrame mainFrame;
    int[] selectectBox = new int[2];

    public StartKeyListener (MainFrame mainFrame) {

        this.mainFrame = mainFrame;
        selectectBox[0] = 1;
        newGameLabelOn();

    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { 

        boolean up = e.getKeyCode() == 38;
        boolean down = e.getKeyCode() == 40;
        boolean isEnterKey = e.getKeyCode() == 10;

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
                System.out.println("new game");
                mainFrame.changeToNameInsert();
                mainFrame.inNameThread.start();
            } else {
                System.out.println("load game");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    public void newGameLabelOn () {
        mainFrame.startPanel.newGameLabel.setBackground(Color.WHITE);
        mainFrame.startPanel.newGameLabel.setForeground(Color.black);
    }
    public void newGameLabelOff () {
        mainFrame.startPanel.newGameLabel.setBackground(Color.black);
        mainFrame.startPanel.newGameLabel.setForeground(Color.white);
    }

    public void loadGameLabelOn () {
        mainFrame.startPanel.loadGameLabel.setBackground(Color.WHITE);
        mainFrame.startPanel.loadGameLabel.setForeground(Color.black);
    }
    public void loadGameLabelOff () {
        mainFrame.startPanel.loadGameLabel.setBackground(Color.black);
        mainFrame.startPanel.loadGameLabel.setForeground(Color.white);
    }
    
}
