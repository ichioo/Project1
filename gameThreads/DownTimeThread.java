package gameThreads;

import skills.Skill;

public class DownTimeThread extends Thread {
    
    private Skill skill;

    public DownTimeThread (Skill skill) {
        this.skill = skill;
    }

    @Override
    public void run () {
        skillDown();
    }

    private void skillDown () {
        
        skill.setIsDown(true);

        int i = skill.getDownTime();
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
