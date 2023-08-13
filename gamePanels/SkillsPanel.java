package gamePanels;

import javax.swing.*;
import java.awt.*;


public class SkillsPanel extends JPanel {
    
    private JLabel[][] skillSlots;

    public SkillsPanel (
    ) {
        //--
        setLayout(null);
        setPreferredSize(new Dimension(600,600));
        setBackground(Color.gray);
        
        //Components
        int columns = 3;
        int rows = 5;
        skillSlots = new JLabel[rows][columns];

        int startX = 20;
        int startY = 50; 
        int width = 110;
        int height = 90;
        int ySpace = 10;
        int xSpace = 5;

        for (int column = 1; column <= columns; column++) {            
            for (int row = 1; row <= rows; row ++) {
                skillSlots[row-1][column-1] = new JLabel("row- " + row + " column- " + column);
                skillSlots[row-1][column-1].setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
                
                //idk how to explaing, basiclly inserts all the labels
                if (row == 1 && column == 1) {
                    skillSlots[row-1][column-1].setBounds(startX, startY, width, height);
                } else if (row == 1) {
                    skillSlots[row-1][column-1].setBounds(startX, startY, width, height);
                } else if (column == 1) {
                    skillSlots[row-1][column-1].setBounds(startX, skillSlots[row-2][column-1].getY() + height + ySpace, width, height);
                } else {
                    skillSlots[row-1][column-1].setBounds(skillSlots[row-2][column-2].getX() + width + xSpace, skillSlots[row-2][column-2].getY() + height + ySpace, width, height);
                }

                add(skillSlots[row-1][column-1]);
            }
            
            startX += width + xSpace;
        }

    }


}
