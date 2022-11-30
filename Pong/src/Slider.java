/**********************************************************************
 * @file Slider.java
 * @brief holds main method
 * @author Tim Hultan, Jeevan Graywal, Roman Conway, Jack Cutler
 * @date: Nov 30
 * @acknowledgement: https://www.youtube.com/watch?v=oLirZqJFKPE
 ***********************************************************************/
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
