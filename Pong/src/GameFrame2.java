/**********************************************************************
 * @file GameFrame.java
 * @brief sets up second game mode
 * @author Tim Hultman, Jeevan Graywal, Roman Conway, Jack Cutler
 * @date: Nov 30
 * @acknowledgement: https://www.youtube.com/watch?v=oLirZqJFKPE
 ***********************************************************************/

import java.awt.*;
import javax.swing.*;

public class GameFrame2 extends JFrame{
    GamePanel2 panel;
    GameFrame2(){
        panel = new GamePanel2();
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }



}