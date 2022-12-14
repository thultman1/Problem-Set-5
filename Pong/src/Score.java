import java.awt.*;
/**********************************************************************
 * @file Score.java
 * @brief helps create score board
 * @author Tim Hultan, Jeevan Graywal, Roman Conway, Jack Cutler
 * @date: Nov 30
 * @acknowledgement: https://www.youtube.com/watch?v=oLirZqJFKPE
 ***********************************************************************/
public class Score extends Rectangle{

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1;
    int player2;
    int seconds_string;

    Score(int GAME_WIDTH, int GAME_HEIGHT){
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Consalas",Font.ITALIC,60));

        g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);

       g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (GAME_WIDTH/2)-85, 50);
       g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (GAME_WIDTH/2)+20, 50);
    }


    public void drawTimer(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Consolas",Font.ITALIC,60));

        g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
        //g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (GAME_WIDTH/2)-85, 50);
    }

}