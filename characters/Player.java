package characters;

import skills.*;

public class Player {
    
    private String name;
    private int maxHealth;
    private int health;

    private Skill[] skills;

    public Player (String name) {
        this.name = name;
        maxHealth = 100;
        health = maxHealth;
        skills = new Skill[4];
    }

    public void addSkill (Skill skill, int slot) {

        if(skills[slot] != null) {
            System.out.println("Player: slot occupato");

        } else {
            skills[slot] = skill;
            System.out.println("Player: skill inserita");

        }

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
    public Skill[] getSkills () {
        return skills;
    }

    //--
    public String toString () {
        return name;
    }
}
