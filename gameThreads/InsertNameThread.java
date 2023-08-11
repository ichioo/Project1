package gameThreads;

import frames.MainFrame;

public class InsertNameThread extends Thread{

    private MainFrame mainFrame;

    public InsertNameThread (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void run() {
        nameInsert();
    }

    //Game phase methods
    public void nameInsert () {
        String text = "Enter your name: ";
        String effectString = "";

        //takes chars 1 by 1 form text and puts it into the effectString that is set as the text to the nameInseredLabel
        for (int i=0; i<text.length(); i++) {
            effectString += text.charAt(i);
            mainFrame.getNameInPanel().getNameInsertLabel().setText(effectString);

            try {
                Thread.sleep(50);
            } catch (Exception e) { }
        }
    }

}
