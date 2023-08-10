package keyListeners;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

import characters.*;
import frames.MainFrame;
import skills.Punch;

public class HomeKeyListener implements KeyListener{

    private MainFrame mainFrame;
    private int[] selectectBox = new int[2];

    private JLabel enterFightLabel;
    private JLabel seeStatsLabel;

    public HomeKeyListener (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        enterFightLabel = mainFrame.getHomePanel().getEnterFightLabel();
        seeStatsLabel = mainFrame.getHomePanel().getSeeStatsLabel();

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
                Player player = mainFrame.getPlayer();
                TestEnemy testEnemy = new TestEnemy();

                player.addSkill(new Punch(), 0);

                mainFrame.changeToFight();
                mainFrame.getFightPanel().setCharacters(player, testEnemy);
                mainFrame.getFightKeyListener().setCharacters(player, testEnemy);

                System.out.println("HomeKeyListener: enter fight");

            } else {
                System.out.println("HomeKeyListener: see stats");

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    public void enterFightLabOn () {
        enterFightLabel.setForeground(Color.black);
        enterFightLabel.setBackground(Color.white);
    }
    public void enterFightLabOff () {
        enterFightLabel.setForeground(Color.white);
        enterFightLabel.setBackground(Color.black);
    }

    public void seeStatsLabOn () {
        seeStatsLabel.setForeground(Color.black);
        seeStatsLabel.setBackground(Color.white);
    }
    public void seeStatsLabOff () {
        seeStatsLabel.setForeground(Color.white);
        seeStatsLabel.setBackground(Color.black);
    }
        
}
