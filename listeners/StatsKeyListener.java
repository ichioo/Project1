package listeners;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.JLabel;
import frames.MainFrame;

public class StatsKeyListener implements KeyListener, Serializable {

    private MainFrame mainFrame;
    private JLabel spendPointsLabel;

    private JLabel[] spendLabels;
    private int[] spendLabelsInt;
    private int currentBox;

    private boolean inStats = true;
    private boolean inSpend = false;
    
    //keys
    // private boolean left;
    // private boolean right;
    private boolean up;
    private boolean down;
    private boolean enter;
    private boolean esc;

    public StatsKeyListener (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.spendPointsLabel = mainFrame.getStatsPanel().getSpendPointsLabel();
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {

        esc = e.getKeyCode() == 27;
        // left = e.getKeyCode() == 37;
        // right = e.getKeyCode() == 39;
        up = e.getKeyCode() == 38;
        down = e.getKeyCode() == 40;
        enter = e.getKeyCode() == 10;

        if (inSpend) {

            if (up && currentBox != 0) {
                currentBox -= 1;
            }
            if (down && (currentBox+1) < spendLabelsInt.length) {
                currentBox += 1;
            }

            turnOnBox();

            if (enter) {

                if (currentBox == 0) {
                    mainFrame.getPlayer().upMaxHp();
                    turnOnBox();
                    mainFrame.getSpendPointsPanel().updatePointsLabel();
                }

                //check if points remaining
                if (mainFrame.getPlayer().getPoints() == 0) {
                    changeToStats();
                }
            }
        }

        if (e.getKeyChar() == 'p' && spendPointsLabel.getForeground() == Color.yellow && inStats) {
            changeToSpend();
        }

        if (esc) {
            mainFrame.changeToHome();
            System.out.println("StatsKeyListener : esc");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    private void changeToStats () {
        mainFrame.changeToStats();
        inStats = true;
        inSpend = false;

    }

    private void changeToSpend () {
        mainFrame.changeToSpendPoints();
        inStats = false;
        inSpend = true;

        spendLabels = mainFrame.getSpendPointsPanel().getAllLabels();
        currentBox = 0;
        spendLabelsInt = new int[spendLabels.length];
        turnOnBox();

    }

    private void turnOnBox () {
        turnOffAllBoxes();
        spendLabelsInt[currentBox] = 1;
        spendLabels[currentBox].setForeground(Color.yellow);

        if (currentBox == 0) {
            mainFrame.getSpendPointsPanel().setHpUpText();
        }
    }

    private void turnOffAllBoxes () {

        for (JLabel label : spendLabels) {
            label.setForeground(Color.white);
        }
        for (int i=0; i<spendLabelsInt.length; i++) {
            spendLabelsInt[i] = 0;
        }
    }


    
}
