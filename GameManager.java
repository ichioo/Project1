
//Used to manage game phases: start, fight, ...
public class GameManager implements Runnable{

    MainFrame mainFrame;

    public GameManager (MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void run() {
        nameInsert();
    }

    //Game fase methods
    public void nameInsert() {
        mainFrame.addKeyListener(new NameInKeyListener(mainFrame));

        String text = "Enter your name: ";
        String effectString = "";

        for (int i=0; i<text.length(); i++) {
            effectString += text.charAt(i);

            mainFrame.startPanel.nameInsert.setText(effectString);

            try {
                Thread.sleep(50);
            } catch (Exception e) { }
        }
    }

}
