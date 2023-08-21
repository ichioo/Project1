package gameThreads;

import java.io.Serializable;
import characters.Enemy;
import characters.Player;
import frames.MainFrame;
import gamePanels.FightPanel;

public class FightThread extends Thread implements Serializable{

    private FightPanel fightPanel;
    private MainFrame mainFrame;
    private Player player;
    private Enemy enemy;

    @Override
    public void run () {
        Thread.currentThread().setName("FightThread");
        enemy = fightPanel.getEnemy();
        player = fightPanel.getPlayer();
        
        fight();
    }

    public void addMainFrame (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.fightPanel = mainFrame.getFightPanel();
    }

    private void fight () {
        Thread healthUpdaterThread = new HealthUpdateThread(fightPanel);
        healthUpdaterThread.start();

        enemy.setFightPanel(fightPanel.getEnemyActionLabel());
        enemy.startActions(fightPanel.getPlayer());


        if (enemy.getHealth() <= 0) {

            try {
                Thread.sleep(999);
            } catch (Exception e) { }

            mainFrame.changeToRewards();
            mainFrame.getRewardsPanel().playerWon();
            mainFrame.getPlayer().gainXp(enemy.getXp());
        } 

        if (player.getHealth() <= 0) {

            mainFrame.changeToRewards();
            mainFrame.getRewardsPanel().playerDied();
        }
        
    }
    

}
