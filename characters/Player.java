package characters;

import java.io.Serializable;

import frames.MainFrame;
import gameThreads.PlayerActionsThread;
import skills.*;

public class Player implements Serializable {
    private MainFrame mainFrame;

    //player stats
    private String name;
    private int level;
    private int xp;
    private int xpToNextLvl;
    private int points;
    private int maxHealth;
    private int health;

    private int maxHpLevel = 1;

    //player skills
    private Skill[] equippedSkills;
    private Skill[] allSkills;

    //other
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
        level = 1;
        xp = 0;
        xpToNextLvl = 200;
        points = 0;

        equippedSkills = new Skill[4];
        allSkills = new Skill[5];
    }

    // -- 
    public void getHit (int damage) {
        health-=damage;
        if (!isBlocking) {
            getStunned();
        }
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

    //upgrade stats
    public void upMaxHp () {
        points--;
        maxHealth += maxHpLevel + 10;
        maxHpLevel++;
    }
    public void gainXp (int xp) {
        
        if (this.xp + xp > xpToNextLvl) {
            
            this.xp = (this.xp + xp) - xpToNextLvl;
            levelUp();
        } else if (this.xp + xp == xpToNextLvl) {

            this.xp = 0;
            levelUp();
        } else if (this.xp + xp < xpToNextLvl) {

            this.xp += xp;
        }

    }
    private void levelUp () {
        level += 1;
        points += 1;
    }

    //gets
    public String getName () {
        return name;
    }
    public int getLevel () {
        return level;
    }
    public int getXp () {
        return xp;
    }
    public int getXpToNextLvl () {
        return xpToNextLvl;
    }
    public int getPoints () {
        return points;
    }
    public int getMaxHealth () {
        return maxHealth;
    }
    public int getHealth () {
        return health;
    }
    public int getMaxHpLvl () {
        return maxHpLevel;
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
