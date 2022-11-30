/**********************************************************************
 * @file MenuFrame.java
 * @brief creates canvas for the menu
 * @author Tim Hultan, Jeevan Graywal, Roman Conway, Jack Cutler
 * @date: Nov 30
 * @acknowledgement: https://www.youtube.com/watch?v=oLirZqJFKPE
 ***********************************************************************/

import java.awt.*;
import javax.swing.*;

public class MenuFrame extends JFrame{
    MenuPanel mPanel;
    MenuFrame(){
        mPanel = new MenuPanel();
        this.add(mPanel);
        this.setTitle("Main Menu");
        this.setResizable(false);
        this.setBackground(Color.pink);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }



}