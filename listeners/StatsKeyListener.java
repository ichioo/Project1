package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import frames.MainFrame;

public class StatsKeyListener implements KeyListener, Serializable {

    private MainFrame mainFrame;

    private boolean esc;

    public StatsKeyListener (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {

        esc = e.getKeyCode() == 27;

        if (esc) {
            mainFrame.changeToHome();
            System.out.println("StatsKeyListener : esc");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
    
}
