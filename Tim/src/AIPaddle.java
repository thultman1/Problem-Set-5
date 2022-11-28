
import java.awt.*;
import java.awt.event.*;
public class AIPaddle extends Rectangle{
    int id;
    int yVelocity;
    int speed = 10;

    AIPaddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.id=id;
    }



    public void move() {
       // y=Ball.y;
    }
    public void draw(Graphics g) {
        if(id==1)
            g.setColor(Color.blue);
        else
            g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }

}
