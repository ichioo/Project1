package characters;

import java.io.Serializable;

import frames.MainFrame;
import gameThreads.PlayerActionsThread;
import skills.*;

public class Player implements Serializable {
    private MainFrame mainFrame;

    //player attributes
    private String name;
    private int maxHealth;
    private int health;

    private Skill[] equippedSkills;
    private Skill[] allSkills;

    private boolean isBlocking = false;
    private boolean canBlock = true;
    private boolean isDodging = false;
    private boolean canDodge = true;
    private boolean canAttack = true;
    private boolean isStunned = false;

    private PlayerActionsThread playerActionsThread;

    public Player (String name) {
        this.name = name;
        maxHealth = 100;
        health = maxHealth;
        equippedSkills = new Skill[4];
        allSkills = new Skill[5];
    }

    // -- 
    public void getHit (int damage) {
        health-=damage;
        getStunned();
    }

    public void block () {
        if (!isBlocking && !isDodging && canBlock) {
            playerActionsThread = new PlayerActionsThread(this, "blocking", mainFrame);
            playerActionsThread.start();
            playerActionsThread = null;
        }
    }

    public void dodge () {
        if (!isBlocking && !isDodging && canDodge) {
            playerActionsThread = new PlayerActionsThread(this, "dodge", mainFrame);
            playerActionsThread.start();
            playerActionsThread = null;
        }

    }

    private void getStunned () {
        playerActionsThread = new PlayerActionsThread(this, "stun", mainFrame);
        playerActionsThread.start();
        playerActionsThread = null;
    }

    public void addSkill (Skill skill) {
        //add to allSkills
        int counter = 0;
        boolean addedInAll = false;
        
        while (!addedInAll) {

            if (allSkills[counter] == null) {
                skill.setPlayer(this);
                allSkills[counter] = skill;
                addedInAll = true;
                System.out.println("Player: " + skill + " added to to allSkills");
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
    public MainFrame getMainFrame () {
        return mainFrame;
    }
    public Skill[] getEquippedSkills () {
        return equippedSkills;
    }
    public Skill[] getAllSkills () {
        return allSkills;
    }
    // -- actions
    public boolean isBlocking () {
        return isBlocking;
    }
    public boolean canBlock () {
        return canBlock;
    }
    public boolean canDodge () {
        return canDodge;
    }
    public boolean isDodging () {
        return isDodging;
    }
    public boolean canAttack () {
        return canAttack;
    }
    public boolean isStunned () {
        return isStunned;
    }
    //sets
    public void setMainFrame (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    // -- actions
    public void setIsBlocking (boolean isBlocking) {
        this.isBlocking = isBlocking;
    }
    public void setCanBlock (boolean canBlock) {
        this.canBlock = canBlock;
    }
    public void setIsDodging (boolean isDodging) {
        this.isDodging = isDodging;
    }
    public void setCanDodge (boolean canDodge) {
        this.canDodge = canDodge;
    }
    public void setCanAttack (boolean canAttack) {
        this.canAttack = canAttack;
    }
    public void setIsStunned (boolean isStunned) {
        this.isStunned = isStunned;
    }

    //--
    public String toString () {
        return name;
    }
}
