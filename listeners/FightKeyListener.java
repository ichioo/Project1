package listeners;

import java.awt.event.*;
import java.io.Serializable;
import characters.*;
import skills.Skill;

public class FightKeyListener implements KeyListener, Serializable{

    private Player player;
    private Enemy enemy;
    private Skill[] playerSkills;

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { }
    
    @Override
    public void keyReleased(KeyEvent e) {

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
    }

    private void activateSkill (int skillNumber) {
        boolean skillAvalible = playerSkills[skillNumber] != null;

        if(skillAvalible) {
            boolean skillDown = playerSkills[skillNumber].isDown();
            
                if(!skillDown) {
                    if (!player.isBlocking() && !player.isDodging() && player.canAttack() && !player.isStunned()) {

                        castSkill(playerSkills[skillNumber].getCastTime());
                        enemy.getHit(playerSkills[skillNumber]);
                        playerSkills[skillNumber].putInDown();
                        System.out.println("FightKeyListener: skill used: " + playerSkills[skillNumber]);
                    } else {

                        System.out.println("FightKeyListener: bloking/dodgeing/stunned/after dodge cooldown");
                    }
                } else {

                    System.out.println("FightKeyListener: skill down");
                }

            }
    }

    private void castSkill (int castTime) {

        for (int i=1; i<=castTime; i++) {

            System.out.println("FightKeyListener: casting - " + i);
            try {
                Thread.sleep(999);
            } catch (Exception e) { }

        }
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
