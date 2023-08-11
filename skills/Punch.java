package skills;

import gameThreads.DownTimeThread;

public class Punch extends Skill{
    
    private String name = "punch";
    private int damage = 2;
    private int downTime = 2;
    private boolean isDown = false;

    private DownTimeThread downTimeThread = new DownTimeThread(this);

    //gets
    public int getDamage () {
        return damage;
    }
    public int getDownTime () {
        return downTime;
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
        downTimeThread.start();
        downTimeThread = new DownTimeThread(this);
    }

    //--
    public String toString () {
        return name;
    }

}
