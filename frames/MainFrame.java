package frames;

import java.awt.*;
import java.io.File;
import javax.swing.*;

import characters.*;
import gameManager.GameManager;
import gamePanels.*;
import keyListeners.*;

public class MainFrame extends JFrame {
    public NameInKeyListener nameInKeyListener;
    public FightKeyListener fightKeyListener;

    public StartPanel startPanel;
    public FightPanel fightPanel;

    public GameManager gameManager;
    public Font gameFont;

    public Player player;

    public MainFrame () {
        createFont();

        //window panel
        startPanel = new StartPanel(gameFont);
        getContentPane().add(startPanel);

        //game manager and thread
        gameManager = new GameManager(this);
        Thread gamThread = new Thread(gameManager);
        gamThread.start();

        //listener
        nameInKeyListener = new NameInKeyListener(this);
        addKeyListener(nameInKeyListener);

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
        //changes the keylistener
        removeKeyListener(nameInKeyListener);
        nameInKeyListener = null;
        fightKeyListener = new FightKeyListener();
        addKeyListener(fightKeyListener);

        //changes the panel
        remove(startPanel);
        fightPanel = new FightPanel(gameFont);
        getContentPane().add(fightPanel);
        validate();
        repaint();
        
    }
}
