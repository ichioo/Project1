package gameSaverLoader;

import java.io.*;
import javax.swing.JFileChooser;
import characters.Player;

public class GameSaverLoader {

    public Player load () {

        Player loadedPlayer = new Player("");
            
        File loadedFile = new File("");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\utente\\Desktop"));

        try {
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                loadedFile = fileChooser.getSelectedFile();

                FileInputStream fIn = new FileInputStream(loadedFile);
                ObjectInputStream objIn = new ObjectInputStream(fIn);

                //loading player
                loadedPlayer = (Player) objIn.readObject();

                //--
                objIn.close();
                fIn.close();
            } else {
                return null;
            }

            return loadedPlayer;
        } catch (Exception e) {
            
            System.out.println("GameSaverLoader, load: error - " + e.getMessage());
        }

        return null;
    }

    public int save (Player player) {

        String savePath = "C:\\Users\\utente\\Desktop\\";

        try {

            FileOutputStream fOut = new FileOutputStream(savePath + player.getName() + "Saves.dat");
            ObjectOutputStream objOut = new ObjectOutputStream(fOut);

            objOut.writeObject(player);

            objOut.flush();
            fOut.close();

            return 0;
        } catch (Exception e) {

            System.out.println("GameSaverLoader, save: error - " + e.getMessage());
        }

        return 1;
    }

}
