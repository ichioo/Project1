package listeners;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.JLabel;
import characters.*;
import frames.MainFrame;

public class HomeKeyListener implements KeyListener, Serializable{

    private MainFrame mainFrame;
    private int[] selectBoxes = new int[3];

    private JLabel enterFightLabel;
    private JLabel seeStatsLabel;
    private JLabel seeSkillsLabel;

    //keys
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;
    private boolean isEnterKey;

    //booleans
    private boolean onEnterFight;
    private boolean onSeeStats;
    private boolean onSeeSkills;

    public HomeKeyListener (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        enterFightLabel = mainFrame.getHomePanel().getEnterFightLabel();
        seeStatsLabel = mainFrame.getHomePanel().getSeeStatsLabel();
        seeSkillsLabel = mainFrame.getHomePanel().getSeeSkillsLabel();
        
        //starts on the first selectbox
        selectBoxes[0] = 1;

        enterFightLabOn();
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { 

        left = e.getKeyCode() == 37;
        right = e.getKeyCode() == 39;
        up = e.getKeyCode() == 38;
        down = e.getKeyCode() == 40;
        isEnterKey = e.getKeyCode() == 10;



        if(left) {
            if(selectBoxes[0] != 1) {
                turnOnBox(0);
            }  

        } if(right) {
            if(selectBoxes[1] != 1) {
                turnOnBox(1);    
            } 

        } if(down) {
           if(selectBoxes[2] != 1) {
                turnOnBox(2);
                
            }
        }  if (up) {
            if(selectBoxes[2] == 1 && selectBoxes[0] != 1) {
                turnOnBox(0);
            }
        }
        
        if(isEnterKey) {    
            onEnterFight = selectBoxes[0] == 1;
            onSeeStats = selectBoxes[1] == 1;
            onSeeSkills = selectBoxes[2] == 1;

            if(onEnterFight) {
                Player player = mainFrame.getPlayer();
                player.resetHealth();
                TestEnemy testEnemy = new TestEnemy();

                mainFrame.changeToFight();
                mainFrame.getFightPanel().setCharacters(player, testEnemy);
                mainFrame.getFightKeyListener().setCharacters(player, testEnemy);

                System.out.println("HomeKeyListener: enter fight");

            } else if (onSeeStats) {

                mainFrame.changeToStats();
                System.out.println("HomeKeyListener: see stats");

            } else if (onSeeSkills) {

                mainFrame.changeToSkills();
                System.out.println("HomeKeyListener: see skills");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    public void turnOnBox (int boxNumber) {
        //turns off all boxes
        enterFightLabOff();
        seeStatsLabOff();
        seeSkillsLabOff();

        for (int i=0; i< selectBoxes.length; i++) {
            selectBoxes[i] = 0;
        }

        //turns on selectBox selected
        if(boxNumber == 0) {
            enterFightLabOn();
        } if (boxNumber == 1) {
            seeStatsLabOn();
        } if (boxNumber == 2) {
            seeSkillsLabOn();
        }
        selectBoxes[boxNumber] = 1;
    }

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
    
    public void seeSkillsLabOn () {
        seeSkillsLabel.setForeground(Color.black);
        seeSkillsLabel.setBackground(Color.white);
    }
    public void seeSkillsLabOff () {
        seeSkillsLabel.setForeground(Color.white);
        seeSkillsLabel.setBackground(Color.black);
    }
}
