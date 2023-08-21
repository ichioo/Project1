package listeners;

import java.awt.event.*;
import java.io.Serializable;
import characters.*;
import frames.MainFrame;
import skills.Skill;

public class FightKeyListener implements KeyListener, Serializable {

    private MainFrame mainFrame;
    private Player player;
    private Enemy enemy;
    private Skill[] playerSkills;

    //keys
    private boolean enter;

    public FightKeyListener (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { }
    
    @Override
    public void keyReleased(KeyEvent e) {
        enter = e.getKeyCode() == 10;

        if (e.getKeyChar() == '1') {
            activateSkill(0);
        }
        if (e.getKeyChar() == '2') {
            activateSkill(1);
        }
        if (e.getKeyChar() == '3') {
            activateSkill(2);
        }
        if (e.getKeyChar() == '4') {
            activateSkill(3);
        }

        if (e.getKeyChar() == 'b') {
            player.block();
        }
        if (e.getKeyChar() == 'd') {
            player.dodge();
        }

        if (enter && enemy.getHealth() <= 0) {
            System.out.println("FightKeyListener: enter");
            mainFrame.changeToHome();
        }
    }

    private void activateSkill (int skillNumber) {
        boolean skillAvalible = playerSkills[skillNumber] != null;

        if(skillAvalible) {
            boolean skillDown = playerSkills[skillNumber].isDown();
            
            if(!skillDown && !areSkillsCasting()) {
                if (!player.isBlocking() && !player.isDodging() && player.canAttack() && !player.isStunned()) {


                    playerSkills[skillNumber].setEnemy(enemy);
                    playerSkills[skillNumber].cast();

                } else {

                    System.out.println("FightKeyListener: bloking/dodgeing/stunned/after dodge cooldown");
                }
            } else {
                System.out.println("FightKeyListener: skill down/skill casting");
            }

        }
        
    }

    private boolean areSkillsCasting () {

        for (Skill skill : playerSkills) {

            try {
                if (skill.isCasting()) {
                    return true;
                }
            } catch (Exception e) { }
        }

        return false;
    }

    //-- 
    public void setCharacters (Player player, Enemy enemy) {
        setPlayer(player);
        this.enemy = enemy;
        
    }

    //sets
    public void setPlayer (Player player) {
        this.player = player;
        playerSkills = player.getEquippedSkills();
    }

    //gets
    public Player getPlayer () {
        return player;
    }
}
