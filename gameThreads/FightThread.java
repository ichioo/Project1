package gameThreads;

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
        int loopPerSec = 30;
        long sleepTime = 1000/loopPerSec;

        
        while (true) {

            fightPanel.refreshHealthBars();

            try {
                Thread.sleep(sleepTime);
            } catch (Exception e) { }
        }

    }

}
