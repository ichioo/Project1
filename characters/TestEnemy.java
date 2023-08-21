package characters;

import java.io.Serializable;

import javax.swing.JLabel;
import skills.Skill;

public class TestEnemy extends Enemy implements Serializable{
    //enemy stats
    private String name = "test enemy";
    private int maxHealth;
    private int health;
    private int xp;

    //actions
    private boolean isDefending = false;
    private boolean isAttacking = false;
    private boolean isWaiting = false;

    private Player player;
     
    //--
    private JLabel enemyActionLabel;

    public TestEnemy () {
        maxHealth = 10;
        health = maxHealth;
        xp = 100;
    }

    //--
    public void getHit (Skill attack) {
        health -= attack.getDamage();
    }
    
    public void startActions (Player player) {
        this.player = player;

        while (health > 0 && player.getHealth() > 0) {

            normalAttack(player);
            normalAttack(player);
            fastAttack(player);
            fastAttack(player);
            normalAttack(player);
            fastAttack(player);
            fastAttack(player);
            fastAttack(player);
            normalAttack(player);
        }
    }

    private void attack (int damage) {
        
        if (!player.isBlocking() && !player.isDodging()) {
            player.getHit(damage);
            enemyActionLabel.setText("attack");

        } else if (player.isBlocking()) {
            player.getHit(damage / 2);
            enemyActionLabel.setText("player blocked");

        } else if (player.isDodging()) {

            enemyActionLabel.setText("player dodged");
        }
    }

    //actions
    private void normalAttack (Player player) {
        int duration = 4;
        long startTime;
        long endTime;

        for (int i=duration; i>=0; i--) {
            startTime = System.nanoTime();
            if (health <= 0) {
                break;
            }
            //--

            enemyActionLabel.setText(Integer.toString(i));
            if (i == 0) {
                attack(10);
            }

            //--
            endTime = System.nanoTime();
            // wait 1 second
            try {
                Thread.sleep((1000000000 - (endTime-startTime)) / 1000000);
            } catch (Exception e) { }
        }
    }

    private void fastAttack (Player player) {
        int durationDs = 10;
        long startTime;
        long endTime;

        for (int i=durationDs; i>=0; i--) {
            startTime = System.nanoTime();
            if (health <= 0) {
                break;
            }
            //--

            enemyActionLabel.setText("" + ((float) i/10));
            if (i == 0) {
                attack(10);
            }

            //--
            endTime = System.nanoTime();
            if (i != 0) {
                //wait 0.1 seconds
                try {
                    Thread.sleep((1000000000 - (endTime-startTime)) / 10000000);
                } catch (Exception e) { }
            } else {
                try {
                    Thread.sleep(499);
                } catch (Exception e) { }
            }
        }
    }

    //gets
    public String getName () {
        return name;
    }
    public int getMaxHealth () {
        return maxHealth;
    }
    public int getHealth () {
        return health;
    }
    public int getXp () {
        return xp;
    }
    public boolean getIsDefending () {
        return isDefending;
    }
    public boolean getIsAttacking () {
        return isAttacking;
    }
    public boolean getIsWaiting () {
        return isWaiting;
    }
    //sets
    public void setIsDefending (boolean isDefending) {
        this.isDefending = isDefending;
    }
    public void setIsAttacking (boolean isAttacking) {
        this.isAttacking = isAttacking;
    }
    public void setIsWaiting (boolean isWaiting) {
        this.isWaiting = isWaiting;
    }
    public void setFightPanel (JLabel enemyActionLabel) {
        this.enemyActionLabel = enemyActionLabel;
    }

    //--
    public String toString () {
        return name;
    }
}
