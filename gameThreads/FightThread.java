package gameThreads;

import javax.swing.JLabel;

import gamePanels.FightPanel;

public class FightThread extends Thread {

    private FightPanel fightPanel;

    @Override
    public void run () {
        fight();
    }

    public void addFightPanel (FightPanel fightPanel) {
        this.fightPanel = fightPanel;
    }

    private void fight () {
        int loopPerSec = 40;
        long sleepTime = 1000/loopPerSec;
        int loopCounter = 0;
        
        JLabel enemyActionLabel = fightPanel.getEnemyActionLabel();
        boolean temp = true;

        while (true) {

            if(loopCounter == loopPerSec) {
                if(temp) {
                    enemyActionLabel.setText("action1");
                    temp = false;
                    loopCounter = 0;
                } else {
                    enemyActionLabel.setText("action2");
                    temp = true;
                    loopCounter = 0;
                }
                
            } 



            fightPanel.refreshHealthBars();
            try {
                Thread.sleep(sleepTime);
                loopCounter += 1;
            } catch (Exception e) { }
        }

    }

}
