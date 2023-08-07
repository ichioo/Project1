package frames;

import java.awt.*;
import java.io.File;
import javax.swing.*;

import characters.*;
import gamePanels.*;
import gameThreads.InsertNameThread;
import keyListeners.*;

public class MainFrame extends JFrame {
    //listeners
    public StartKeyListener startKeyListener;
    public NameInKeyListener nameInKeyListener;
    public FightKeyListener fightKeyListener;

    //panels
    public StartPanel startPanel;
    public NameInPanel nameInPanel;
    public FightPanel fightPanel;

    //-
    public InsertNameThread inNameThread;
    public Font gameFont;
    public Player player;

    public MainFrame () {
        createFont();

        //window panel
        startPanel = new StartPanel(gameFont);
        getContentPane().add(startPanel);

        //game manager and thread
        inNameThread = new InsertNameThread(this);

        //listener
        startKeyListener = new StartKeyListener(this);
        addKeyListener(startKeyListener);

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
    public void changeToNameInsert () {
        //changes the panel
        remove(startPanel);
        nameInPanel = new NameInPanel(gameFont);
        getContentPane().add(nameInPanel);
        validate();
        repaint();

        //changes the keylistener
        removeKeyListener(startKeyListener);
        startKeyListener = null;
        nameInKeyListener = new NameInKeyListener(this);
        addKeyListener(nameInKeyListener);

    }

    public void changeToFight () {
        //changes the panel
        remove(nameInPanel);
        fightPanel = new FightPanel(gameFont);
        getContentPane().add(fightPanel);
        validate();
        repaint();

        //changes the keylistener
        removeKeyListener(nameInKeyListener);
        nameInKeyListener = null;
        fightKeyListener = new FightKeyListener();
        addKeyListener(fightKeyListener);
        
    }
}
