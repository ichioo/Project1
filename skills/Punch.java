package skills;

import gameThreads.CooldownThread;

public class Punch extends Skill{
    
    private String name = "punch";
    private int damage = 2;
    private int cooldown = 2;
    private boolean isDown = false;

    private CooldownThread cooldownThread = new CooldownThread(this);

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
        this.isDown = isDown;
    }

    //--
    public void putInDown () {
        cooldownThread.start();
        cooldownThread = new CooldownThread(this);
    }

    //--
    public String toString () {
        return name;
    }

}
