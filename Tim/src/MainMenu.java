import java.awt.*;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainMenu extends JFrame {
    GamePanel panel;
    static boolean gameRunning;
    Graphics gfx;
    Image img;
    Thread thread;
    static final int WIDTH = 700;
    final int HEIGHT = 500;

    public MainMenu(boolean gameRunning){

        this.gameRunning=gameRunning;
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Pong");

        this.setVisible(true);
        //thread = new Thread(this);
        thread.start();
        gameRunning=true;

    }

    public void paint(Graphics g) {
            g.setColor(Color.white);
            g.setFont(new Font("Monospaced", Font.PLAIN, 18));
            g.drawString("PONG GAME", 300, 100);
            g.setFont(new Font("Monospaced", Font.ITALIC, 14));
            g.drawString("Press Enter to begin", 270, 130);
    }

    public boolean getGameRunning()
    {
        return gameRunning;
    }


}
