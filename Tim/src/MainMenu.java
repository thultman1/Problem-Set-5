import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class MainMenu {
    boolean gameStarted;
    final int WIDTH = 700, HEIGHT = 500;
    public MainMenu(boolean gameStarted,Graphics g) {
        this.gameStarted=gameStarted;
        if (!gameStarted) {
            g.setColor(Color.white);
            g.setFont(new Font("Monospaced", Font.PLAIN, 18));
            g.drawString("PONG GAME", 300, 100);
            g.setFont(new Font("Monospaced", Font.ITALIC, 14));
            g.drawString("Press 1 to play survival", 270, 130);
            g.drawString("Press 2 to play two player", 270, 164);
            g.drawString("Press 0 to exit at any time", 270, 198);

        }
    }



}

