package skills;

import java.io.Serializable;
import characters.Enemy;
import characters.Player;
import gameThreads.SkillThread;

public class Skill implements Serializable{
    
    private String name = "Skill";
    private int damage;
    private int cooldown;
    private int castTime;

    private boolean isCasting = false;
    private boolean isDown = false;
    private Enemy enemy;

    private Player player;
    private SkillThread skillThread;
    
    //--
    public void putInDown () { }
    public void cast () { }

    //gets
    public int getDamage () {
        return damage;
    }
    public int getCooldown () {
        return cooldown;
    }
    public boolean isDown () {
        return isDown;
    }
    public int getCastTime () {
        return castTime;
    }
    public boolean isCasting () {
        return isCasting;
    }
    public SkillThread getSkillThread () {
        return skillThread;
    }
    public Enemy getEnemy () {
        return enemy;
    }
    public Player getPlayer () {
        return player;
    }
    //sets
    public void setIsDown (boolean isDown) { }
    public void setIsCasting (boolean isCasting) { }
    public void setEnemy (Enemy enemy) { }
    public void setPlayer (Player player) { }

    //--
    public String toString () {
        return name;
    }
}
