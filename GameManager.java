
import javax.swing.*;

//Used to manage game phases: start, fight, ...
public class GameManager {
    MainFrame mainFrame;

    public GameManager (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        startOfGame();
    }

    //Game fase methods
    public void startOfGame() {
        char CURSOR = '_';

        JLabel enterNameLabel = mainFrame.startPanel.label;
        String text = "Enter your name: ";
        String labelText = "";
        
        //Char array used to make the cursor effect
        char[] stringArr = new char[text.length()+1];

        //Loop that makes the "writing effect" of the text and creates the stringArr
        for(int i=0; i<text.length(); i++) {

            labelText += text.charAt(i);
            enterNameLabel.setText(labelText);
            stringArr[i] = text.charAt(i);

            try {
                Thread.sleep(30);
            } catch (Exception e) {}
        }
        
        //Loops to make the cursor effect
        while (true) {
            
            stringArr[stringArr.length-1] = ' ';
            enterNameLabel.setText(makeString(stringArr));

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}

            stringArr[stringArr.length-1] = CURSOR;
            enterNameLabel.setText(makeString(stringArr));
            
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }

    //Other methods
    public static String makeString(char[] charArr) {

        String returnString = "";

        for(int i=0; i<charArr.length; i++) {
            returnString += charArr[i];
        }

        return returnString;
    }
}
