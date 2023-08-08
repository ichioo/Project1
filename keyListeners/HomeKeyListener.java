package keyListeners;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import frames.MainFrame;

public class HomeKeyListener implements KeyListener{

    MainFrame mainFrame;
    int[] selectectBox = new int[2];

    public HomeKeyListener (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        selectectBox[0] = 1;
        enterFightLabOn();
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { 

        boolean left = e.getKeyCode() == 37;
        boolean right = e.getKeyCode() == 39;
        boolean isEnterKey = e.getKeyCode() == 10;

        if(left) {
            if(selectectBox[0] != 1) {
                selectectBox[0] = 1;
                selectectBox[1] = 0;
                enterFightLabOn();
                seeStatsLabOff();

            }
            

        } if(right) {
           if(selectectBox[1] != 1) {
                selectectBox[0] = 0;
                selectectBox[1] = 1;
                enterFightLabOff();
                seeStatsLabOn();
                
            }

        }
        
        if(isEnterKey) {
            if(selectectBox[0] == 1) {
                mainFrame.changeToFight();
                System.out.println("HomeKeyListener: enter fight");

            } else {
                System.out.println("HomeKeyListener: see stats");

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    public void enterFightLabOn () {
        mainFrame.homePanel.enterFightLabel.setForeground(Color.black);
        mainFrame.homePanel.enterFightLabel.setBackground(Color.white);
    }
    public void enterFightLabOff () {
        mainFrame.homePanel.enterFightLabel.setForeground(Color.white);
        mainFrame.homePanel.enterFightLabel.setBackground(Color.black);
    }

    public void seeStatsLabOn () {
        mainFrame.homePanel.seeStatsLabel.setForeground(Color.black);
        mainFrame.homePanel.seeStatsLabel.setBackground(Color.white);
    }
    public void seeStatsLabOff () {
        mainFrame.homePanel.seeStatsLabel.setForeground(Color.white);
        mainFrame.homePanel.seeStatsLabel.setBackground(Color.black);
    }
        
}
