/**********************************************************************
 * @file GamePanel2.java
 * @brief sets up second game mode and allows user to play in survival mode with timer and AI panel utilizing a best score method
 * @author Tim Hultan, Jeevan Graywal, Roman Conway, Jack Cutler
 * @date: Nov 30
 * @acknowledgement: https://www.youtube.com/watch?v=oLirZqJFKPE
 ***********************************************************************/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel2 extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    AIPaddle paddle2;
    Slider slider;
    Ball ball;
    Score score;
    Stopwatch timer;


    GamePanel2(){

        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        timer = new Stopwatch(GAME_WIDTH, GAME_HEIGHT);

        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        random = new Random();
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER,2);
    }
    public void newPaddles() {
        paddle1 = new Paddle(0,((GAME_HEIGHT/2)-(PADDLE_HEIGHT/2))-100,PADDLE_WIDTH,PADDLE_HEIGHT,1);

        paddle2 = new AIPaddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2)-1000,PADDLE_WIDTH,PADDLE_HEIGHT+10000);
        slider = new Slider(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2)-1000,PADDLE_WIDTH,PADDLE_HEIGHT+10000);
    }
    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }
    public void draw(Graphics g) {

        paddle1.draw(g);
        paddle2.draw(g);
        slider.draw(g);
        ball.draw(g);
        score.drawTimer(g);
        timer.draw(g);


        Toolkit.getDefaultToolkit().sync();

    }
    public void move() {
        paddle1.move();
        AIPaddle.y=ball.y-40;
        Slider.y=ball.y+60;
        ball.move();
    }
    public void checkCollision() {

        //bounce ball off top & bottom window edges
        if(ball.y <=0) {
            ball.setYDirection(-ball.yVelocity);
        }
        if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
        }
        //bounce ball off paddles
        if(ball.intersects(paddle1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; //optional for more difficulty
            if(ball.yVelocity>0)
                ball.yVelocity++; //optional for more difficulty
            else
                ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if(ball.intersects(paddle2)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; //optional for more difficulty
            if(ball.yVelocity>0)
                ball.yVelocity++; //optional for more difficulty
            else
                ball.yVelocity--;
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        //stops paddles at window edges
        if(paddle1.y<=0)
            paddle1.y=0;
        if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
        if(paddle2.y<=0)
            paddle2.y=0;
        if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
        //no score needed for the survival mode stopwatch

        if(ball.x <=0) {
            //score.player2++;
            timer.reset();
            timer.start();
            newPaddles();
            newBall();
            //System.out.println("Player 2: "+score.player2);
        }
        if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
            //score.player1++;
            timer.reset();
            timer.start();
            newPaddles();
            newBall();
            //System.out.println("Player 1: "+score.player1);


        }

    }
    public void run() {
        //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks =60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now -lastTime)/ns;
            lastTime = now;
            if(delta >=1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            //  paddle2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            //  paddle2.keyReleased(e);
        }
    }
}