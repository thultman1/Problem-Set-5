import java.awt.*;
import javax.swing.*;

public class MenuFrame extends JFrame{
    MenuPanel mPanel;
    MenuFrame(){
        mPanel = new MenuPanel();
        this.add(mPanel);
        this.setTitle("Main Menu");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }



}