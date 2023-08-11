package skills;

import gameThreads.DownTimeThread;

public class Skill {
    
    private String name = "Skill par";
    private int damage;
    private int downTime;
    private boolean isDown = false;
    
    private DownTimeThread downTimeThread;

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
        
    }   

    //--
    public void putInDown () { }

    //--
    public String toString () {
        return name;
    }
}
