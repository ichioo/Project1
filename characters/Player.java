package characters;

import java.io.Serializable;

import skills.*;

public class Player implements Serializable {
    
    private String name;
    private int maxHealth;
    private int health;

    private Skill[] equippedSkills;
    private Skill[] allSkills;

    public Player (String name) {
        this.name = name;
        maxHealth = 100;
        health = maxHealth;
        equippedSkills = new Skill[4];
        allSkills = new Skill[5];
    }

    public void addSkill (Skill skill, int slot) {
        //add to allSkills
        int counter = 0;
        boolean addedInAll = false;
        
        while (!addedInAll) {

            if (allSkills[counter] == null) {
                allSkills[counter] = skill;
                addedInAll = true;
                System.out.println("Player: " + skill + " addeto to allSkills");
            } else {
                counter++;
            }
        }

    }

    public int equipSkill (Skill skill) {
        
        //checks if the skill is arleady equipped
        for (int i=0; i<4; i++) {

            if (equippedSkills[i] == skill) {
                System.out.println("Player: skill areleady equipped");
                return 1;
            }
        }

        //tries to add the skill
        for (int i=0; i<4; i++) {

            if (equippedSkills[i] == null) {
                equippedSkills[i] = skill;
                System.out.println("Player: skill equipped");
                return 0;
            }

        }

        System.out.println("Player: slots are full");
        return 1;
    }

    public void unequipSkill (int skillNumber) {

        if (equippedSkills[skillNumber] != null) {
            System.out.println("PLayer: skill " + equippedSkills[skillNumber] + " unequpipped");
            equippedSkills[skillNumber] = null;
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
    public Skill[] getEquippedSkills () {
        return equippedSkills;
    }
    public Skill[] getAllSkills () {
        return allSkills;
    }
    //--
    public String toString () {
        return name;
    }
}
