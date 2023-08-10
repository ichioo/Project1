package characters;

import skills.Skill;

public class Enemy {
    
    private String name = "Enemy par";
    private int maxHealth;
    private int health;

    //--
    public void getHit (Skill attack) { }

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

    //--
    public String toString () {
        return name;
    }
}
