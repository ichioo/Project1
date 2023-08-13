package keyListeners;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import frames.MainFrame;
import gamePanels.SkillsPanel;

public class SkillsPanelKeyListener implements KeyListener{

    private MainFrame mainFrame;
    private SkillsPanel skillsPanel;

    private JLabel[][] skillSlots; 
    private int[][] intSlots;

    //keys
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    private int currentBoxRow = 0;
    private int currentBoxCol = 0;

    public SkillsPanelKeyListener (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        skillsPanel = mainFrame.getSkillsPanel();
        skillSlots = skillsPanel.getSkillSlots();
        intSlots = new int[skillsPanel.getGridRows()][skillsPanel.getGridColumns()];

        turnOnBox(currentBoxRow, currentBoxCol);
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { 

        left = e.getKeyCode() == 37;
        right = e.getKeyCode() == 39;
        up = e.getKeyCode() == 38;
        down = e.getKeyCode() == 40;

        if (up && currentBoxRow != 0) {
            currentBoxRow -= 1;
        } else if (down && currentBoxRow != skillsPanel.getGridRows()-1) {
            currentBoxRow += 1;
        } else if (left && currentBoxCol != 0) {
            currentBoxCol -= 1;
        } else if (right && currentBoxCol != skillsPanel.getGridColumns()-1) {
            currentBoxCol += 1;
        }

        turnOnBox(currentBoxRow, currentBoxCol);
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    private void turnOnBox (int boxRow, int boxCol) {
        //turn off all boxes
        for (int column = 0; column < skillsPanel.getGridColumns(); column++) {
            for(int row = 0; row < skillsPanel.getGridRows(); row++) {
                intSlots[row][column] = 0;
                skillSlots[row][column].setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
            }
        } 

        //turn on selected box
        intSlots[boxRow][boxCol] = 1;
        skillSlots[boxRow][boxCol].setBorder(BorderFactory.createLineBorder(Color.white,3));
    }   
}
