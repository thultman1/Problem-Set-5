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
    int prevTime = 0;
    int prevHours = 0;
    int prevSeconds = 0;
    int prevMinutes = 0;
    int bestTime = 0;
    int bestSeconds = 0;
    int bestMinutes = 0;
    int bestHours = 0;
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

    }

    public void draw(Graphics g) {
        g.setFont(new Font("Monospaced",Font.ITALIC,40));
        g.drawString(hours_string + ":" + minutes_string + ":" + seconds_string, (GAME_WIDTH/2) - 96, 50);
        g.setFont(new Font("Monospaced",Font.ITALIC,15));
        g.drawString("LAST TIME: " + String.format("%02d", prevHours) + ":" + String.format("%02d", prevMinutes) + ":" + String.format("%02d", prevSeconds), (GAME_WIDTH / 6), 50);
        g.setFont(new Font("Monospaced",Font.ITALIC,15));
        g.drawString("BEST TIME: "+ String.format("%02d", bestHours) + ":" + String.format("%02d", bestMinutes) + ":" + String.format("%02d", bestSeconds), ((GAME_WIDTH / 6) * 4), 50);
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

    public void bestRun(Graphics g) {
        g.drawString("BEST RUN: " + seconds_string, (GAME_WIDTH/2) + 50, 50);
    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        prevTime = elapsedTime;
        prevSeconds = seconds;
        prevMinutes = minutes;
        prevHours = hours;
        if ((prevSeconds > bestSeconds) || (prevMinutes > bestMinutes)) {
            bestSeconds = prevSeconds;
            bestMinutes = prevMinutes;
        }
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
