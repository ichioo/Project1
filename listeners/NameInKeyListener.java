package listeners;

import java.awt.event.*;
import javax.swing.*;

import characters.Player;
import frames.*;

public class NameInKeyListener implements KeyListener {

    private MainFrame mainFrame;
    private JLabel nameInsertLabel;

    public NameInKeyListener (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        nameInsertLabel = mainFrame.getNameInPanel().getNameInsertLabel();

    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        String playerName;

        int baseTextLen = 18;
        int maxNameLen = 10;

        //boolean condition values
        boolean isDeleteBar = e.getKeyCode() == 8;
        boolean isDeletable = nameInsertLabel.getText().length() >= baseTextLen; // so that the base text of the nameInsertLabel doesnt get deleted
        boolean isMaxLength = nameInsertLabel.getText().length() >= maxNameLen + baseTextLen;
        boolean isAValidKey = e.getKeyCode() <= 90 && e.getKeyCode() >= 65; //Aa-Zz
        boolean isSpace = e.getKeyCode() == 32;
        boolean isEnterKey = e.getKeyCode() == 10;

        //writing or deleteing
        if (isDeleteBar && isDeletable) {
            nameInsertLabel.setText(deleteFromLabelText(nameInsertLabel.getText()));

        } else if(!isMaxLength && (isAValidKey || isSpace)){
            //to write takes the text on the label and adds the key
            nameInsertLabel.setText(nameInsertLabel.getText() + e.getKeyChar());
        }

        //when pressed enter key
        if(isEnterKey) {
            playerName = nameInsertLabel.getText().substring(17);
            mainFrame.setPlayer(new Player(playerName));
            mainFrame.changeToHome();
            System.out.println("NameInKeyListener: enter");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) { }

    //Other methods
    public String deleteFromLabelText (String labelText) {
        //transforms the labelText into a char array, loops in all the elements -1 putting them inside a string that is returned

        String returnText = "";
        char[] charArr;

        try {
            charArr = new char[labelText.length()-1];

            for (int i=0; i<labelText.length()-1; i++) {    
                charArr[i] = labelText.charAt(i);
            }
            for (int i=0; i<labelText.length()-1; i++) {    
                returnText += charArr[i]; 
            }
        } catch (Exception e) { }

        return returnText;
    } 
    
}
