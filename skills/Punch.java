package skills;

import characters.Enemy;
import characters.Player;
import gameThreads.SkillThread;

public class Punch extends Skill{
    
    private String name = "punch";
    private int damage = 10;
    private int cooldown = 2;
    private int castTime = 1;

    private boolean isCasting = false;
    private boolean isDown = false;
    private Enemy enemy;

    private Player player;
    private SkillThread skillThread;
    
    //--
    public void putInDown () {
        skillThread = new SkillThread(this, "cooldown");
        skillThread.start();
        skillThread = null;
    }

    public void cast () {
        skillThread = new SkillThread(this, "cast");
        skillThread.start();
        skillThread = null;
    }

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
    public void setIsDown (boolean isDown) {
        this.isDown = isDown;
    }
    public void setIsCasting (boolean isCasting) {
        this.isCasting = isCasting;
    }
    public void setEnemy (Enemy enemy) {
        this.enemy = enemy;
    }
    public void setPlayer (Player player) {
        this.player = player;
    }

    //--
    public String toString () {
        return name;
    }

}
