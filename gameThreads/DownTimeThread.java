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
        
        for (int i = skill.getDownTime(); i>0; i--) {
            System.out.println(skill + " down");
            
            try {
                Thread.sleep(1000);
            } catch (Exception e) { }
        
        }
        
        skill.setIsDown(false);

    }
}
