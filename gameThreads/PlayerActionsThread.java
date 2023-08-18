package gameThreads;

import java.io.Serializable;
import characters.Player;
import frames.MainFrame;

public class PlayerActionsThread extends Thread implements Serializable{

    private Player player;
    private String action = "";
    private MainFrame mainFrame;

    public PlayerActionsThread (Player player, String action, MainFrame mainFrame) {
        this.player = player;
        this.action = action;
        this.mainFrame = mainFrame;
    }
    
    @Override
    public void run () {

        if (action.equals("blocking")) {
            block();
        } else if (action.equals("dodge")) {
            dodge();
        } else if (action.equals("stun")) {
            stun();
        }
    }

    private void block () {

        int durationDs = 25;    //decaseconds
        player.setIsBlocking(true);

        for (int i=durationDs; i>0; i--) {

            mainFrame.getFightPanel().getPlayerActionLabel().setText("blocking: " + ((float) i/10));

            try {
                Thread.sleep(99);
            } catch (Exception e) { }
        } 

        mainFrame.getFightPanel().getPlayerActionLabel().setText("blocking: 0");
        player.setIsBlocking(false);
    }

    private void dodge () {

        int durationDs = 5; //decaseconds
        player.setIsDodging(true);

        for (int i=durationDs; i>0; i--) {

            mainFrame.getFightPanel().getPlayerActionLabel().setText("dodging: " + ((float) i/10));

            try {
                Thread.sleep(99);
            } catch (Exception e) { }
        } 

        mainFrame.getFightPanel().getPlayerActionLabel().setText("dodging: 0");
        player.setIsDodging(false);

        //can attack cooldown
        player.setCanAttack(false);
        player.setCanBlock(false);
        player.setCanDodge(false);

        mainFrame.getFightPanel().getPlayerActionLabel().setText(" __ ");
        try {
            Thread.sleep(499);
        } catch (Exception e) { }
        mainFrame.getFightPanel().getPlayerActionLabel().setText(" ^^ ");

        player.setCanAttack(true);
        player.setCanBlock(true);
        player.setCanDodge(true);
    }

    private void stun () {

        int durationDs = 9;    //decaseconds
        player.setIsStunned(true);
        player.setCanAttack(false);
        player.setCanBlock(false);
        player.setCanDodge(false);

        for (int i=durationDs; i>0; i--) {

            mainFrame.getFightPanel().getPlayerActionLabel().setText("stunned: " + ((float) i/10));

            try {
                Thread.sleep(99);
            } catch (Exception e) { }
        } 

        mainFrame.getFightPanel().getPlayerActionLabel().setText("stunned: 0");
        player.setIsStunned(false);
        player.setCanAttack(true);
        player.setCanBlock(true);
        player.setCanDodge(true);
    }
}
