package gamePanels;

import java.awt.*;
import javax.swing.*;
    
public class NameInPanel extends JPanel {
    public JLabel nameInsertLabel;

    public NameInPanel (Font gameFont) {
        //--
        setLayout(null);
        setPreferredSize(new Dimension(600,600));
        setBackground(Color.BLACK);

        
        //Components
        nameInsertLabel = new JLabel("Label");
        nameInsertLabel.setForeground(Color.white);
        nameInsertLabel.setFont(gameFont);
        nameInsertLabel.setBounds(80, 200, 425, 200);
        nameInsertLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        nameInsertLabel.setHorizontalAlignment(JLabel.CENTER);

        //Add components
        add(nameInsertLabel);
        
    }

}


