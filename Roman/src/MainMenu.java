import java.util.Scanner;
import java.awt.*;


// main menu displays survival mode, competitve mode, and a quit button EXIT_ON_CLOSE functionality
public class MainMenu {

    public Rectangle survivalButton = new Rectangle(Tennis.WIDTH / 2 + 120, 150, 100, 50);
    public Rectangle competitiveButton = new Rectangle(Tennis.WIDTH / 2 + 120, 250, 100, 50);
    public Rectangle quitButton = new Rectangle(Tennis.WIDTH / 2 + 120, 350, 100, 50);

    public MainMenu() {

    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setFont(new Font("Monospaced", Font.PLAIN, 14));
        g.setColor(Color.white);
        g2d.draw(survivalButton);
        g2d.draw(competitiveButton);
        g2d.draw(quitButton);
    }
/*
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Monospaced", Font.BOLD, 24));
        g.drawString("PONG GAME", 300, 100);
        g.setFont(new Font("Monospaced", Font.PLAIN, 14));
        g.drawString("SURVIVAL MODE", 270, 130);
        g.drawString("COMPETITION MODE", 270, 100);
    }

 */
}
