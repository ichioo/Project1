package listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import frames.MainFrame;

public class FrameListener extends WindowAdapter {

    private MainFrame mainFrame;

    public FrameListener (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void windowClosing (WindowEvent e) {

        if (mainFrame.getGameSaverLoader().save(mainFrame.getPlayer()) == 0) {
            System.out.println("Player saved");
        }
        
        System.out.println("Frame closed");
    }

}
