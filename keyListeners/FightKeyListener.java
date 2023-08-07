package keyListeners;

import java.awt.event.*;
import characters.*;

public class FightKeyListener implements KeyListener {

    public Player player;

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyChar() == '1') {
            System.out.println(player.skills[0]);
        }
        if(e.getKeyChar() == '2') {
            System.out.println(player.skills[1]);
        }
        if(e.getKeyChar() == '3') {
            System.out.println(player.skills[2]);
        }
        if(e.getKeyChar() == '4') {
            System.out.println(player.skills[3]);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
    
}
