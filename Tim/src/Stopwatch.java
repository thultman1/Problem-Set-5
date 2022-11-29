import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener {

    JFrame frame = new JFrame();
    //JButton startButton = new JButton("START");
    //JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);
    static int GAME_WIDTH;
    static int GAME_HEIGHT;

    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            elapsedTime = elapsedTime + 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);

        }

    });

    public Stopwatch(int GAME_WIDTH, int GAME_HEIGHT) {

        this.GAME_HEIGHT = GAME_HEIGHT;
        this.GAME_WIDTH = GAME_WIDTH;
        start();
        /*
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);

        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        frame.add(timeLabel);

        frame.setLayout(null);
        frame.setVisible(true);
        */

    }

    public void draw(Graphics g) {
        g.drawString(hours_string + ":" + minutes_string + ":" + seconds_string, (GAME_WIDTH/2)-85, 50);
    }

    /*
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==startButton) {

            if(started==false) {
                started=true;
                startButton.setText("STOP");
                start();
            }
            else {
                started=false;
                startButton.setText("START");
                stop();
            }

        }
        /*
        if(e.getSource()==resetButton) {
            started=false;
            startButton.setText("START");
            reset();
        }
        */



    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        elapsedTime=0;
        seconds =0;
        minutes=0;
        hours=0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
