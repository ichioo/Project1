package frames;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import characters.*;
import gamePanels.*;
import gameThreads.*;
import keyListeners.*;

public class MainFrame extends JFrame {
    //listeners
    private StartKeyListener startKeyListener;
    private NameInKeyListener nameInKeyListener;
    private HomeKeyListener homeKeyListener;
    private FightKeyListener fightKeyListener;

    //panels
    private StartPanel startPanel;
    private NameInPanel nameInPanel;
    private HomePanel homePanel;
    private FightPanel fightPanel;
    private SkillsPanel skillsPanel;

    //-
    private Thread thread;
    private Font gameFont;
    private Player player;

    public MainFrame () {
        createFont();
        createAllPanels();

        //window panel
        startPanel = new StartPanel(gameFont);
        getContentPane().add(startPanel);
        // homePanel = new HomePanel(gameFont);
        // getContentPane().add(homePanel);

        //first thread
        thread = new InsertNameThread(this);

        //first listener
        startKeyListener = new StartKeyListener(this);
        addKeyListener(startKeyListener);

        //--
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }
    
    //--
    public void createAllPanels () {
        startPanel = new StartPanel(gameFont);
        nameInPanel = new NameInPanel(gameFont);
        fightPanel = new FightPanel(gameFont);
        homePanel = new HomePanel(gameFont);
        skillsPanel = new SkillsPanel();

    }

    // panel change methods
    public void changeToNameInsert () {
        //changes the panel
        removeCurrentPanel();
        getContentPane().add(nameInPanel);
        validate();
        repaint();

        //changes the keylistener
        removeCurrentKeyListener();
        nameInKeyListener = new NameInKeyListener(this);
        addKeyListener(nameInKeyListener);

    }

    public void changeToHome () {
        //changes the panel
        removeCurrentPanel();
        getContentPane().add(homePanel);
        validate();
        repaint();

        //changes the keylistener
        removeCurrentKeyListener();
        homeKeyListener = new HomeKeyListener(this);
        addKeyListener(homeKeyListener);

    }

    public void changeToFight () {
        //changes the panel
        removeCurrentPanel();
        fightPanel = new FightPanel(gameFont);
        getContentPane().add(fightPanel);
        validate();
        repaint();

        //changes the keylistener
        removeCurrentKeyListener();
        fightKeyListener = new FightKeyListener();
        addKeyListener(fightKeyListener);

        //changes thread
        thread = new FightThread();
        ((FightThread) thread).addFightPanel(fightPanel);
        thread.start();
        
    }

    public void changeToSkills () {
        //changes the panel
        removeCurrentPanel();
        getContentPane().add(skillsPanel);
        validate();
        repaint();

        //changes the keylistener
        // removeCurrentKeyListener();
        // homeKeyListener = new HomeKeyListener(this);
        // addKeyListener(homeKeyListener);

    }

    //--
    public void createFont () {
        try { 
            gameFont = Font.createFont(Font.TRUETYPE_FONT, new File("UpheavalPro.ttf")).deriveFont(25f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("UpheavalPro.ttf")));

        } catch (Exception e) {
            System.out.println("Error, MainFrame, fontCreation");
        }
    }
    
    public void removeCurrentPanel () {
        if(startPanel != null) {
            remove(startPanel);
        }
        if(nameInPanel != null) {
            remove(nameInPanel);
        }
        if(fightPanel != null) {
            remove(fightPanel);
        }
        if(homePanel != null) {
            remove(homePanel);
        }
    }

    public void removeCurrentKeyListener () {
        if(startKeyListener != null) {
            removeKeyListener(startKeyListener);
            startKeyListener = null;
        }
        if(nameInKeyListener != null) {
            removeKeyListener(nameInKeyListener);
            nameInKeyListener = null;
        }
        if(fightKeyListener != null) {
            removeKeyListener(fightKeyListener);
            fightKeyListener = null;
        }
        if(homeKeyListener != null) {
            removeKeyListener(homeKeyListener);
            homeKeyListener = null;
        }
    }

    //gets
    // -- key listeners
    public StartKeyListener getStartKeyListener () {
        return startKeyListener;
    }
    public NameInKeyListener getNameInKeyListener () {
        return nameInKeyListener;
    }
    public HomeKeyListener getHomeKeyListener () {
        return homeKeyListener;
    }
    public FightKeyListener getFightKeyListener () {
        return fightKeyListener;
    }
    // -- panels
    public StartPanel getStartPanel () {
        return startPanel;
    }
    public NameInPanel getNameInPanel () {
        return nameInPanel;
    }
    public HomePanel getHomePanel () {
        return homePanel;
    }
    public FightPanel getFightPanel () {
        return fightPanel;
    }
    // --
    public Thread getCurrentThread () {
        return thread;
    }
    public Font getFont () {
        return gameFont;
    }
    public Player getPlayer () {
        return player;
    }

    //sets
    public void setPlayer (Player player) {
        this.player = player;
    }
}
