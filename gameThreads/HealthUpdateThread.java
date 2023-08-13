package gameThreads;

import gamePanels.FightPanel;

public class HealthUpdateThread extends Thread {

    private FightPanel fightPanel;

    public HealthUpdateThread (FightPanel fightPanel) {
        this.fightPanel = fightPanel;
    }

    @Override   
    public void run () {
        int loopsPerSec = 40;
        int sleepTime = 1000/loopsPerSec;

        refreshLoop(sleepTime);
    }

    private void refreshLoop (int sleepTime) {
        while (true) {
            fightPanel.refreshHealthBars();

            try {
                Thread.sleep(sleepTime);
            } catch (Exception e) { }
        }
    }
}
