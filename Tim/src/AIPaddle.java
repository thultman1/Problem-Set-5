
import java.awt.*;
import java.awt.event.*;
public class AIPaddle extends Rectangle{

    int yVelocity;
    int speed = 10;
    AIPaddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT){
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void move() {
        y= y + yVelocity;
    }

    public void draw(Graphics g) {
            g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }

}
