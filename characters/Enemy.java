package characters;

import javax.swing.JLabel;

import gamePanels.FightPanel;
import skills.Skill;

public class Enemy {
    //enemy stats
    private String name = "Enemy par";
    private int maxHealth;
    private int health;

    //actions
    private boolean isDefending = false;
    private boolean isAttacking = false;
    private boolean isWaiting = false;
     
    //--
    private FightPanel fightPanel;
    private JLabel enemyActionLabel;
    

    //--
    public void getHit (Skill attack) { }
    
    //actions
    public void startActions () { }

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
    public void setFightPanel (FightPanel fightPanel) {
        this.fightPanel = fightPanel;
    }

    //--
    public String toString () {
        return name;
    }
}
