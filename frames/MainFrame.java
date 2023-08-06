package frames;

import java.awt.*;
import java.io.File;
import javax.swing.*;

import gameManager.GameManager;
import gamePanels.*;

public class MainFrame extends JFrame {
    public StartPanel startPanel;
    public FightPanel testPanel;

    public GameManager gameManager;
    public Font gameFont;


    public MainFrame () {
        createFont();

        //window panel
        startPanel = new StartPanel(gameFont);
        getContentPane().add(startPanel);

        //game manager and thread
        gameManager = new GameManager(this);
        Thread gamThread = new Thread(gameManager);
        gamThread.start();

        //--
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void createFont () {

        try { 
            gameFont = Font.createFont(Font.TRUETYPE_FONT, new File("UpheavalPro.ttf")).deriveFont(25f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("UpheavalPro.ttf")));

        } catch (Exception e) {
            System.out.println("Error, MainFrame, fontCreation");
        }
    }

    // panel change methods
    public void changeToFight () {
        remove(startPanel);

        testPanel = new FightPanel(gameFont);
        getContentPane().add(testPanel);
        validate();
        repaint();
        
    }
}
