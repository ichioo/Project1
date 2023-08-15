package frames;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import characters.*;
import gamePanels.*;
import gameSaverLoader.GameSaverLoader;
import gameThreads.*;
import listeners.*;

public class MainFrame extends JFrame {
    //listeners
    private StartKeyListener startKeyListener;
    private NameInKeyListener nameInKeyListener;
    private HomeKeyListener homeKeyListener;
    private FightKeyListener fightKeyListener;
    private SkillsPanelKeyListener skillsPanelKeyListener;
    private StatsKeyListener statsKeyListener;

    //panels
    private StartPanel startPanel;
    private NameInPanel nameInPanel;
    private HomePanel homePanel;
    private FightPanel fightPanel;
    private SkillsPanel skillsPanel;
    private StatsPanel statsPanel;

    //-
    private Thread thread;
    private Font gameFont;
    private Player player;

    private GameSaverLoader gameSaverLoader;

    public MainFrame () {
        setTitle("Game title");
        createFont();
        gameSaverLoader = new GameSaverLoader();

        //window panel
        startPanel = new StartPanel(gameFont);
        getContentPane().add(startPanel);

        //first thread
        thread = new InsertNameThread(this);

        //first listener
        startKeyListener = new StartKeyListener(this);
        addKeyListener(startKeyListener);

        //--
        addWindowListener(new FrameListener(this));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    // panel change methods
    public void changeToNameInsert () {
        //changes the panel
        removeCurrentPanel();
        nameInPanel = new NameInPanel(gameFont);
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
        homePanel = new HomePanel(gameFont);
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
        skillsPanel = new SkillsPanel();
        getContentPane().add(skillsPanel);
        validate();
        repaint();

        //changes the keylistener
        removeCurrentKeyListener();
        skillsPanelKeyListener = new SkillsPanelKeyListener(this);
        addKeyListener(skillsPanelKeyListener);

    }

    public void changeToStats () {
        //changes the panel
        removeCurrentPanel();
        statsPanel = new StatsPanel(gameFont, player);
        getContentPane().add(statsPanel);
        validate();
        repaint();

        //changes the keylistener
        removeCurrentKeyListener();
        statsKeyListener = new StatsKeyListener(this);
        addKeyListener(statsKeyListener);
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
    
    private void removeCurrentPanel () {
        //some panels are set to null because they are viewed only 1 time
        if(startPanel != null) {
            remove(startPanel);
            startPanel = null;
        }
        if(nameInPanel != null) {
            remove(nameInPanel);
            nameInPanel = null;
        }
        if(fightPanel != null) {
            remove(fightPanel);
            fightPanel = null;
        }
        if(homePanel != null) {
            remove(homePanel);
            homePanel = null;
        }
        if(skillsPanel != null) {
            remove(skillsPanel);
            skillsPanel = null;
        } 
        if(statsPanel != null) {
            remove(statsPanel);
            statsPanel = null;
        }
        
    }

    private void removeCurrentKeyListener () {
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
        if(skillsPanelKeyListener != null) {
            removeKeyListener(skillsPanelKeyListener);
            skillsPanelKeyListener = null;
        }
        if(statsKeyListener != null) {
            removeKeyListener(statsKeyListener);
            statsKeyListener = null;
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
    public SkillsPanel getSkillsPanel () {
        return skillsPanel;
    }
    // --
    public GameSaverLoader getGameSaverLoader () {
        return gameSaverLoader;
    }
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
