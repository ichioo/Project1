package listeners;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import frames.MainFrame;
import gamePanels.SkillsPanel;

public class SkillsPanelKeyListener implements KeyListener, Serializable{

    private MainFrame mainFrame;
    private SkillsPanel skillsPanel;

    private JLabel[][] skillSlots; 
    private int[][] intSlots;

    private JLabel[] equipSlots;
    private int currentEquipBox = 0;

    private boolean isInEquipped = false;
    private boolean isBoxEmpty;

    //keys
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;
    private boolean enter;
    private boolean esc;

    private int currentBoxRow = 0;
    private int currentBoxCol = 0;

    public SkillsPanelKeyListener (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        skillsPanel = mainFrame.getSkillsPanel();
        skillSlots = skillsPanel.getSkillSlots();

        intSlots = new int[skillsPanel.getGridRows()][skillsPanel.getGridColumns()];
        equipSlots = skillsPanel.getEquippedSkillSlots();

        turnOnBox(currentBoxRow, currentBoxCol);
        skillsPanel.seeSkillDetails(currentBoxCol, currentBoxRow);
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { 

        left = e.getKeyCode() == 37;
        right = e.getKeyCode() == 39;
        up = e.getKeyCode() == 38;
        down = e.getKeyCode() == 40;
        enter = e.getKeyCode() == 10;
        esc = e.getKeyCode() == 27;

        //in equip section
        if (up && currentBoxRow == 0) {
            turnOnEquippedBox();
        } else if (down && isInEquipped) {
            isInEquipped = false;
            turnOffEquippedSection();
            currentBoxRow = -1;
        } else if (right && isInEquipped && currentEquipBox != 3) {
            currentEquipBox++;
            turnOnEquippedBox();
        } else if (left && isInEquipped && currentEquipBox != 0) {
            currentEquipBox--;
            turnOnEquippedBox();
        }

        //in all section
        if (up && currentBoxRow != 0) {
            currentBoxRow -= 1;
        } else if (down && currentBoxRow != skillsPanel.getGridRows()-1 ) {
            currentBoxRow += 1;
        } else if (left && currentBoxCol != 0) {
            currentBoxCol -= 1;
        } else if (right && currentBoxCol != skillsPanel.getGridColumns()-1) {
            currentBoxCol += 1;
        }
        //turns on the box when not in equipped
        if (!isInEquipped) {
            turnOnBox(currentBoxRow, currentBoxCol);
            skillsPanel.seeSkillDetails(currentBoxCol, currentBoxRow);
        }

        // -- 
        if (enter) {
            isBoxEmpty = skillSlots[currentBoxRow][currentBoxCol].getText().equals(""); 

            if (isInEquipped) {
                mainFrame.getPlayer().unequipSkill(currentEquipBox);
                skillsPanel.updateEquippedSkills();

            } else if (!isBoxEmpty) {
                try {
                    mainFrame.getPlayer().equipSkill(skillsPanel.getSkill(currentBoxCol, currentBoxRow));
                    skillsPanel.updateEquippedSkills();
                } catch (Exception ex) { }
            }
        }

        if (esc) {
            mainFrame.changeToHome();
            System.out.println("SkillsPanelKeyListener : esc");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    //boxes turn off/on
    private void turnOnEquippedBox () {
        turnOffEquippedSection();

        equipSlots[currentEquipBox].setBorder(BorderFactory.createLineBorder(Color.white,3));
        isInEquipped = true;

        turnOffAllSection();
    }

    private void turnOnBox (int boxRow, int boxCol) {
        turnOffAllSection();

        //turn on selected box
        intSlots[boxRow][boxCol] = 1;
        skillSlots[boxRow][boxCol].setBorder(BorderFactory.createLineBorder(Color.white,3));
    }
    
    private void turnOffAllSection () {

        for (int column = 0; column < skillsPanel.getGridColumns(); column++) {
            for(int row = 0; row < skillsPanel.getGridRows(); row++) {
                intSlots[row][column] = 0;
                skillSlots[row][column].setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
            }
        }
    }

    private void turnOffEquippedSection () {

        for (int slot = 0; slot < 4; slot++) {
            equipSlots[slot].setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        }
    }
}
