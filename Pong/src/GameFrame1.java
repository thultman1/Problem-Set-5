/**********************************************************************
 * @file GameFrame1.java
 * @brief sets up first game canvas
 * @author Tim Hultman, Jeevan Graywal, Roman Conway, Jack Cutler
 * @date: Nov 30
 * @acknowledgement: https://www.youtube.com/watch?v=oLirZqJFKPE
 ***********************************************************************/

import java.awt.*;
import javax.swing.*;

public class GameFrame1 extends JFrame{
    GamePanel1 panel;
    GameFrame1(){
        panel = new GamePanel1();
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.gray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }



}