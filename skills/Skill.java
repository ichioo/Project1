package skills;

import java.io.Serializable;

import gameThreads.CooldownThread;

public class Skill implements Serializable{
    
    private String name = "Skill par";
    private int damage;
    private int cooldown;
    private boolean isDown = false;
    
    private CooldownThread cooldownThread;

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
    //sets
    public void setIsDown (boolean isDown) {
        
    }   

    //--
    public void putInDown () { }

    //--
    public String toString () {
        return name;
    }
}
