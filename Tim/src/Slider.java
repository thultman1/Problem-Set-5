
import java.awt.*;
import java.awt.event.*;
public class Slider extends Rectangle{
    public static int y;
    int yVelocity;
    int speed = 10;


    Slider(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT){
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);

    }




    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);
    }

}
