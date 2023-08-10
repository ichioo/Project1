package skills;

import characters.Enemy;

public class Punch extends Skill{
    
    public String name = "punch";
    public int damage = 2;

    //gets
    public int getDamage () {
        return damage;
    }

    //--
    public String toString () {
        return name;
    }

}
