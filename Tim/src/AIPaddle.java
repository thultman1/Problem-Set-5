import java.awt.*;
import java.awt.event.*;
public class AIPaddle extends Rectangle{
    public static int y;
    int yVelocity;
    int speed = 10;


    AIPaddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT){
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);

    }



    public void move() {
        //  y=Ball.y-40;
    }
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }

}
