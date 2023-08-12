package gameThreads;

import characters.Enemy;
import gamePanels.FightPanel;

public class FightThread extends Thread {

    private FightPanel fightPanel;
    private Enemy enemy;

    @Override
    public void run () {
        Thread.currentThread().setName("FightThread");
        enemy = fightPanel.getEnemy();
        
        fight();
    }

    public void addFightPanel (FightPanel fightPanel) {
        this.fightPanel = fightPanel;
    }

    private void fight () {
        enemy.setFightPanel(fightPanel);
        enemy.startActions();
    }

}
