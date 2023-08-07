package characters;

import skills.*;

public class Player {
    
    public String name;
    public int maxHealth;
    public int health;

    public Skill[] skills;

    public Player (String name) {
        this.name = name;
        maxHealth = 100;
        health = maxHealth;
        skills = new Skill[4];
    }

    public void addSkill (Skill skill, int slot) {

        if(skills[slot] != null) {
            System.out.println("player: slot occupato");

        } else {
            skills[slot] = skill;
            System.out.println("player: skill inserita");

        }

    }
}
