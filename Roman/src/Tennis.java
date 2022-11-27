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
    ScoreBoard s1;
    boolean gameStarted;
    Graphics gfx;
    Image img;

    final int WIDTH = 700, HEIGHT = 500;
    public Tennis() {
        gameStarted = false;
        p1 = new HumanPaddle(1);
        b1 = new Ball();
        p2 = new AIPaddle(2, b1);
        s1 = new ScoreBoard();
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
        if (b1.getX() < -10 || b1.getX() > 710) {
            g.setColor(Color.red);
            g.setFont(new Font("Monospaced", Font.BOLD, 24));
            g.drawString("GAME OVER", 300, 250);
        } else {
            p1.draw(g);
            b1.draw(g);
            p2.draw(g);

        }
        // trying to find collision
        // checking that getX of paddle and getX of the ball is equal
        // checking the get Y was equal
        // didn't work for some reason
        //
       // while(b1.getX()-10  p1.getX()){
         //   s1.update();

        //System.out.println(b1.getX());
        //System.out.println(p1.getX());


            //p1.getX() - b1.getX < 5 and p1.getX() - b1.getY() < 5



        if (!gameStarted) {
            g.setColor(Color.white);
            g.setFont(new Font("Monospaced", Font.PLAIN, 18));
            g.drawString("PONG GAME", 300, 100);
            g.setFont(new Font("Monospaced", Font.ITALIC, 14));
            g.drawString("Press Enter to begin", 270, 130);
        }
        //g.drawImage(img, 0, 0, this);

    }

    public void update(Graphics g) {
        paint(g);
    }

    public void run() {
        for (;;) {
            if (gameStarted) {
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

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameStarted = true;
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
