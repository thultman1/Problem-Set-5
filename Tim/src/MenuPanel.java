import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class MenuPanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    MainMenu mainMenu;
    static public int gameChoice=10;

    MenuPanel(){

        mainMenu = new MainMenu(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }


    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }
    public void draw(Graphics g) {
        mainMenu.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }


    public void run() {
        //game loop
    }



    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_1) {
                gameChoice=1;
                PongGame.mFrame.dispose();
                GameFrame1 frame=new GameFrame1();

            } else if (e.getKeyCode() == KeyEvent.VK_2) {
               gameChoice=2;
                PongGame.mFrame.dispose();
                GameFrame2 frame=new GameFrame2();

            } else if (e.getKeyCode() == KeyEvent.VK_0) {
                System.exit(0);
            }

        }

    }


}