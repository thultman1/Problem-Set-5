/**********************************************************************
 * @file MainMenu.java
 * @brief allows users to choose game mode
 * @author Tim Hultan, Jeevan Graywal, Roman Conway, Jack Cutler
 * @date: Nov 30
 * @acknowledgement: https://www.youtube.com/watch?v=oLirZqJFKPE
 ***********************************************************************/

import java.awt.*;

public class MainMenu extends Rectangle{

    static int GAME_WIDTH;
    static int GAME_HEIGHT;

    MainMenu(int GAME_WIDTH, int GAME_HEIGHT){
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }
    public void draw(Graphics g) {


        g.setColor(Color.white);
        g.setFont(new Font("Monospaced", Font.ITALIC, 30));
        g.drawString("PONG GAME", 425, 200);
        g.setFont(new Font("Monospaced", Font.ITALIC, 18));
        g.drawString("Press 1 to play 2v2", 425, 260);
        g.drawString("Press 2 to play survival", 425, 290);
        g.drawString("Press 0 to exit", 425, 320);


    }
}