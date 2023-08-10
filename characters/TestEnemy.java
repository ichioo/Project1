package characters;

import skills.Skill;

public class TestEnemy extends Enemy {
    
    private String name = "test enemy";
    private int maxHealth;
    private int health;

    public TestEnemy () {
        maxHealth = 100;
        health = maxHealth;
    }

    //--
    public void getHit (Skill attack) {
        health -= attack.getDamage();
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

    //--
    public String toString () {
        return name;
    }
}
