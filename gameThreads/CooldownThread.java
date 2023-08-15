package gameThreads;

import java.io.Serializable;
import skills.Skill;

public class CooldownThread extends Thread implements Serializable{
    
    private Skill skill;

    public CooldownThread (Skill skill) {
        this.skill = skill;
    }

    @Override
    public void run () {
        skillDown();
    }

    private void skillDown () {
        
        skill.setIsDown(true);

        int i = skill.getCooldown();
        boolean inDownTime = i != 0;

        while (inDownTime) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) { }

            i--;
            inDownTime = i != 0;
        }
        
        skill.setIsDown(false);

    }
}
