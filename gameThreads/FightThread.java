package gameThreads;

import java.io.Serializable;
import characters.Enemy;
import gamePanels.FightPanel;

public class FightThread extends Thread implements Serializable{

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
        Thread healthUpdaterThread = new HealthUpdateThread(fightPanel);
        healthUpdaterThread.start();

        enemy.setFightPanel(fightPanel.getEnemyActionLabel());
        enemy.startActions(fightPanel.getPlayer());
    }
    

}
