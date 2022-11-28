import java.awt.Graphics;

public interface Paddle {
    void draw(Graphics g);
    void move();
    int getY();

    int getX();
}
