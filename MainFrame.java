
import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    StartPanel startPanel;
    GameManager gameManager;

    public MainFrame () {
        //window panel
        startPanel = new StartPanel();
        this.getContentPane().add(startPanel);

        //game manager and thread
        gameManager = new GameManager(this);
        Thread gamThread = new Thread(gameManager);
        gamThread.start();

        //--
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}

class StartPanel extends JPanel {
    JLabel nameInsert;

    public StartPanel () {

        //Components
        nameInsert = new JLabel("Label");
        nameInsert.setForeground(Color.white);

        //Add components
        this.add(nameInsert);

        //--
        this.setPreferredSize(new Dimension(600,600));
        this.setBackground(Color.BLACK);

    }

}
