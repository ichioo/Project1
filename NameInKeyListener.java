import java.awt.event.*;
import javax.swing.*;

public class NameInKeyListener implements KeyListener {

    MainFrame mainFrame;
    JLabel nameInsertLabel;

    public NameInKeyListener (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        nameInsertLabel = mainFrame.startPanel.nameInsert;

    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == 8 && nameInsertLabel.getText().length() >= 18) {
        //deletes if the code of the key corrispondes to the one of the delete bar
            nameInsertLabel.setText(deleteFromLabelText(nameInsertLabel.getText()));

        } else if(nameInsertLabel.getText().length() <= 28 && e.getKeyCode() <= 90 && e.getKeyCode() >= 65 || e.getKeyCode() == 32){
        //writes if the length is less then 28 (10 max name + 18 base text), if its a letter between Aa-Zz and if its space
            nameInsertLabel.setText(nameInsertLabel.getText() + e.getKeyChar());
        }

        //when pressed enter key
        if(e.getKeyCode() == 10) {
            System.out.println(nameInsertLabel.getText().substring(17));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    //Other methods
    public String deleteFromLabelText (String labelText) {
        //it takes the text from the label and deletes 1 char

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
