import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
// Original program includes applet; adapted to include JFrame

public class Tennis extends JFrame implements Runnable, KeyListener {
    Thread thread;
    HumanPaddle p1;
    AIPaddle p2;
    Ball b1;
    boolean gameStarted1=false;
    boolean gameStarted2=false;
    Graphics gfx;
    Image img;
    boolean gameOver=false;

    final int WIDTH = 700, HEIGHT = 500;
    public Tennis() {

        p1 = new HumanPaddle(1);
        b1 = new Ball();
        p2 = new AIPaddle(2, b1);
        //img = createImage(WIDTH, HEIGHT);
        //gfx = img.getGraphics();
        //fontTitle = new Font();

        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Pong");
        this.addKeyListener(this);
        this.setVisible(true);
        thread = new Thread(this);
        thread.start();
    }


    public static void main(String[] args) {
        Tennis game1 = new Tennis();
        game1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        MainMenu mainMenu= new MainMenu(gameStarted1,g);

        if(gameStarted1==true) {
            if (b1.getX() < -10 || b1.getX() > 710) {
                // gameStarted=false;
                g.setColor(Color.red);
                g.setFont(new Font("Monospaced", Font.BOLD, 24));
                g.drawString("GAME OVER!", 300, 250);
                g.drawString("0 to exit and retry", 300, 284);




            } else {
                p1.draw(g);
                b1.draw(g);
                p2.draw(g);
            }
        }


    }

    public void update(Graphics g) {
        paint(g);
    }

    public void run() {
        for (;;) {
            if (gameStarted1 == true) {
                if (gameStarted1) {
                    p1.move();
                    p2.move();
                    b1.move();
                    b1.checkPaddleCollision(p1, p2);
                }

                repaint();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(true);
        }

        else if (e.getKeyCode() == KeyEvent.VK_1) {
            gameStarted1 = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_2) {
            gameStarted2 = true;
        }
        else if (e.getKeyCode() ==KeyEvent.VK_0 ){
            System.exit(0);
        }



    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(false);
        }

    }

    public void keyTyped(KeyEvent e) {
    }


}
