
import java.awt.*;
import java.io.File;
import javax.swing.*;

public class MainFrame extends JFrame {
    StartPanel startPanel;
    GameManager gameManager;
    Font gameFont;


    public MainFrame () {
        createFont();

        //window panel
        startPanel = new StartPanel(gameFont);
        this.getContentPane().add(startPanel);

        //game manager and thread
        gameManager = new GameManager(this);
        Thread gamThread = new Thread(gameManager);
        gamThread.start();

        //--
        this.pack();
        this.setResizable(true);
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
}

class StartPanel extends JPanel {
    JLabel nameInsert;

    public StartPanel (Font gameFont) {
        //--
        this.setLayout(null);
        this.setPreferredSize(new Dimension(600,600));
        this.setBackground(Color.BLACK);

        
        //Components
        nameInsert = new JLabel("Label");
        nameInsert.setForeground(Color.white);
        nameInsert.setFont(gameFont);
        nameInsert.setBounds(80, 200, 425, 200);
        nameInsert.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        nameInsert.setHorizontalAlignment(JLabel.CENTER);

        //Add components
        this.add(nameInsert);
        
    }

}
