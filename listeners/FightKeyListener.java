package listeners;

import java.awt.event.*;
import characters.*;
import skills.Skill;

public class FightKeyListener implements KeyListener {

    private Player player;
    private Enemy enemy;
    private Skill[] playerSkills;

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { }
    
    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyChar() == '1') {
            if(playerSkills[0] != null) {
                if(!playerSkills[0].isDown()) {

                    enemy.getHit(playerSkills[0]);
                    playerSkills[0].putInDown();
                    System.out.println("FightKeyListener: skill used: " + playerSkills[0]);
                } else {

                    System.out.println("skill down");
                }

            }
        }
        if(e.getKeyChar() == '2') {
            if(playerSkills[1] != null) {
                enemy.getHit(playerSkills[1]);
            }
        }
        if(e.getKeyChar() == '3') {
            if(playerSkills[2] != null) {
                enemy.getHit(playerSkills[2]);
            }
        }
        if(e.getKeyChar() == '4') {
            if(playerSkills[3] != null) {
                enemy.getHit(playerSkills[3]);
            }
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
        playerSkills = player.getSkills();
    }

    //gets
    public Player getPlayer () {
        return player;
    }
}
