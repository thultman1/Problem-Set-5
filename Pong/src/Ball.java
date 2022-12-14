/**********************************************************************
 * @file Ball.java
 * @brief creating the ball and initializing velocity and direction
 * @author Tim Hultman, Jeevan Graywal, Roman Conway, Jack Cutler
 * @date: Nov 30
 * @acknowledgement: https://www.youtube.com/watch?v=oLirZqJFKPE
 ***********************************************************************/


import java.awt.*;
import java.util.*;

public class Ball extends Rectangle{

    Random random;
    int xVelocity;
    int yVelocity;
   int initialSpeed;

    Ball(int x, int y, int width, int height, int initialSpeed){
        super(x,y,width,height);
        this.initialSpeed=initialSpeed;
        random = new Random();
        int randomXDirection = random.nextInt(2);
        if(randomXDirection == 0)
            randomXDirection--;
        setXDirection(randomXDirection*initialSpeed);

        int randomYDirection = random.nextInt(2);
        if(randomYDirection == 0)
            randomYDirection--;
        setYDirection(randomYDirection*initialSpeed);

    }

    public void setXDirection(int randomXDirection) {
        xVelocity = randomXDirection;
    }
    public void setYDirection(int randomYDirection) {
        yVelocity = randomYDirection;
    }
    public void move() {
        x += xVelocity;
        y += yVelocity;
    }


    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, height, width);
    }
}