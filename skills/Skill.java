package skills;

import java.io.Serializable;

import gameThreads.CooldownThread;

public class Skill implements Serializable{
    
    private String name = "Skill";
    private int damage;
    private int cooldown;
    private int castTime;

    private boolean isDown = false;

    private CooldownThread cooldownThread;
    
    //--
    public void putInDown () { }

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
    //sets
    public void setIsDown (boolean isDown) { }

    //--
    public String toString () {
        return name;
    }
}
