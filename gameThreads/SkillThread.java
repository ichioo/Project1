package gameThreads;

import java.io.Serializable;
import skills.Skill;

public class SkillThread extends Thread implements Serializable{
    
    private Skill skill;
    private String action;

    public SkillThread (Skill skill,String action) {
        this.skill = skill;
        this.action = action;
    }

    @Override
    public void run () {
        
        if (action.equals("cooldown")) {
            skillDown();
        } else if (action.equals("cast")) {
            castSkill();
        }
    }

    private void skillDown () {
        skill.setIsDown(true);

        int i = skill.getCooldown();
        boolean inDownTime = i != 0;

        while (inDownTime) {
            i--;

            try {
                Thread.sleep(1000);
            } catch (Exception e) { }

            System.out.println("SkillThread: " + skill + " cooldown - " + i);

            inDownTime = i != 0;
        }
        
        skill.setIsDown(false);

    }

    private void castSkill () {

        skill.setIsCasting(true);
        skill.getPlayer().setCanAttack(false);

        int i = skill.getCastTime();
        boolean inCasting = i != 0;

        while (inCasting) {
            i--;

            try {
                Thread.sleep(1000);
            } catch (Exception e) { }

            System.out.println("SkillThread: casting in - " + i);

            inCasting = i != 0;
        }

        skill.setIsCasting(false);
        skill.getPlayer().setCanAttack(true);

        skill.getEnemy().getHit(skill);
        System.out.println("SkillThread: " + skill + " used");
        skillDown();
    }

}
