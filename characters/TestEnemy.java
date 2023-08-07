package characters;

public class TestEnemy extends Enemy {
    
    public String name = "test";
    public int maxHealth;
    public int health;

    public TestEnemy () {
        maxHealth = 100;
        health = maxHealth;
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
}
