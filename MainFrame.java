
import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    StartPanel startPanel;

    public MainFrame () {
        //window panel
        startPanel = new StartPanel();
        this.getContentPane().add(startPanel);

        //--
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}

class StartPanel extends JPanel {
    JLabel label;

    public StartPanel () {

        //Components
        label = new JLabel("Label");
        label.setForeground(Color.white);


        //Add components
        this.add(label);

        //--
        this.setPreferredSize(new Dimension(600,600));
        this.setBackground(Color.BLACK);
    }

}
